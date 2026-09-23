package com.gheno;

import java.util.LinkedList;
import java.util.List;

public class CaixaApp {
    public static void main(String[] args) throws CaixaOcupadaException {
        List<Caixa<Object>> caixas = new LinkedList<>();
        caixas.add(new CaixaEncomenda<>(1L));
        caixas.add(new CaixaEncomenda<>(2L));
        caixas.add(new CaixaEncomenda<>(3L));

        caixas.get(0).guarda("Documento confidencial");
        caixas.get(1).guarda(42);
        // a caixa 3 fica vazia de propósito

        int ocupadas = 0;

        for (Caixa<Object> c : caixas) {
            System.out.println(c);
            if (c.consulta() != null) ocupadas++;
        }

        System.out.println("Caixas ocupadas: " + ocupadas + " de " + caixas.size());
    }
}
