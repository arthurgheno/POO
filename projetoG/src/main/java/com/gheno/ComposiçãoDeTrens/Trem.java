package com.gheno.ComposiçãoDeTrens;

import java.util.List;
import java.util.ArrayList;

public class Trem {
    private int id;
    private List<CarroFerroviario> carros;

    public Trem(int id){
        this.id = id;
        this.carros = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

}
