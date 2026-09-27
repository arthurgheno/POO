package com.gheno.ComposiçãoDeTrens;

import java.util.ArrayList;
import java.util.List;

public class Trem {
    private int id;
    private List<CarroFerroviario> carros;

    public Trem(int id) {
        this.id = id;
        this.carros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<CarroFerroviario> getCarros() {
        return carros;
    }

    public void engatarCarro(CarroFerroviario carro) {
        if (carros.isEmpty() && !(carro instanceof Locomotiva)) {
            throw new IllegalArgumentException("O primeiro carro deve ser uma locomotiva");
        }

        boolean existeVagao = false;
        for (CarroFerroviario c : carros) {
            if (c instanceof Vagao) {
                existeVagao = true;
            }
        }

        if (carro instanceof Locomotiva && existeVagao) {
            throw new IllegalArgumentException("Não é possível engatar uma locomotiva após um vagão");
        }

        double capacidadeTotal = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof Locomotiva) {
                capacidadeTotal += c.getPesoMaximo();
            }
        }

        double cargaTotal = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof Vagao) {
                cargaTotal += c.getPesoMaximo();
            }
        }

        if (carro instanceof Vagao && (cargaTotal + carro.getPesoMaximo()) > capacidadeTotal) {
            throw new IllegalArgumentException("Peso excede a capacidade das locomotivas");
        }

        carros.add(carro);
        carro.engatar();
    }

    public CarroFerroviario desengatarUltimoCarro() {
        if (carros.isEmpty()) {
            throw new IllegalStateException("O trem não possui carros para desengatar");
        }
        CarroFerroviario ultimo = carros.remove(carros.size() - 1);
        ultimo.desengatar();
        return ultimo;
    }

    public int getQuantidadeLocomotivas() {
        int quantidade = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof Locomotiva) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int getQuantidadeVagoes() {
        int quantidade = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof Vagao) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int getQuantidadePassageiros() {
        int total = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof VagaoDePassageiros vp) {
                total += vp.getQntdAssentos();
            }
        }
        return total;
    }

    public int getLugaresRestaurante() {
        int total = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof VagaoRestaurante vr) {
                total += vr.getQntdAssentos();
            }
        }
        return total;
    }

    public double getCargaNaoRefrigerada() {
        double total = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof VagaoDeCarga && !(c instanceof VagaoDeCargaRefrigerado)) {
                total += ((VagaoDeCarga) c).getCapacidadeCarga();
            }
        }
        return total;
    }

    public double getCargaRefrigerada() {
        double total = 0;
        for (CarroFerroviario c : carros) {
            if (c instanceof VagaoDeCargaRefrigerado vcr) {
                total += vcr.getCapacidadeCarga();
            }
        }
        return total;
    }
}
