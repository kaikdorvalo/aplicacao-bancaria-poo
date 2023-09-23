package org.example.exceptions.conta;

public class ContaPoupancaValorAberturaIndevidoException extends Exception{
    public ContaPoupancaValorAberturaIndevidoException() {
        super("Valor de abertura de conta poupança menor que o permitido.");
    }
}
