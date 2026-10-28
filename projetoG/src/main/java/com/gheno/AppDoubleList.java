package com.gheno;

public class AppDoubleList {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);

        System.out.println(l);
        System.out.println("size="+l.size());


    //    System.out.println("Get da posicao 2: " + l.get(2));
    //    System.out.println("Get da posicao 6: " + l.get(6));

    //    System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");

     //   System.out.println("Removeu 50? " + l.remove(50));
    //System.out.println("Removeu 57? " + l.remove(57));

        System.out.println(l);


        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l2.add(35);
        l2.add(5);
        l2.add(50);
        l2.add(60);
        l2.add(20);
        l2.add(10);

        System.out.println("Conteudo lista l2:\n" + l2);

        // ===================== METODOS ACRESCENTADOS =====================

        // isEmpty
        System.out.println("l2 esta vazia? " + l2.isEmpty());

        // contains
        System.out.println("l2 contem 50? " + l2.contains(50));
        System.out.println("l2 contem 99? " + l2.contains(99));

        // indexOf
        System.out.println("Posicao do 60 em l2: " + l2.indexOf(60));
        System.out.println("Posicao do 99 em l2: " + l2.indexOf(99));

        // contaOcorrencias (antes e depois de inserir outro 5)
        System.out.println("Ocorrencias do 5 em l2: " + l2.contaOcorrencias(5));

        // add(index, element)
        l2.add(2, 5);
        System.out.println("Apos add(2, 5):\n" + l2);
        System.out.println("Ocorrencias do 5 em l2: " + l2.contaOcorrencias(5));

        // removeAll
        System.out.println("removeAll(5): " + l2.removeAll(5));
        System.out.println("removeAll(99): " + l2.removeAll(99));
        System.out.println("Apos removeAll:\n" + l2);

        // removeByIndex
        System.out.println("removeByIndex(1) removeu: " + l2.removeByIndex(1));
        System.out.println("Apos removeByIndex:\n" + l2);

        // subList (retorna um arranjo)
        int[] sub = l2.subList(1, 3);
        System.out.print("subList(1, 3): ");
        for (int i = 0; i < sub.length; i++) {
            System.out.print(sub[i] + " ");
        }
        System.out.println();

        // sort (do maior para o menor)
        l2.sort();
        System.out.println("Apos sort:\n" + l2);

        // reverse
        l2.reverse();
        System.out.println("Apos reverse:\n" + l2);

        // removeImpares
        System.out.println("removeImpares: " + l2.removeImpares());
        System.out.println("Apos removeImpares:\n" + l2);
        System.out.println("removeImpares de novo: " + l2.removeImpares());

        // clear
        l2.clear();
        System.out.println("Apos clear: size=" + l2.size() + ", vazia? " + l2.isEmpty());

        // ===================== TABELA DE TEMPOS (lista com 5000 elementos) =====================
        medirTempos();
    }

    // ------------------------------------------------------------------
    // MEDICAO DE TEMPO PARA A TABELA III-A DO TRABALHO
    // ------------------------------------------------------------------

    // Tamanho da lista usada nas medicoes
    private static final int N = 5000;
    // Execucoes para aquecer a JVM (nao medidas) e execucoes medidas
    private static final int AQUECIMENTO = 30;
    private static final int REPETICOES = 51;

    /** Cria uma lista com N elementos de valores variados (sem usar Random). */
    private static DoubleLinkedListOfInteger criarLista() {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        for (int i = 0; i < N; i++) {
            lista.add((i * 7919) % 10007);
        }
        return lista;
    }

    /** Executa a operacao identificada por id (pior caso quando aplicavel). */
    private static void executar(int id, DoubleLinkedListOfInteger lista) {
        switch (id) {
            case 1:  lista.isEmpty(); break;
            case 2:  lista.size(); break;
            case 3:  lista.contains(-1); break;                  // nao existe: percorre tudo
            case 4:  lista.indexOf(-1); break;                   // nao existe: percorre tudo
            case 5:  lista.clear(); break;
            case 6:  lista.add(N / 2, 123); break;               // insercao no meio
            case 7:  lista.get(N / 2); break;                    // meio
            case 8:  lista.set(N / 2, 123); break;               // meio
            case 9:  lista.remove(Integer.valueOf(-1)); break;   // nao existe: percorre tudo
            case 10: lista.removeByIndex(N / 2); break;          // meio
            case 11: lista.removeAll(lista.get(0)); break;
            case 12: lista.subList(0, N); break;
            case 13: lista.sort(); break;
            case 14: lista.reverse(); break;
            case 15: lista.contaOcorrencias(lista.get(0)); break;
            case 16: lista.removeImpares(); break;
            default: break;
        }
    }

    /**
     * Mede uma operacao: aquece a JVM, executa REPETICOES vezes em listas novas
     * (a criacao da lista NAO entra no tempo) e imprime a MEDIANA em microssegundos.
     */
    private static void medir(String metodo, String complexidade, int id) {
        for (int k = 0; k < AQUECIMENTO; k++) {
            executar(id, criarLista());
        }
        long[] tempos = new long[REPETICOES];
        for (int k = 0; k < REPETICOES; k++) {
            DoubleLinkedListOfInteger lista = criarLista();
            long inicio = System.nanoTime();
            executar(id, lista);
            long fim = System.nanoTime();
            tempos[k] = fim - inicio;
        }
        // Ordena os tempos (insercao) para pegar a mediana
        for (int i = 1; i < REPETICOES; i++) {
            long chave = tempos[i];
            int j = i - 1;
            while (j >= 0 && tempos[j] > chave) {
                tempos[j + 1] = tempos[j];
                j--;
            }
            tempos[j + 1] = chave;
        }
        double micro = tempos[REPETICOES / 2] / 1000.0;
        System.out.println(String.format("%-34s | %-8s | %12.3f microssegundos",
                metodo, complexidade, micro));
    }

    private static void medirTempos() {
        System.out.println("\n\n===== TABELA III-A: lista com " + N + " elementos (mediana de "
                + REPETICOES + " execucoes) =====");
        System.out.println(String.format("%-34s | %-8s | %s", "Metodo", "O(f(n))", "Tempo de Execucao"));
        medir("boolean isEmpty()", "O(1)", 1);
        medir("int size()", "O(1)", 2);
        medir("boolean contains(int)", "O(n)", 3);
        medir("int indexOf(int)", "O(n)", 4);
        medir("void clear()", "O(1)", 5);
        medir("void add(int, int)", "O(n)", 6);
        medir("int get(int)", "O(n)", 7);
        medir("int set(int, int)", "O(n)", 8);
        medir("boolean remove(Integer)", "O(n)", 9);
        medir("int removeByIndex(int)", "O(n)", 10);
        medir("boolean removeAll(int)", "O(n)", 11);
        medir("int[] subList(int, int)", "O(n)", 12);
        medir("void sort()", "O(n^2)", 13);
        medir("void reverse()", "O(n)", 14);
        medir("int contaOcorrencias(int)", "O(n)", 15);
        medir("boolean removeImpares()", "O(n)", 16);
    }

}
