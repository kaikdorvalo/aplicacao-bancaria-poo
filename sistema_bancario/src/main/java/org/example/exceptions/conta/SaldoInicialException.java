package org.example.exceptions.conta;

import org.example.enums.TipoConta;

public class SaldoInicialException extends Exception{
    public SaldoInicialException(TipoConta tipoConta) {
        super("O saldo inicial da conta " +
                tipoConta.getNome() +
                " deve ser igual ou maior a " +
                tipoConta.getValorMinimoAbertura() +
                ".");
    }
}
