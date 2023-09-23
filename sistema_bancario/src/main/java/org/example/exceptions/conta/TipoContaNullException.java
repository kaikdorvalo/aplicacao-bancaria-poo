package org.example.exceptions.conta;

public class TipoContaNullException extends Exception{
    public TipoContaNullException() {
        super("A conta precisa ser de um dos tipos válidos.");
    }
}
