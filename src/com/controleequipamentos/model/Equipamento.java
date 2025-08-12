package com.controleequipamentos.model;

public class Equipamento {

    private String codigo;
    private String nome;
    private int quantidade;
    private double preco;
    private static int quantidadeDeEquipamentosEmEstoque = 0;

    public Equipamento(){
        this.codigo = "";
        this.nome = "";
        this.quantidade = 0;
        this.preco = 0.0;
        quantidadeDeEquipamentosEmEstoque++;
    }

    public Equipamento(String codigo, String nome, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        quantidadeDeEquipamentosEmEstoque++;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static int getQuantidadeDeEquipamentosEmEstoque() {
        return quantidadeDeEquipamentosEmEstoque;
    }

    public static void setQuantidadeDeEquipamentosEmEstoque(int quantidadeDeEquipamentosEmEstoque) {
        Equipamento.quantidadeDeEquipamentosEmEstoque = quantidadeDeEquipamentosEmEstoque;
    }

    public static void addQuantidadeDeEquipamentosEmEstoque(int quantidade) {
        Equipamento.quantidadeDeEquipamentosEmEstoque += quantidade;
    }

    @Override
    public String toString() {
        return "|| - Nome: " + this.nome + "\n|| - Código: " + this.codigo + "\n|| - Quantidade: " + this.quantidade + "\n|| - Preço: R$" + this.preco + "\n";
    }
}
