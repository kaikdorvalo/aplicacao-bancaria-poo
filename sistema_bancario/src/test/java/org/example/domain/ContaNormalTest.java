package org.example.domain;

import org.example.enums.TipoConta;
import org.example.enums.TipoVinculo;
import org.example.enums.aplicacoes.AcoesBolsaDeValores;
import org.example.exceptions.conta.*;
import org.example.exceptions.transacoes.SaldoInsuficienteException;
import org.example.exceptions.transacoes.ValorIndevidoException;
import org.example.exceptions.vinculo.PessoaVinculadaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContaNormalTest {

    Endereco endereco = new Endereco("Brasil", "Paraná", "Maringá", "Avenida Guedner", "0000", "Na Unicesumar");
    PessoaFisica pessoaFisica1 = new PessoaFisica("122.122.122-55", "Pessoa1", endereco);
    PessoaFisica pessoaFisica2 = new PessoaFisica("133.133.133-55", "Pessoa1", endereco);

    @Test
    public void deveCriarContaNormalPoupancaPessoaFisica() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException {

        ContaNormal conta = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 100.00);

    }

    @Test
    public void deveRealizarPagamento() throws ContaSemTipoException, ContaPoupancaValorAberturaIndevidoException, ValorIndevidoException, ContaNormalSemTitularException {

        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 50.00);
        ContaNormal conta2 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica2, 50.00);

        try {
            conta1.pagar(25.00, conta2);
            Assertions.assertEquals(25.00, conta1.getSaldo());
            Assertions.assertEquals(75.00, conta2.getSaldo());
        } catch (SaldoInsuficienteException e){
            Assertions.assertEquals("Saldo insuficiente.", e.getMessage());
        }

    }

    @Test
    public void deveRealizarDeposito() throws ContaSemTipoException, ContaPoupancaValorAberturaIndevidoException, ContaNormalSemTitularException {

        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 50.00);

        try {
            conta1.depositar(50.00);
            Assertions.assertEquals(100.0, conta1.getSaldo());
        } catch (ValorIndevidoException e) {
            Assertions.assertEquals("O valor não pode ser menor ou igual a zero.", e.getMessage());
        }

    }

    @Test
    public void deveRemoverSaldoConta() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException, SaldoInsuficienteException, ValorIndevidoException {
        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 50.00);
        conta1.removerSaldo(50.0);

        Assertions.assertEquals(0.0, conta1.getSaldo());
    }

    @Test
    public void deveComprarAcao() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException, SaldoInsuficienteException, TipoContaNullException, ValorIndevidoException {
        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 110.00);

        String resultado1 = conta1.comprarAcao(AcoesBolsaDeValores.ACAO_IBOVESPA, 1);
        String resultado2 = conta1.comprarAcao(AcoesBolsaDeValores.ACAO_BANCO_D0_BRASIL, 1);

        Assertions.assertEquals("Você comprou 1 ação(ões) do tipo Ação da Ibovespa no valor de R$ 34.0", resultado1);
        Assertions.assertEquals("Você comprou 1 ação(ões) do tipo Ação do Banco do Brasil no valor de R$ 50.0", resultado2);
        Assertions.assertEquals(26.0, conta1.getSaldo());

        List<AcoesBolsaDeValores> acoes = conta1.getAcoes();

        Assertions.assertEquals(acoes.get(0), AcoesBolsaDeValores.ACAO_IBOVESPA);
        Assertions.assertEquals(acoes.get(1), AcoesBolsaDeValores.ACAO_BANCO_D0_BRASIL);
    }

}
