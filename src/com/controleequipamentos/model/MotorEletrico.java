package com.controleequipamentos.model;

public class MotorEletrico extends Equipamento{

    private double potencia;

    public MotorEletrico(String codigo, String nome, int quantidade, double preco, double potencia) {
        super(codigo, nome, quantidade, preco);
        this.potencia = potencia;
    }

    public MotorEletrico() {
        super();
        this.potencia = 0.0;
    }

    public double getPotencia() {
        return potencia;
    }
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return super.toString() + "|| - Potência: " + this.potencia + " kW";
    }
}
