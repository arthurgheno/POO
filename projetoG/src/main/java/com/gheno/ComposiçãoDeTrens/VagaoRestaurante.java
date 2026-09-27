package com.gheno.ComposiçãoDeTrens;

public class VagaoRestaurante extends VagaoDePassageiros{
    private int qntdMesas;
    private double pesoGarcom;
    private double pesoCozinheiro;

    public VagaoRestaurante(int id, int qntdMesas, double pesoGarcom, double pesoCozinheiro) {
        super(id,qntdMesas*4);
        this.qntdMesas = qntdMesas;
        this.pesoGarcom = pesoGarcom;
        this.pesoCozinheiro = pesoCozinheiro;
    }

    public int getQntdMesas() {
        return qntdMesas;
    }

    public double getPesoGarcom() {
        return pesoGarcom;
    }

    public double getPesoCozinheiro() {
        return pesoCozinheiro;
    }

    public double getPesoMaximo(){
        return super.getPesoMaximo() + 1000 + getPesoGarcom() + getPesoCozinheiro();
    }

}
