package org.example.domain;

import org.example.enums.TipoConta;
import org.example.enums.TipoTransacao;
import org.example.enums.aplicacoes.AcoesBolsaDeValores;
import org.example.exceptions.conta.ContaPoupancaValorAberturaIndevidoException;
import org.example.exceptions.conta.ContaSemTipoException;
import org.example.exceptions.conta.TipoContaNullException;
import org.example.exceptions.transacoes.SaldoInsuficienteException;
import org.example.exceptions.transacoes.ValorIndevidoException;
import org.example.service.ExtratoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements Transacoes{
    private Double saldo = 0.00;
    private TipoConta tipoConta;
    private List<HistoricoTransacao> historicoTransacoes = new ArrayList<HistoricoTransacao>();
    private List<AcoesBolsaDeValores> acoes = new ArrayList<AcoesBolsaDeValores>();

    public Conta(TipoConta tipoConta, double saldo) throws
            ContaSemTipoException, ContaPoupancaValorAberturaIndevidoException {

        if (tipoConta != null) {
            this.tipoConta = tipoConta;
        } else {
            throw new ContaSemTipoException();
        }

        if (saldo >= tipoConta.getValorMinimoAbertura()) {
            this.saldo = saldo;
        } else {
            throw new ContaPoupancaValorAberturaIndevidoException();
        }
    }

    public List<AcoesBolsaDeValores> getAcoes() {
        return acoes;
    }

    public String comprarAcao(AcoesBolsaDeValores tipoAcao, int quantidade) throws TipoContaNullException, SaldoInsuficienteException, ValorIndevidoException {
        if (tipoAcao != null) {
            if (quantidade > 0) {
                if (getSaldo() >= (tipoAcao.getValor() * quantidade)) {
                    removerSaldo(tipoAcao.getValor() * quantidade);
                    for (int i = 0; i < quantidade; i++) {
                        acoes.add(tipoAcao);
                    }

                    HistoricoTransacao historicoDeposito = new HistoricoTransacao(TipoTransacao.COMPRA_ACAO, "" + quantidade + " " + tipoAcao.getNome(), tipoAcao.getValor() * quantidade, new Date());
                    adicionarNoHistorico(historicoDeposito);
                } else {
                    throw new SaldoInsuficienteException();
                }
            }
        } else {
            throw new TipoContaNullException();
        }
        return "Você comprou " + quantidade + " ação(ões) do tipo " + tipoAcao.getNome() + " no valor de R$ " + tipoAcao.getValor() * quantidade;
    }

    public void imprimirExtrato(String data) {
        ExtratoService extrato = new ExtratoService();
        extrato.imprimirExtrato(historicoTransacoes, data);
    }

    public void adicionarNoHistorico(HistoricoTransacao historicoTransacao) {
        this.historicoTransacoes.add(historicoTransacao);
    }

    public Double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void removerSaldo(double valor) throws SaldoInsuficienteException, ValorIndevidoException {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
            } else {
                throw new SaldoInsuficienteException();
            }
        } else {
            throw new ValorIndevidoException();
        }
    }

    public void depositar(double valor) throws ValorIndevidoException {
        if (valor > 0) {
            this.saldo += valor;
            HistoricoTransacao historicoDeposito = new HistoricoTransacao(TipoTransacao.DEPOSITO, "Deposito realizado", valor, new Date());
            adicionarNoHistorico(historicoDeposito);
        } else {
            throw new ValorIndevidoException();
        }
    }

    public void pagar(double valor, Conta contaDestino) throws SaldoInsuficienteException, ValorIndevidoException {
        if (valor > 0) {
            if (saldo >= valor) {
                removerSaldo(valor);
                contaDestino.adicionarSaldo(valor);

                HistoricoTransacao historicoRecebido = new HistoricoTransacao(TipoTransacao.PAGAMENTO, "Pagamento Recebido", valor, new Date());
                contaDestino.adicionarNoHistorico(historicoRecebido);
                HistoricoTransacao historicoEnviado = new HistoricoTransacao(TipoTransacao.PAGAMENTO, "Pagamento Enviado", valor, new Date());
                adicionarNoHistorico(historicoEnviado);
            } else {
                throw new SaldoInsuficienteException();
            }
        } else {
            throw new ValorIndevidoException();
        }
    }
}
