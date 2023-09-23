package org.example.service;

import org.example.domain.ContaNormal;
import org.example.domain.Endereco;
import org.example.domain.PessoaFisica;
import org.example.enums.TipoConta;
import org.example.exceptions.conta.ContaNormalSemTitularException;
import org.example.exceptions.conta.ContaPoupancaValorAberturaIndevidoException;
import org.example.exceptions.conta.ContaSemTipoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//precisa ter um valor minimo de 100 reais para realizar o calculo do fnanciamento
//O calculo do valor máximo do financiamento é definido por saldo * 60
public class FinanciamentoServiceTest {
    Endereco endereco = new Endereco("Brasil", "Paraná", "Maringá", "Avenida Guedner", "0000", "Na Unicesumar");

    PessoaFisica pessoaFisica1 = new PessoaFisica("122.122.122-55", "Pessoa1", endereco);

    @Test
    public void deveObterValorMaximoFinanciamento() throws ContaSemTipoException, ContaNormalSemTitularException, ContaPoupancaValorAberturaIndevidoException {
        FinanciamentoService financiamento = new FinanciamentoService();
        ContaNormal conta = new ContaNormal(TipoConta.POUPANCA, pessoaFisica1, 1000.00);

        double resultado = financiamento.valorMaximoFinanciamento(conta);

        Assertions.assertEquals(60000.00, resultado);
    }
}
