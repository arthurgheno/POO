package com.gheno.ComposiçãoDeTrens;

public class VagaoDePassageiros extends Vagao{
    private int qntdAssentos;

    public VagaoDePassageiros(int id, int qntdAssentos){
        super(id);
        this.qntdAssentos = qntdAssentos;
    }

    public int getQntdAssentos() {
        return qntdAssentos;
    }

    public double getPesoMaximo(){
        return qntdAssentos*80;
    }
}
