package com.gheno.ComposiçãoDeTrens;

import java.util.Scanner;

public class AppTrem{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcao = 0, id;
        Garagem garagem = new Garagem();
        Patio patio = new Patio();

        do{
            menu();
            System.out.println("Escolha uma opção:");
            opcao = in.nextInt();
            switch(opcao){
                case 1: { System.out.println("Digite o ID do trem");
                        id = in.nextInt();
                        Trem t = new Trem(id);
                        patio.add(t);
                        break;
                        }
                case 2: { System.out.println("Digite o ID do trem a editar");
                        int idTrem = in.nextInt();
                        Trem tremEditado = null;
                        for (Trem t : patio.getLista()) {
                            if (t.getId() == idTrem) {
                                tremEditado = t;
                            }
                        }


                        if (tremEditado == null) {
                            System.out.println("Trem não encontrado");
                            break;
                        }

                        break;
                        }
                case 3: { System.out.println("Trens no pátio:");
                        for (Trem t : patio.getLista()) {
                            System.out.println(t.getId());
                        }
                        break;
                        }
                case 4: { System.out.println("Digite o ID do trem");
                        int idConsulta = in.nextInt();
                        Trem tremConsultado = null;
                        for (Trem t : patio.getLista()) {
                            if (t.getId() == idConsulta) {
                                tremConsultado = t;
                            }
                        }

                        if (tremConsultado == null) {
                            System.out.println("Trem não encontrado");
                            break;
                        }

                        System.out.println("Identificador: " + tremConsultado.getId());
                        System.out.println("Quantidade de locomotivas: " + tremConsultado.getQuantidadeLocomotivas());
                        System.out.println("Quantidade de vagões: " + tremConsultado.getQuantidadeVagoes());
                        System.out.println("Passageiros: " + tremConsultado.getQuantidadePassageiros());
                        System.out.println("Lugares restaurante: " + tremConsultado.getLugaresRestaurante());
                        System.out.println("Carga não refrigerada: " + tremConsultado.getCargaNaoRefrigerada());
                        System.out.println("Carga refrigerada: " + tremConsultado.getCargaRefrigerada());
                        break;
                        }
                case 5: { System.out.println("Digite o ID do trem a desfazer");
                        int idDesfazer = in.nextInt();
                        Trem tremDesfazer = null;
                        for (Trem t : patio.getLista()) {
                            if (t.getId() == idDesfazer) {
                                tremDesfazer = t;
                            }
                        }

                        if (tremDesfazer == null) {
                            System.out.println("Trem não encontrado");
                            break;
                        }

                        while (!tremDesfazer.getCarros().isEmpty()) {
                            CarroFerroviario carroLivre = tremDesfazer.desengatarUltimoCarro();
                            garagem.add(carroLivre);
                        }
                        patio.excluir(tremDesfazer);
                        break;
                        }
                case 6: { System.out.println("Saindo...");
                        break;
                        }
                default: System.out.println("Opção inválida");
                        break;
            }
        }while(opcao>0 || opcao<7);
    }

    public static void menu(){
        System.out.println("1 - Criar um trem");
        System.out.println("2 - Editar um trem");
        System.out.println("3 - Listar trens do pátio");
        System.out.println("4 - Listar características de um trem");
        System.out.println("5 - Desfazer um trem");
        System.out.println("6 - Encerrar");
    }
}
