package com.controleequipamentos.views;

public class Erros {

    public void erroCodigoInvalido() {
        System.out.println("\n|| Código inválido. Deve ser no formato (uma letra maiúscula e um número): ex A1B2-C3D4. ||\n");
    }

    //=================================================================================

    public void erroNomeInvalido() {
        System.out.println("\n|| Nome inválido. Não pode ser vazio. ||\n");
    }

    //=================================================================================

    public void erroQuantidadeInvalida() {
        System.out.println("\n|| Quantidade inválida. Deve ser um número inteiro positivo. ||\n");
    }

    //=================================================================================

    public void precoInvalido() {
        System.out.println("\n|| Preço inválido. Deve ser um Número e deve Positivo. ||\n");
    }

    //=================================================================================

    public void potenciaInvalida() {
        System.out.println("\n|| Potência inválida. Deve ser um Número e Positivo. ||\n");
    }

    //=================================================================================

    public void opcaoInvalida() {
        System.out.println("\n|| Opção inválida. Por favor, escolha uma opção válida. ||\n");
    }

    //=================================================================================

    public void erroEquipamentoNaoEncontrado() {
        System.out.println("\n|| Equipamento não encontrado. Verifique o código ou nome e tente novamente. ||");
    }

    //=================================================================================

    public void erroEquipamentoJaCadastrado() {
        System.out.println("\n|| Equipamento já cadastrado. Verifique o código ou nome e tente novamente. ||\n");
    }

    //=================================================================================

    public void nenhumEquipamentoCadastrado() {
        System.out.println("\n|| Nenhum equipamento cadastrado. ||\n");
    }

    //=================================================================================

}
