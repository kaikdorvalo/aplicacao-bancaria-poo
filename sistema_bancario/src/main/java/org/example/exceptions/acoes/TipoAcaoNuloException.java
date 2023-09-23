package org.example.exceptions.acoes;

public class TipoAcaoNuloException extends Exception {
    public TipoAcaoNuloException() {
        super("O tipo da acao não pode ser nulo");
    }
}
