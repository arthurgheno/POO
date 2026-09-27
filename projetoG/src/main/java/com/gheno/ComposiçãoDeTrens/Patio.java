package com.gheno.ComposiçãoDeTrens;

import java.util.ArrayList;
import java.util.List;
public class Patio {
    private List<Trem> lista;
    public Patio(){
        this.lista = new ArrayList<>();
    }

    public void add(Trem t){
        lista.add(t);
    }

    public void excluir(Trem t){
        lista.remove(t);
    }

    public List<Trem> getLista(){
        return lista;
    }
}
