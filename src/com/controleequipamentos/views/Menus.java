package com.controleequipamentos.views;
import java.util.Scanner;
import com.controleequipamentos.views.Erros;

public class Menus {

    Erros erros = new Erros();
    Scanner scStr = new Scanner(System.in);

    public int menuPrincipal(){
        int opcao = 0;
        boolean valido = false;

        System.out.println("|| ==== Controle de Equipamentos ==== ||");
        System.out.println("|| 1 - Cadastrar Equipamento          ||");
        System.out.println("|| 2 - Acessar Equipamento            ||");
        System.out.println("|| 3 - Listar Equipamentos            ||");
        System.out.println("|| 0 - Sair do Sistema                ||");
        System.out.println("|| ================================== ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        return opcao;
    }

    //=================================================

    public int menuCadastrarEquipamentos(){
        int opcao = 0;
        boolean valido = false;

        System.out.println("\n|| ===== Cadastrar Equipamento ===== ||");
        System.out.println("|| 1 - Cadastrar Motor Elétrico      ||");
        System.out.println("|| 2 - Cadastrar Painel de Controle  ||");
        System.out.println("|| 0 - Voltar ao Menu Principal      ||");
        System.out.println("|| ================================= ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        System.out.println("");
        return opcao;
    }

    //=================================================

    public int menuListarEquipamentos(){
        int opcao = 0;
        boolean valido = false;

        System.out.println("\n|| ===== Listar Equipamentos ===== ||");
        System.out.println("|| 1 - Listar Motores Elétricos     ||");
        System.out.println("|| 2 - Listar Painéis de Controle   ||");
        System.out.println("|| 3 - Listar Todos os Equipamentos ||");
        System.out.println("|| 0 - Voltar ao Menu Principal     ||");
        System.out.println("|| ================================ ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        System.out.println("");
        return opcao;
    }

    //=================================================

    public int menuEscolhaAcessoEquipamento(){
        int opcao = 0;
        boolean valido = false;

        System.out.println("\n|| ===== Acessar Equipamento ===== ||");
        System.out.println("|| 1 - Acessar Motor Elétrico      ||");
        System.out.println("|| 2 - Acessar Painel de Controle  ||");
        System.out.println("|| 0 - Voltar ao Menu Principal    ||");
        System.out.println("|| =============================== ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        System.out.println("");
        return opcao;
    }

    //=================================================

    public int menuAcessoEquipamento(String nomeEquipamento){
        int opcao = 0;
        boolean valido = false;

        System.out.println("\n|| ==== Acessar " + nomeEquipamento + " ==== ||");
        System.out.println("|| 1 - Ver Detalhes             ||");
        System.out.println("|| 2 - Movimentar Estoque       ||");
        System.out.println("|| 3 - Excluir Equipamento      ||");
        System.out.println("|| 0 - Voltar ao Menu Anterior  ||");
        System.out.println("|| ============================ ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();;

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        System.out.println("");
        return opcao;
    }

    //=================================================

    public String insiraNomeOuCodigoEquipamento(){
        System.out.print("|| Insira o nome ou código do equipamento: ");
        String nomeCodigoEquipamento = scStr.nextLine();
        return nomeCodigoEquipamento;
    }

    //=================================================

    public String insiraCodigo(){
        System.out.print("\n|| Insira o código do equipamento desejado: ");
        String codigoEquipamento = scStr.nextLine();
        return codigoEquipamento;
    }

    //=================================================

    public int movimentarEstoque(int quantidadeAtual){
        int opcao = 0;
        boolean valido = false;

        System.out.println("\n|| ===== Movimentar Estoque ===== ||");
        System.out.println("|| 1 - Adicionar ao Estoque      ||");
        System.out.println("|| 2 - Remover do Estoque        ||");
        System.out.println("|| 0 - Voltar ao Menu Anterior   ||");
        System.out.println("|| ============================= ||");
        System.out.println("|| Quantidade Atual: " + quantidadeAtual + "   ||");
        System.out.println("|| ============================= ||");

        while(!valido){
            System.out.print("|| Escolha uma opção: ");
            String opcaoStr = scStr.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            }catch(NumberFormatException e){
                erros.opcaoInvalida();
            }
        }

        System.out.println("");
        return opcao;
    }

    //=================================================

    public int insiraQuantidade( String acao ){
        int quantidade = 0;
        boolean valido = false;

        while(!valido){
            System.out.print("|| Insira a quantidade a " + acao + ": ");
            String quantidadeStr = scStr.nextLine();

            try{
                quantidade = Integer.parseInt(quantidadeStr);
                if (quantidade < 0) {
                    erros.erroQuantidadeInvalida();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.erroQuantidadeInvalida();
            }
        }

        return quantidade;
    }

}
