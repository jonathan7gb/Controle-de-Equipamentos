package com.controleequipamentos.views;

public class Retornos {

    public void produtoRemovidoComSucesso() {
        System.out.println("|| Produto removido com sucesso. ||");
    }

    //=================================================================

    public void totalProdutosAchados(int total){
            System.out.println("\n|| Total de produtos encontrados: " + total + " ||");
            System.out.println("|| ==============================");
    }
}
