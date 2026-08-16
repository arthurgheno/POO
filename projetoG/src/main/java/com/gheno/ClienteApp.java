package com.gheno;

import java.util.Scanner;

public class ClienteApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String nome, cpf;
        double valor;
        int opcao;

        System.out.println("Digite o nome do cliente: ");
        nome = in.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        cpf = in.nextLine();

        Cliente c = new Cliente(nome,cpf);

        System.out.println("Digite o valor da compra: ");
        valor = in.nextDouble();

        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Acumular pontos");
        System.out.println("2 - Usar o desconto");
        opcao = in.nextInt();

        double valorFinal = c.registrarCompra(opcao, valor);

        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Pontuação atual: " + c.getPontos());
        System.out.println("Valor a pagar: " + valorFinal);

    }
}
