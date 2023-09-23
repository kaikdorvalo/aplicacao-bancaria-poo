package org.example.exceptions.conta;

public class ContaConjuntaSemTitularesException extends Exception{
    public ContaConjuntaSemTitularesException() {
        super("A conta conjunta deve conter 2 titulares");
    }
}
