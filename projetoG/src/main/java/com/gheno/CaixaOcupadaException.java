package com.gheno;

/**
 * Lançada quando se tenta guardar um objeto em uma caixa que já
 * possui conteúdo. É uma exceção verificada (checked), por isso o
 * método guarda() a declara com throws.
 */
public class CaixaOcupadaException extends Exception {

    public CaixaOcupadaException() {
        super("A caixa já está ocupada.");
    }

    public CaixaOcupadaException(String mensagem) {
        super(mensagem);
    }
}
