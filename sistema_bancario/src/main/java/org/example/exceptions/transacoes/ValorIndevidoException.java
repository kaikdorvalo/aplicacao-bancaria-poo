package org.example.exceptions.transacoes;

public class ValorIndevidoException extends Exception{
    public ValorIndevidoException() {
        super("O valor não pode ser menor ou igual a zero.");
    }
}
