package org.example.domain;

import org.example.enums.TipoConta;
import org.example.enums.TipoVinculo;
import org.example.exceptions.conta.*;
import org.example.exceptions.transacoes.SaldoInsuficienteException;
import org.example.exceptions.transacoes.ValorIndevidoException;
import org.example.exceptions.vinculo.PessoaVinculadaException;
import org.example.exceptions.vinculo.TiposDePessoasDiferentesException;
import org.example.service.VinculoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaConjuntaTest {
    VinculoService vinculoService = new VinculoService();
    Endereco endereco = new Endereco("Brasil", "Paraná", "Maringá", "Avenida Guedner", "0000", "Na Unicesumar");
    PessoaFisica pessoaFisica1 = new PessoaFisica("122.122.122-55", "Pessoa1", endereco);
    PessoaFisica pessoaFisica2 = new PessoaFisica("133.133.133-55", "Pessoa2", endereco);

    PessoaFisica pessoaFisica3 = new PessoaFisica("144.144.144-55", "Pessoa3", endereco);
    PessoaFisica pessoaFisica4 = new PessoaFisica("155.155.155-55", "Pessoa4", endereco);

    @Test
    public void deveCriarContaConjuntaPoupancaPessoasFisicasComVinculo() throws ContaSemTipoException, ContaConjuntaSemTitularesException, TitularesIguaisExcepton, VinculoPessoaDiferenteException, PessoaVinculadaException, ContaPoupancaValorAberturaIndevidoException, ContaConjuntaEmpresarialException {

        vinculoService.vincularPessoas(pessoaFisica1, pessoaFisica2, TipoVinculo.UNIAO_CIVIL);

        ContaConjunta conta = new ContaConjunta(TipoConta.POUPANCA, pessoaFisica1, pessoaFisica2, 50.00);

    }

    @Test
    public void deveRealizarPagamento() throws ContaSemTipoException, ContaPoupancaValorAberturaIndevidoException, ContaConjuntaSemTitularesException, TitularesIguaisExcepton, ContaConjuntaEmpresarialException, VinculoPessoaDiferenteException, PessoaVinculadaException, SaldoInsuficienteException, ValorIndevidoException {
        vinculoService.vincularPessoas(pessoaFisica1, pessoaFisica2, TipoVinculo.UNIAO_CIVIL);

        ContaConjunta conta1 = new ContaConjunta(TipoConta.POUPANCA, pessoaFisica1, pessoaFisica2, 50.00);
        ContaConjunta conta2 = new ContaConjunta(TipoConta.POUPANCA, pessoaFisica1, pessoaFisica2, 50.00);

        try {
            conta1.pagar(25.00, conta2);
            Assertions.assertEquals(25.00, conta1.getSaldo());
            Assertions.assertEquals(75.00, conta2.getSaldo());
        } catch (SaldoInsuficienteException e){
            Assertions.assertEquals("Saldo insuficiente.", e.getMessage());
        }
    }

    @Test
    public void deveRealizarDeposito() throws PessoaVinculadaException, ContaSemTipoException, ContaPoupancaValorAberturaIndevidoException, ContaConjuntaSemTitularesException, TitularesIguaisExcepton, ContaConjuntaEmpresarialException, VinculoPessoaDiferenteException, ValorIndevidoException {
        vinculoService.vincularPessoas(pessoaFisica1, pessoaFisica2, TipoVinculo.UNIAO_CIVIL);

        ContaConjunta conta1 = new ContaConjunta(TipoConta.POUPANCA, pessoaFisica1, pessoaFisica2, 50.00);

        try {
            conta1.depositar(50.00);

            Assertions.assertEquals(100.0, conta1.getSaldo());
        } catch (ValorIndevidoException e) {
            Assertions.assertEquals("O valor não pode ser menor ou igual a zero.", e.getMessage());
        }

    }

}
