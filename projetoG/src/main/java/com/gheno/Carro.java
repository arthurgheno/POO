package com.gheno;

public class Carro extends Veiculo {
    private String marca;
    private String cor;

    public Carro(String proprietario, String placa, String marca, String cor) {
        super(proprietario, placa);
        this.marca = marca;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return super.toString() + ", marca=" + marca + ", cor=" + cor;
    }
}
