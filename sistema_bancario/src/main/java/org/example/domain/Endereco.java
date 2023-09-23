package org.example.domain;

public class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco(String pais, String estado,
                    String cidade, String rua,
                    String numero, String complemento) {

        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
}
