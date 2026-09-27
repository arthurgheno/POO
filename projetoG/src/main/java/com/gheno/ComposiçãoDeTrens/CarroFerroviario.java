package com.gheno.ComposiçãoDeTrens;

public abstract class CarroFerroviario {
    private int id;
    private boolean engatado;
    public CarroFerroviario(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isEngatado(){
        return engatado;
    }

    public void engatar(){
        this.engatado = true;
    }

    public void desengatar(){
        this.engatado = false;
    }

    public abstract double getPesoMaximo();

}
