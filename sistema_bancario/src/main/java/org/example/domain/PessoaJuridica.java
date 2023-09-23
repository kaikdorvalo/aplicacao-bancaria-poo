package org.example.domain;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String cnpj, String nome, Endereco endereco) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }

}
