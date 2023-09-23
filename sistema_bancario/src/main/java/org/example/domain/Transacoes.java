package org.example.domain;

import org.example.exceptions.transacoes.SaldoInsuficienteException;
import org.example.exceptions.transacoes.ValorIndevidoException;

public interface Transacoes {
    void depositar(double valor) throws ValorIndevidoException;
    void pagar(double valor, Conta contaDestino) throws SaldoInsuficienteException, ValorIndevidoException;
}
