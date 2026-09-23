package com.gheno;

import java.util.List;

public interface ContainerNavio<T> {
    Long id();

    int capacidade();

    void carregaCaixa(Caixa<T> caixa, String portoOrigem,

                  String portoDestino) throws ContainerLotadoException;

    Caixa<T> descarregaCaixa(long id);

    List<ItemInventarioContainer<T>> inventario();
}
