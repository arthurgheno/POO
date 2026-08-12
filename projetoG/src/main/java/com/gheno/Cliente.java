package com.gheno;
public class Cliente{
  private String nome;
  private String cpf;
  private int pontos;
  private double valor;

  public Cliente(){
    nome="";
    cpf="";
    pontos=0;
    valor=0;
  }

  public Cliente(String nome, String cpf){
    this.nome = nome;
    this.cpf = cpf;
    this.pontos = 0;
    this.valor = 0;
  }
  public Cliente(String nome, String cpf, int pontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.pontos = pontos;
    }

  public String getNome() {
    return nome;
  }


  public String getCpf() {
    return cpf;
  }


  public int getPontos() {
    return pontos;
  }

  public double getValor(){
    return valor;
  }

  public int calculaPontos(int pontos, double valor) {
    if (valor < 500) {
        valor = valor / 100;
        valor = Math.round(valor);
    } else {
        valor = valor / 500;
        valor = Math.round(valor);
        valor = valor * 5;
    }
    pontos = (int) valor;
    return pontos;
}
  public double calculaDesconto(double valor){
    if(pontos<10){
        System.out.println("Sem desconto");
        return valor;
    }
    else if(pontos>=10 && pontos<50){
        return valor-(valor*0.10);
    }
    else{
        return valor-(valor*0.20);
    }
  }
  public double registrarCompra(int opcao, double valor){
    if(opcao == 1){
        int pontosGanhos = calculaPontos(pontos,valor);
        this.pontos += pontosGanhos;
        return valor;
    }
    else if(opcao == 2){
        if(pontos<10){
            System.out.println("Pontos não suficientes para desconto");
            return valor;
        }
    else{
        double valorComDesconto = calculaDesconto(valor);
        this.pontos -=10;
        return valorComDesconto;
    }
  }
  else{
    throw new IllegalArgumentException("Opção Inválida");
  }
}
}
