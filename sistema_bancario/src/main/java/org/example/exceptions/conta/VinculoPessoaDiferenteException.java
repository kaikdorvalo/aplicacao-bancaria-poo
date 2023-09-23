package org.example.exceptions.conta;

public class VinculoPessoaDiferenteException extends Exception{
    public VinculoPessoaDiferenteException() {
        super("Os titulares informados não possuem um vinculo mútuo");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
