package com.gheno;

import java.util.LinkedList;
import java.util.List;
public class FiguraApp {
    public static void main(String[] args) {
        List<Figura> figs = new LinkedList<>();
        figs.add(new Retangulo(10,40,30,10));
        figs.add(new Circulo(50, 50, 30));
        figs.add(new Quadrado(10,10, 10));

    double somaAreas = 0.0;

    for(Figura f: figs){
        System.out.println(f);
        somaAreas += f.area();
    }

    System.out.println("Área total:"+somaAreas);
    }
}
