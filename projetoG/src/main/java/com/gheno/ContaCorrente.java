package com.gheno;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ContaCorrente {
    private int numero;
    private String correntista;
    private double saldo;
    private boolean ativa;
    private ArrayList<Operacao> operacoes;
    public ContaCorrente(int numero, String correntista) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número da conta não pode ser negativo.");
        }
        if (correntista == null || correntista.length() < 2) {
            throw new IllegalArgumentException("Correntista não pode ser nulo e deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = 0.0;
        this.ativa = true;
        this.operacoes = new ArrayList<>();
    }
    public int getNumero() {
        return numero;
    }
    public String getCorrentista() {
        return correntista;
    }
    public double getSaldo() {
        return saldo;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void deposita(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
        operacoes.add(new Operacao(LocalDate.now(), LocalTime.now(), TipoOperacao.DEPOSITO, valor));
    }
    public void saca(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (valor >= saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        operacoes.add(new Operacao(LocalDate.now(), LocalTime.now(), TipoOperacao.RETIRADA, valor));
    }
    public void transfere(double valor, ContaCorrente contaDestino) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        if (contaDestino == null){
            throw new NullPointerException("A conta desctino não pode ser nula");
        }
        if (!contaDestino.isAtiva()){
            throw new IllegalStateException("Conta destino inativa");
        }
        // Faz a transferencia
        saldo -= valor;
        operacoes.add(new Operacao(LocalDate.now(), LocalTime.now(), TipoOperacao.RETIRADA, valor));
        contaDestino.deposita(valor);
    }
    public void fecha() {
        if (saldo > 0.0) {
            throw new IllegalArgumentException("A conta ainda tem saldo e não pode ser fechada");
        }
        ativa = false;
    }
    // Retorna a lista de todas as operações efetuadas até o momento
    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
    }
    // Retorna a lista de operações de um determinado ano/mês
    public ArrayList<Operacao> getOperacoes(int ano, int mes) {
        ArrayList<Operacao> operacoesDoMes = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            if (operacao.getData().getYear() == ano && operacao.getData().getMonthValue() == mes) {
                operacoesDoMes.add(operacao);
            }
        }
        return operacoesDoMes;
    }
    // Retorna uma string com o extrato de um determinado ano/mês formatado
    public String getExtrato(int ano, int mes) {
        ArrayList<Operacao> operacoesDoMes = getOperacoes(ano, mes);
        String extrato = "Extrato " + mes + "/" + ano + " - Correntista: " + correntista + "\n";
        for (Operacao operacao : operacoesDoMes) {
            extrato += operacao.toString() + "\n";
        }
        extrato += "Saldo atual: R$ " + saldo;
        return extrato;
    }
    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", correntista='" + correntista + '\'' +
                ", saldo=" + saldo +
                ", ativa=" + ativa +
                '}';
    }
}

enum TipoOperacao {
    DEPOSITO,
    RETIRADA
}

class Operacao {
    private LocalDate data;
    private LocalTime hora;
    private TipoOperacao tipo;
    private double valor;
    public Operacao(LocalDate data, LocalTime hora, TipoOperacao tipo, double valor) {
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.valor = valor;
    }
    public LocalDate getData() {
        return data;
    }
    public LocalTime getHora() {
        return hora;
    }
    public TipoOperacao getTipo() {
        return tipo;
    }
    public double getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return data + " " + hora + " - " + tipo + " - R$ " + valor;
    }
}
