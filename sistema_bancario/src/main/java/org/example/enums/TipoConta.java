package org.example.enums;

public enum TipoConta {
    CORRENTE("Corrente", 0.00),
    POUPANCA("Poupança", 50.00),
    SALARIO("Salário", 0.00);

    private String nome;
    private Double valorMinimoAbertura;

    TipoConta(String nome, Double valorMinimoAbertura) {
        this.nome = nome;
        this.valorMinimoAbertura = valorMinimoAbertura;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorMinimoAbertura() {
        return valorMinimoAbertura;
    }
}
