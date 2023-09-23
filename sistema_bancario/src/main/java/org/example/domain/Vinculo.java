package org.example.domain;

import org.example.enums.TipoVinculo;

public class Vinculo {
    private TipoVinculo vinculo;
    private Pessoa vinculado;

    public Vinculo(Pessoa vinculado, TipoVinculo vinculo) {
        this.vinculo = vinculo;
        this.vinculado = vinculado;
    }

    public Pessoa getVinculado() {
        return vinculado;
    }


}
