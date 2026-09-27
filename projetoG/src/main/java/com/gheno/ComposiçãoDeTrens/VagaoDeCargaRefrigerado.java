package com.gheno.ComposiçãoDeTrens;

public class VagaoDeCargaRefrigerado extends VagaoDeCarga {
    public VagaoDeCargaRefrigerado(int id, double capacidade){
        super(id, capacidade);
    }

    public double getPesoMaximo(){
        return super.getPesoMaximo() * 1.15;
    }
}
