package com.gheno;

public class Caminhao extends Veiculo {
    private String proprietario;
    private String placa;
    private int capCarga;

    public Caminhao(String proprietario, String placa, int capCarga) {
        super(proprietario, placa);
        this.capCarga = capCarga;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapCarga() {
        return capCarga;
    }

    @Override
    public String toString() {
        return "Caminhao: proprietario=" + proprietario + ", placa=" + placa + ", capCarga=" + capCarga;
    }


}
