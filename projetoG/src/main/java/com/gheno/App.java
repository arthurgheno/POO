package com.gheno;

public class App {

    public static void imprimeVeiculo(Veiculo v) {
        System.out.println(v.toString());
    }

    public static void main(String[] args) {

        Carro c = new Carro("Ze", "ABC1234", "BMW", "VERMELHO");
        System.out.println(c.toString());
        Caminhao cc = new Caminhao("Jeferson", "DEF567", 5);
        System.out.println(cc.toString());
        imprimeVeiculo(c);
        imprimeVeiculo(cc);
    }
}
