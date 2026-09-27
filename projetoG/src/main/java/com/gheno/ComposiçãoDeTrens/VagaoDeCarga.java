package com.gheno.ComposiçãoDeTrens;

public class VagaoDeCarga extends Vagao{
    private double capacidadeCarga;

    public VagaoDeCarga(int id, double capacidadeCarga){
        super(id);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga(){
        return capacidadeCarga;
    }

    public double getPesoMaximo(){
        return this.capacidadeCarga*1000;
    }
}
