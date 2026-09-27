package com.gheno.ComposiçãoDeTrens;

public class Locomotiva extends CarroFerroviario{
    private double capacidade;

    public Locomotiva(int capacidade, int id){
        super(id);
        this.capacidade = capacidade;
    }

    public double getCapacidade() {
        return capacidade;
    }
    public double getPesoMaximo(){
        return this.capacidade*1000;
    }
}
