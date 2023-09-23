package org.example.enums.aplicacoes;

public enum AcoesBolsaDeValores {
    ACAO_BANCO_D0_BRASIL("Ação do Banco do Brasil", 50.0, 0.13),
    ACAO_ITAU("Ação do Banco Itaú", 67.00, 0.15),
    ACAO_IBOVESPA("Ação da Ibovespa", 34.00, 0.09),
    FUNDO_IMOBILIARIO_BCFF11("Fundo Imobiliário BCFF11", 23.00, 0.14),
    FUNDO_IMOBILIARIO_IRDM11("Fundo Imobiliario IRDM11", 45.00, 0.13);

    private String nome;
    private Double valor;
    private Double dividendo;

    AcoesBolsaDeValores(String nome, Double valor, Double dividendo) {
        this.nome = nome;
        this.valor = valor;
        this.dividendo = dividendo;
    }

    public Double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}
