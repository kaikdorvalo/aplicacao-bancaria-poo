package org.example.domain;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String cpf, String nome, Endereco endereco) {
        super(nome, endereco);
        this.cpf = cpf;
    }

}
