package com.gheno;

import java.util.ArrayList;

public class AgenciaBancaria {
    private int numero;
    private String nome;
    ArrayList<ContaCorrente> contas;

    public AgenciaBancaria(int numero, String nome) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número da agência não pode ser negativo.");
        }
        if (nome == null || nome.length() < 2) {
            throw new IllegalArgumentException("Nome da agência não pode ser nulo e deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    // Cria/vincula uma conta bancária com a agência
    public void vinculaConta(ContaCorrente conta) {
        for (ContaCorrente c : contas) {
            if (c.getNumero() == conta.getNumero()) {
                throw new IllegalArgumentException("Já existe uma conta cadastrada com o número " + conta.getNumero());
            }
        }
        contas.add(conta);
    }

    // Recupera uma conta bancária da agência
    public ContaCorrente recuperaConta(int numeroConta) {
        for (ContaCorrente c : contas) {
            if (c.getNumero() == numeroConta) {
                return c;
            }
        }
        throw new IllegalArgumentException("Não foi encontrada nenhuma conta com o número " + numeroConta);
    }

    // Encerra uma conta bancária da agência
    public void encerraConta(int numeroConta) {
        ContaCorrente conta = recuperaConta(numeroConta);
        if (conta.getSaldo() != 0.0) {
            throw new IllegalStateException("A conta " + numeroConta + " possui saldo e não pode ser encerrada.");
        }
        conta.fecha();
        contas.remove(conta);
    }

    @Override
    public String toString() {
        return "AgenciaBancaria{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", quantidadeContas=" + contas.size() +
                '}';
    }

    public static void main(String[] args) {
        AgenciaBancaria agencia = new AgenciaBancaria(1234, "Agência Centro");

        ContaCorrente contaJoao = new ContaCorrente(1, "João");
        ContaCorrente contaMaria = new ContaCorrente(2, "Maria");

        agencia.vinculaConta(contaJoao);
        agencia.vinculaConta(contaMaria);
        System.out.println(agencia);

        // Tentando vincular uma conta com número repetido
        try {
            ContaCorrente contaDuplicada = new ContaCorrente(1, "Outra Pessoa");
            agencia.vinculaConta(contaDuplicada);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // Recuperando uma conta e efetuando operações
        ContaCorrente conta = agencia.recuperaConta(1);
        conta.deposita(500.0);
        conta.saca(200.0);
        System.out.println("Saldo da conta de João: R$ " + conta.getSaldo());

        // Tentando recuperar uma conta inexistente
        try {
            agencia.recuperaConta(999);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // Tentando encerrar uma conta com saldo diferente de zero
        try {
            agencia.encerraConta(1);
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // Zerando o saldo (transferindo o restante) e encerrando a conta
        conta.transfere(conta.getSaldo(), contaMaria);
        agencia.encerraConta(1);
        System.out.println("Conta de João encerrada. Ativa? " + contaJoao.isAtiva());
    }
}
