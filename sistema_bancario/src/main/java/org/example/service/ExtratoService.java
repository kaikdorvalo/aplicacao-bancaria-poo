package org.example.service;

import org.example.domain.HistoricoTransacao;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtratoService {

    public void imprimirExtrato(List<HistoricoTransacao> historico, String dataDigitada) {
        int cont = 0;
        if (!historico.isEmpty()) {
            for (HistoricoTransacao h : historico) {
                if (dataDigitada != null) {
                    if (h.getData().equals(dataDigitada)) {
                        System.out.println(h.getTitulo());
                        System.out.println(h.getValor());
                        System.out.println(h.getData());
                        System.out.println("--------------------------------");
                        cont++;
                    }
                } else {
                    System.out.println(h.getTitulo());
                    System.out.println(h.getValor());
                    System.out.println(h.getData());
                    System.out.println("--------------------------------");
                    cont++;
                }
            }
            if (cont == 0) {
                System.out.println("Nenhuma transação encontrada para a data informada.");
            }
        }

    }
}
