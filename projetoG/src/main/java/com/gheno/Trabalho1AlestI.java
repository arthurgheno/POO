package com.gheno;

public class Trabalho1AlestI{

public static int algoritmo1(int n) {
    int i, j, k;
    int res = 0;
    int cont_op = 0;

    for (i = 1; i <= n*n; i += 1) {
        for (j = 1; j <= i; j += 2) {
            for (k = n+1; k <= 2*i; k += i*j) {
                res = res + k+1;
                cont_op++;
            }
        }
    }

        return cont_op;
    }

public static int algoritmo2(int n){
    int i, j, k;
    int res = 0;
    int cont_op = 0;

    for( i = n; i <= n; i += i/2+1 ){
        for( j = i/2; j <= i*i; j += i+1 ){
            for( k = n; k <= 2*n; k += i+1 ){
                res = res + n;
                cont_op++;
            }
        }
    }
        return cont_op;
    }

public static int algoritmo3(int n){
    int i, j, k;
    int res = 0;
    int cont_op = 0;

    for( i = 1; i <= n*n; i += 2 ){
        for( j = i/2; j <= 2*i; j += i/2+1 ){
            for( k = j+1; k <= n+j; k += k/2+1 ){
                res = res + Math.abs(j-i);
                cont_op++;
            }
        }
    }
        return cont_op;
    }

public static int algoritmo4(int n){
    int i, j, k;
    int res = 0;
    int cont_op = 0;

    for( i = 1; i <= n*n; i += 2 ){
        for( j = 2; j <= n+1; j += i+1 ){
            for( k = j/2; k <= i+1; k += j/2+1 ){
                res = res + j+1;
                cont_op++;
            }
        }
    }
        return cont_op;
    }

public static int algoritmo5(int n){
    int i, j, k;
    int res = 0;
    int cont_op = 0;

    for( i = n/2; i <= n; i += 3 ){
        for( j = i; j <= i*i; j += 2 ){
            for( k = i; k <= 2*j; k += 1 ){
                res = res + n+j;
                cont_op++;
            }
        }
    }
        return cont_op;
    }

public static void main(String[] args) {

    System.out.println("n cont1 tempo1 cont2 tempo2 cont3 tempo3 cont4 tempo4 cont5 tempo5");

    for (int n = 1; n <= 100; n++) {

        // Algoritmo 1
        long inicio1 = System.nanoTime();
        int cont1 = algoritmo1(n);
        long fim1 = System.nanoTime();
        long tempo1 = fim1 - inicio1;

        // Algoritmo 2
        long inicio2 = System.nanoTime();
        int cont2 = algoritmo2(n);
        long fim2 = System.nanoTime();
        long tempo2 = fim2 - inicio2;

        // Algoritmo 3
        long inicio3 = System.nanoTime();
        int cont3 = algoritmo3(n);
        long fim3 = System.nanoTime();
        long tempo3 = fim3 - inicio3;

        // Algoritmo 4
        long inicio4 = System.nanoTime();
        int cont4 = algoritmo4(n);
        long fim4 = System.nanoTime();
        long tempo4 = fim4 - inicio4;

        // Algoritmo 5
        long inicio5 = System.nanoTime();
        int cont5 = algoritmo5(n);
        long fim5 = System.nanoTime();
        long tempo5 = fim5 - inicio5;

        System.out.println(
            n + " " +
            cont1 + " " + tempo1 + " " +
            cont2 + " " + tempo2 + " " +
            cont3 + " " + tempo3 + " " +
            cont4 + " " + tempo4 + " " +
            cont5 + " " + tempo5
        );
    }
    }
}
