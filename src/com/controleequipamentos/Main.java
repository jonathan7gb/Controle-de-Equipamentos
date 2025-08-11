package com.controleequipamentos;
import com.controleequipamentos.service.Gerenciador;
import com.controleequipamentos.model.*;
import com.controleequipamentos.views.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        Menus menu = new Menus();
        Cadastros cadastro = new Cadastros();
        Erros erro = new Erros();
        SairSistema sair = new SairSistema();
        Retornos retornos = new Retornos();

        int opcao = -1;

        do{
            opcao = menu.menuPrincipal();

            if(opcao > 0 && opcao < 4){
                gerenciador.gerenciardorEquipamentos(opcao, menu, cadastro, erro,retornos);
            }else if(opcao < 0 || opcao > 3){
                erro.opcaoInvalida();
            }else{
                sair.sairSistema();
            }
        }while(opcao != 0);




    }
}