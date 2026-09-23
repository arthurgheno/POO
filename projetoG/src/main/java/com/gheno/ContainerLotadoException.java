package com.gheno;

public class ContainerLotadoException extends Exception{

    public ContainerLotadoException() {
        super("O container está lotado");
    }

    public ContainerLotadoException(String mensagem) {
        super(mensagem);
    }
}
