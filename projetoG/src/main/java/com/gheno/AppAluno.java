package com.gheno;

public class AppAluno{

    public static void main(String[] args) {
        AlunoNaTurma a1 = new AlunoNaTurma("Zé", "POO");
        a1.informaNota(7.0);
        a1.informaNota(8.0);
        AlunoNaTurma a2 = new AlunoNaTurma("Zé", "ALEST I");
        a2.informaNota(5.0);
        a2.informaNota(3.0);

        System.out.println(a1.toString());
        System.out.println("Média do"+a1.getNomeAluno()+"em"+a1.getNomeDisciplina()+":"+a1.media()+","+(a1.aprovado()?"APROVADO":"REPROVADO"));
        System.out.println(a2.toString());
        System.out.println("Média do"+a2.getNomeAluno()+"em"+a2.getNomeDisciplina()+":"+a2.media()+","+(a2.aprovado()?"APROVADO":"REPROVADO"));
    }
}
