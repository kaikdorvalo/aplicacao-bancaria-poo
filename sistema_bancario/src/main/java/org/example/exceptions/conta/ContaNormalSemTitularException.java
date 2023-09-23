package org.example.exceptions.conta;

public class ContaNormalSemTitularException extends Exception {
    public ContaNormalSemTitularException() {
        super("A conta deve ter um titular.");
    }
}
