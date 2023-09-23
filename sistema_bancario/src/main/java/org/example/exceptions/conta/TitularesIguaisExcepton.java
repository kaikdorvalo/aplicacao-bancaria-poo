package org.example.exceptions.conta;

public class TitularesIguaisExcepton extends Exception{
    public TitularesIguaisExcepton() {
        super("Para uma conta conjunta, os titulares devem ser diferentes");
    }
}
