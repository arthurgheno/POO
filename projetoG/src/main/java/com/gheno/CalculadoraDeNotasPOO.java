package com.gheno;

import java.util.ArrayList;
public class CalculadoraDeNotasPOO {
    private ArrayList<Double> notas;

    public CalculadoraDeNotasPOO(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public double media(){
        if(notas.size()!=2) throw new IllegalStateException("Notas não informada");
        return (notas.get(0)+2*notas.get(1))/3.0;
    }

    public boolean aprovado(){
        return media()>=5.0;
    }
}
