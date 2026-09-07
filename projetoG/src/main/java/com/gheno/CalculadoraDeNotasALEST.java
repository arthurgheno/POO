package com.gheno;

import java.util.ArrayList;
public class CalculadoraDeNotasALEST implements CalculadoraDeNotas{
    private ArrayList<Double> notas;

    public CalculadoraDeNotasALEST(ArrayList<Double> notas) {
        this.notas = notas;
    }

    @Override
    public double media(){
        double acum =0.0;
        for(Double nota: notas){
            acum+= nota;
        }
        return acum/notas.size();
    }

    @Override
    public boolean aprovado(){
        return media()>=7.0;
    }

}
