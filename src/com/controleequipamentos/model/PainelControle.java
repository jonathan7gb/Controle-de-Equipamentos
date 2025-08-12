package com.controleequipamentos.model;

public class PainelControle extends Equipamento{

    private String tensao;
    private static int quantidadeDeEquipamentosEmEstoque;

    public PainelControle(String codigo, String nome, int quantidade, double preco, String tensao) {
        super(codigo, nome, quantidade, preco);
        this.tensao = tensao;
        quantidadeDeEquipamentosEmEstoque++;
    }

    public PainelControle() {
        super();
        this.tensao = "";
        quantidadeDeEquipamentosEmEstoque++;
    }

    public String getTensao() {
        return tensao;
    }
    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    @Override
    public String toString() {
        return super.toString() + "|| - Tensão: " + this.tensao;
    }
}
