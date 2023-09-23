package org.example.exceptions.conta;

public class ContaConjuntaEmpresarialException extends Exception{
    public ContaConjuntaEmpresarialException() {
        super("Empresas não podem ter conta conjunta.");
    }
}
