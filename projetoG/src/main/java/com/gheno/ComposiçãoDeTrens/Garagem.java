package com.gheno.ComposiçãoDeTrens;

import java.util.ArrayList;
import java.util.List;
public class Garagem {
    private List<CarroFerroviario> lista;
    public Garagem(){
        this.lista = new ArrayList<>();
    }

    public void add(CarroFerroviario carro){
        lista.add(carro);
    }

    public void excluir(CarroFerroviario carro){
        lista.remove(carro);
    }

    public List<CarroFerroviario> getLista(){
        return lista;
    }
}
