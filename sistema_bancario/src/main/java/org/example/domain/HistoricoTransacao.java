package org.example.domain;

import org.example.enums.TipoTransacao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricoTransacao {
    private TipoTransacao tipoTransacao;
    private String titulo;
    private Double valor;
    private Date data = new Date();

    public HistoricoTransacao(TipoTransacao tipoTransacao, String titulo, double valor, Date data) {
        this.tipoTransacao = tipoTransacao;
        this.titulo = titulo;
        this.data = data;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public String getData() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }
}
