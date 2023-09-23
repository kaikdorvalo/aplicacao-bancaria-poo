package org.example.exceptions.vinculo;

public class PessoaVinculadaException extends Exception{
    public PessoaVinculadaException() {
        super("As pessoas já possuem um vinculo registrado");
    }
}
