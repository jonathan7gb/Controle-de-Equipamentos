package com.controleequipamentos.views;

public class Retornos {

    public void equipamentoRemovidoComSucesso() {
        System.out.println("|| Equipamento removido com sucesso. ||");
    }

    //=================================================================

    public void equipamentoAdicionadoComSucesso() {
        System.out.println("\n|| Equipamento adicionado com sucesso. ||");
    }

    //=================================================================

    public void totalProdutosAchados(int total){
            System.out.println("\n|| Total de produtos encontrados: " + total + " ||");
            System.out.println("|| ====================================");
    }

    //==================================================

    public void totalEquipamentosEmEstoque(int total){
        System.out.println("|| Total de equipamentos em estoque: " + total + " ||");
        System.out.println("|| ======================================");
    }

    //==================================================

    public void visuazlizarEquipamento(String codigo, String nome) {
        System.out.println("|| " + codigo + " - " + nome);
        System.out.println("|| ==============================");
    }

    //==================================================

}
