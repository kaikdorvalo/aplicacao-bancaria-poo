package org.example.domain;


public abstract class Pessoa {
    private String nome;
    private Endereco endereco;
    private Vinculo vinculo = null;
    //Implementar tipo de pessoa

    public Pessoa(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public boolean temVinculo() {
        if (vinculo != null) {
            return true;
        }
        return false;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }
}
