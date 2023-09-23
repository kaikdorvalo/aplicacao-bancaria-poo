package org.example.service;

import org.example.domain.Conta;

public class FinanciamentoService {
    public double valorMaximoFinanciamento(Conta conta) {
        if (conta.getSaldo() >= 100) {
            return conta.getSaldo() * 60;
        }
        return 0.0;
    }
}
