package org.example.domain;

import org.example.enums.TipoConta;
import org.example.exceptions.conta.*;

import java.util.ArrayList;
import java.util.List;

public class ContaNormal extends Conta {
    private Pessoa titular;

    public ContaNormal( TipoConta tipoConta, Pessoa titular, double saldo) throws
            ContaNormalSemTitularException,
            ContaSemTipoException,
            ContaPoupancaValorAberturaIndevidoException {

        super(tipoConta, saldo);
        if (titular != null) {
            this.titular = titular;
        } else {
            throw new ContaNormalSemTitularException();
        }
    }


}
