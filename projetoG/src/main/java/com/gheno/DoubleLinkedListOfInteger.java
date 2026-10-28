package com.gheno;
/**
 * TAD Lista Duplamente Encadeada de inteiros, com nodos sentinelas
 * (header e trailer).
 */
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /*
     * ===================================================================
     * METODOS AUXILIARES (privados)
     * ===================================================================
     */

    /**
     * Retorna o nodo da posicao index. Percorre a partir do sentinela mais
     * proximo (inicio ou fim), aproveitando o encadeamento duplo.
     *
     * @param index posicao desejada (0 a count-1)
     * @return nodo da posicao index
     */
    private Node getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        Node aux;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }

    /**
     * Desconecta um nodo da lista e atualiza o contador.
     *
     * @param n nodo (nao sentinela) a ser removido
     */
    private void unlink(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
        count--;
    }

    /*
     * ===================================================================
     * METODOS JA FORNECIDOS
     * ===================================================================
     */

    /**
     * 5. Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * 1. Retorna true se a lista nao contem elementos
     *
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * 2. Retorna o numero de elementos da lista
     *
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;
    }

    /*
     * ===================================================================
     * METODOS SOLICITADOS NO TRABALHO
     * ===================================================================
     */

    /**
     * 3. Verifica se a lista contem o elemento.
     * Ex: 4, 8, 12 -> contains(8) -> true; contains(5) -> false.
     *
     * @param element elemento procurado
     * @return true se o elemento existe na lista
     */
    public boolean contains(int element) {
        if (indexOf(element) != -1) {
            return true;
        }
        return false;
    }

    /**
     * 4. Retorna a posicao da primeira ocorrencia do elemento.
     * Ex: 10, 20, 30, 20 -> indexOf(20) -> 1
     *
     * @param element elemento procurado
     * @return indice da primeira ocorrencia ou -1 se nao encontrado
     */
    public int indexOf(int element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element == element) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * 6. Insere um elemento na posicao index (0 a size()).
     * Ex: 3, 7, 9 -> add(1, 5) -> 3, 5, 7, 9
     *
     * @param index   posicao onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se index < 0 ou index > size()
     */
    public void add(int index, int element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        // Nodo que ficara logo apos o novo (trailer se index == count)
        Node next = (index == count) ? trailer : getNode(index);
        Node n = new Node(element);
        n.next = next;
        n.prev = next.prev;
        next.prev.next = n;
        next.prev = n;
        count++;
    }

    /**
     * 7. Retorna o elemento da posicao index.
     * Ex: 8, 12, 20, 25 -> get(2) -> 20
     *
     * @param index posicao desejada
     * @return elemento da posicao index
     * @throws IndexOutOfBoundsException se o indice for invalido
     */
    public int get(int index) {
        return getNode(index).element;
    }

    /**
     * 8. Substitui o valor da posicao index e retorna o valor antigo.
     * Ex: 5, 10, 15, 20 -> set(1, 50) -> 10; lista final: 5, 50, 15, 20
     *
     * @param index posicao a ser alterada
     * @param e     novo valor
     * @return valor antigo
     * @throws IndexOutOfBoundsException se o indice for invalido
     */
    public int set(int index, int e) {
        Node n = getNode(index);
        int old = n.element;
        n.element = e;
        return old;
    }

    /**
     * 9. Remove a primeira ocorrencia do elemento.
     * Ex: 10, 20, 30, 20, 40 -> remove(20) -> true; lista final: 10, 30, 20, 40
     *
     * @param element elemento a ser removido
     * @return true se removeu, false caso contrario
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                unlink(aux);
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * 10. Remove o elemento da posicao index e o retorna.
     * Ex: 10, 20, 30, 40 -> removeByIndex(2) -> 30; lista final: 10, 20, 40
     *
     * @param index posicao do elemento a ser removido
     * @return elemento removido
     * @throws IndexOutOfBoundsException se o indice for invalido
     */
    public int removeByIndex(int index) {
        Node n = getNode(index);
        int old = n.element;
        unlink(n);
        return old;
    }

    /**
     * 11. Remove todas as ocorrencias do elemento.
     *
     * @param element elemento a ser removido
     * @return true se removeu pelo menos uma ocorrencia, false caso contrario
     */
    public boolean removeAll(int element) {
        boolean removed = false;
        Node aux = header.next;
        while (aux != trailer) {
            Node next = aux.next; // guarda o proximo antes de desconectar
            if (aux.element == element) {
                unlink(aux);
                removed = true;
            }
            aux = next;
        }
        if (removed == true) {
            return true;
        }
        return false;
    }

    /**
     * 12. Retorna um arranjo com os elementos entre fromIndex (inclusivo)
     * e toIndex (exclusivo).
     * Ex: 10, 20, 30, 40 -> subList(0, 3) -> [10, 20, 30]
     *
     * @param fromIndex indice inicial (inclusivo)
     * @param toIndex   indice final (exclusivo)
     * @return arranjo com os elementos do intervalo
     * @throws IndexOutOfBoundsException se o intervalo for invalido
     */
    public int[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > count || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(
                    "Intervalo invalido: [" + fromIndex + ", " + toIndex + ")");
        }
        int[] result = new int[toIndex - fromIndex];
        if (result.length == 0) {
            return result;
        }
        Node aux = getNode(fromIndex);
        for (int i = 0; i < result.length; i++) {
            result[i] = aux.element;
            aux = aux.next;
        }
        return result;
    }

    /**
     * 13. Ordena a lista do maior para o menor elemento (Selection Sort,
     * trocando os valores dos nodos).
     * Ex: 4, 7, 1, 9 -> 9, 7, 4, 1
     */
    public void sort() {
        Node i = header.next;
        while (i != trailer) {
            // Procura o maior elemento a partir de i
            Node max = i;
            Node j = i.next;
            while (j != trailer) {
                if (j.element > max.element) {
                    max = j;
                }
                j = j.next;
            }
            // Troca os valores
            if (max != i) {
                Integer tmp = i.element;
                i.element = max.element;
                max.element = tmp;
            }
            i = i.next;
        }
    }

    /**
     * 14. Inverte o conteudo da lista (troca os valores das extremidades
     * em direcao ao centro).
     * Ex: 2, 3, 4, 1 -> 1, 4, 3, 2
     */
    public void reverse() {
        Node left = header.next;
        Node right = trailer.prev;
        for (int i = 0; i < count / 2; i++) {
            Integer tmp = left.element;
            left.element = right.element;
            right.element = tmp;
            left = left.next;
            right = right.prev;
        }
    }

    /**
     * 15. Conta o numero de ocorrencias do elemento na lista.
     * Ex: 5, 7, 5, 2, 5 -> contaOcorrencias(5) -> 3
     *
     * @param element elemento a ser contado
     * @return numero de ocorrencias
     */
    public int contaOcorrencias(int element) {
        int ocorrencias = 0;
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element == element) {
                ocorrencias++;
            }
            aux = aux.next;
        }
        return ocorrencias;
    }

    /**
     * 16. Remove todos os elementos impares, mantendo apenas os pares.
     * Ex: 2, 5, 8, 7, 10 -> 2, 8, 10
     *
     * @return true se removeu algum elemento, false caso contrario
     */
    public boolean removeImpares() {
        boolean removed = false;
        Node aux = header.next;
        while (aux != trailer) {
            Node next = aux.next;
            if (aux.element % 2 != 0) { // funciona tambem para negativos
                unlink(aux);
                removed = true;
            }
            aux = next;
        }
        if (removed == true) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

}
