package org.example.service;

import org.example.domain.ContaNormal;
import org.example.domain.Endereco;
import org.example.domain.PessoaFisica;
import org.example.enums.TipoConta;
import org.example.enums.aplicacoes.AcoesBolsaDeValores;
import org.example.exceptions.conta.ContaNormalSemTitularException;
import org.example.exceptions.conta.ContaPoupancaValorAberturaIndevidoException;
import org.example.exceptions.conta.ContaSemTipoException;
import org.example.exceptions.conta.TipoContaNullException;
import org.example.exceptions.transacoes.SaldoInsuficienteException;
import org.example.exceptions.transacoes.ValorIndevidoException;
import org.junit.jupiter.api.Test;

public class ExtratoServiceTest {

    Endereco endereco = new Endereco("Brasil", "Paraná", "Maringá", "Avenida Guedner", "0000", "Na Unicesumar");

    PessoaFisica pessoaFisica1 = new PessoaFisica("122.122.122-55", "Pessoa1", endereco);
    PessoaFisica pessoaFisica2 = new PessoaFisica("133.133.133-55", "Pessoa1", endereco);

    @Test
    public void deveApresentarExtratoDaConta() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException, SaldoInsuficienteException, ValorIndevidoException {
        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 50.00);
        ContaNormal conta2 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica2, 50.00);

        conta1.pagar(25.00, conta2);
        conta1.pagar(25.00, conta2);
        conta1.depositar(75.67);

        //Se for passado null para o método, ele imprime na tela o histórico inteiro
        conta1.imprimirExtrato(null);

        //Não faço ideia de como fazer o assertEquals disso
        //Tentei pesquisar como pegar a saída do console, mas não encontrei :(
    }

    @Test
    public void deveApresentarExtratoDaContaNaDataEspecificada() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException, SaldoInsuficienteException, ValorIndevidoException, TipoContaNullException {
        ContaNormal conta1 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 1500.00);
        ContaNormal conta2 = new ContaNormal(TipoConta.POUPANCA, pessoaFisica2, 50.00);


        conta1.pagar(25.00, conta2);
        conta1.pagar(25.00, conta2);
        conta1.depositar(75.67);
        conta1.comprarAcao(AcoesBolsaDeValores.ACAO_ITAU, 2);


        // Professor, precisa indicar a data da execução do teste no formato "dd/mm/aaaa"
        // Pois o historico grava a data de realização da transação, no teste sempre será a data atual.
        conta1.imprimirExtrato(null);

        //Não faço ideia de como fazer o assertEquals disso
        //Tentei pesquisar como pegar a saída do console, mas não encontrei :(
    }
}
