package com.gheno;

public class Circulo extends Quadrado{
    public Circulo(int x1, int y1, int lado){
        super(x1, y1, lado);
    }

    @Override
    public double area(){
        double raio = Math.abs(getX2() - getX1())/2.0;
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro(){
        double raio = Math.abs(getX2() - getX1())/2.0;
        return 2*Math.PI * raio;
    }
}
