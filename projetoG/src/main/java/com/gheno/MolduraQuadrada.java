package com.gheno;

public class MolduraQuadrada extends Figura implements Moldura{
    public MolduraQuadrada(int x1, int y1, int x2, int y2){
        super(x1,y1,x2,y2);
    }

    @Override
    public String corDaBorda() {
        return "Vermelha";
    }

    @Override
    public String nomeDaImagem() {
        return "Paisagem Campestre";
    }

    
}
