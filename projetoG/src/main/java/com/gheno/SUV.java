package com.gheno;

public class SUV extends Carro {
    private boolean tracao4x4;

    public SUV(String proprietario, String placa, String marca, String cor, boolean tracao4x4){
        super(proprietario,placa,marca,cor);
        this.tracao4x4 = tracao4x4;
    }

    public boolean temTracao4x4(){
        return tracao4x4;
    }

    @Override
    public String toString(){
        return super.toString()+",tracao4x4=" + (((temTracao4x4()))? "sim":"nao");
    }
}
