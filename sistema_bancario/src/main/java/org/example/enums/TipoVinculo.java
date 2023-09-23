package org.example.enums;

public enum TipoVinculo {
    UNIAO_CIVIL("União Civil"),
    VINCULO_GENERICO("Vinculo"),
    SEM_VINCULO("Sem Vinculo");

    private String nome;

    TipoVinculo(String nome) {
        this.nome = nome;
    }

}
