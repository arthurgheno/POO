package com.gheno;

public class Veiculo {
    private String proprietario;
    private String placa;

    public Veiculo(String proprietario, String placa) {
        this.proprietario = proprietario;
        this.placa = placa;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Proprietario=" + proprietario + ", placa=" + placa;
    }


}
