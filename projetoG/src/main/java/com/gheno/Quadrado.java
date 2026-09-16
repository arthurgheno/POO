package com.gheno;

public class Quadrado extends Retangulo{
    public Quadrado(int x1, int y1, int lado){
        super(x1, y1, x1+lado,y1+lado);
    }

    public int getlado(){
        return Math.abs(getX1()-getX2());
    }
}
