package com.gheno;

public class Retangulo extends Figura{
    public Retangulo(int x1, int y1, int x2, int y2){
        super(x1, y1, x2, y2);
    }

    @Override
    public double area(){
        int l1 = Math.abs(getX2() - getX1());
        int l2 = Math.abs(getY2() - getY1());
        return l1 * l2;
    }

    @Override
    public double perimetro(){
        int l1 = Math.abs(getX2() - getX1());
        int l2 = Math.abs(getY2() - getY1());
        return 2*l1 + 2*l2;
    }
}
