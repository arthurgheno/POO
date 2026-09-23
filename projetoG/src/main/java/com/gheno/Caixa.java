package com.gheno;

public interface Caixa<T> {
    Long id();

    void guarda(T objeto) throws CaixaOcupadaException;

    T consulta();

    T retira();

    String descricaoConteudo();
}
