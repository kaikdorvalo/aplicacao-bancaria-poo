package org.example.exceptions.transacoes;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException() {
        super("Saldo insuficiente.");
    }
}
