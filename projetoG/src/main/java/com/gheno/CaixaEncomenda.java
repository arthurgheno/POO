package com.gheno;
 /**
 * Caixa capaz de armazenar um único elemento de qualquer tipo.
 *
 * O tipo do elemento é definido no momento em que a caixa é criada,
 * através do parâmetro genérico T. A caixa guarda apenas uma
 * referência para o objeto, não uma cópia dele.
 */
public class CaixaEncomenda<T> implements Caixa<T> {

    private final Long id;
    private T conteudo;

    public CaixaEncomenda(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O identificador da caixa não pode ser nulo.");
        }
        this.id = id;
    }

    @Override
    public Long id() {
        return id;
    }

    /**
     * Guarda o objeto na caixa.
     *
     * @throws CaixaOcupadaException se a caixa já contiver um elemento.
     */
    @Override
    public void guarda(T objeto) throws CaixaOcupadaException {
        if (objeto == null) {
            throw new IllegalArgumentException("Não é possível guardar null na caixa.");
        }
        if (!estaVazia()) {
            throw new CaixaOcupadaException(
                    "A caixa " + id + " já está ocupada por: " + descricaoConteudo());
        }
        this.conteudo = objeto;
    }

    /**
     * Devolve o elemento sem removê-lo. Retorna null se a caixa estiver vazia.
     */
    @Override
    public T consulta() {
        return conteudo;
    }

    /**
     * Devolve o elemento e esvazia a caixa. Retorna null se a caixa estiver vazia.
     */
    @Override
    public T retira() {
        T removido = conteudo;
        this.conteudo = null;
        return removido;
    }

    /**
     * Descrição textual do conteúdo. Retorna null se a caixa estiver vazia.
     */
    @Override
    public String descricaoConteudo() {
        if (estaVazia()) {
            return null;
        }
        return conteudo.getClass().getSimpleName() + " -> " + conteudo.toString();
    }

    public boolean estaVazia() {
        return conteudo == null;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "Caixa " + id + " (vazia)";
        }
        return "Caixa " + id + ": " + conteudo;
    }
}
