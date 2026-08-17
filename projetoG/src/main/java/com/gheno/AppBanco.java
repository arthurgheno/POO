package com.gheno;

import java.time.LocalDate;
public class AppBanco {
    public static void main(String[] args) {
        AgenciaBancaria agencia = new AgenciaBancaria(101, "Agência Central");
        ContaCorrente conta1 = new ContaCorrente(1, "Eduardo Vidal");
        ContaCorrente conta2 = new ContaCorrente(2, "Bernardo Copstein");
        agencia.contas.add(conta1);
        agencia.contas.add(conta2);
        System.out.println(agencia.toString());
        conta1.deposita(2000.0);
        conta1.saca(500.0);
        conta1.transfere(300.0, conta2);
        System.out.println(conta1.getSaldo());
        System.out.println(conta2.getSaldo());
        int mesAtual = LocalDate.now().getMonthValue();
        int anoAtual = LocalDate.now().getYear();

        System.out.println(conta1.extratoMesAno(mesAtual, anoAtual));
        System.out.println(conta2.extratoMesAno(mesAtual, anoAtual));
        ContaCorrente contaRecuperada = agencia.recuperaConta(1);
        System.out.println("Conta recuperada: " + contaRecuperada.toString());
        conta2.saca(conta2.getSaldo());
        agencia.encerraConta(2);
        System.out.println(conta2.toString());
        System.out.println("Conta 2 encerrada");
        }
    }
