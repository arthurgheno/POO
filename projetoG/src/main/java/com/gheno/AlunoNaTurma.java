package com.gheno;

import java.util.ArrayList;
public class AlunoNaTurma {
    private String nomeAluno;
    private String nomeDisciplina;
    private ArrayList<Double> notas;
    private CalculadoraDeNotasPOO calculadoraDeNotasPOO;

    public AlunoNaTurma(String nomeAluno, String nomeDisciplina) {
        this.nomeAluno = nomeAluno;
        this.nomeDisciplina = nomeDisciplina;
        notas = new ArrayList<>();
        this.calculadoraDeNotasPOO = null;
    }
    public String getNomeAluno() {
        return nomeAluno;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void informaNota(double nota){
        notas.add(nota);
    }

    public void defineCalculadoraDeNotas(CalculadoraDeNotasPOO calc){
        this.calculadoraDeNotasPOO = calc;
    }

    public double media(){
        return calculadoraDeNotasPOO.media();
    }

    public boolean aprovado(){
        return calculadoraDeNotasPOO.aprovado();
    }

    @Override
    public String toString() {
        return "AlunoNaTurma [nomeAluno=" + nomeAluno + ", nomeDisciplina=" + nomeDisciplina + ", notas=" + notas + "]";
    }






}
