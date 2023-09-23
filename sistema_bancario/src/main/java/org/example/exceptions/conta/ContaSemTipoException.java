package org.example.exceptions.conta;

public class ContaSemTipoException extends Exception {
    public ContaSemTipoException() {
        super("A conta deve ter um tipo.");
    }
}
