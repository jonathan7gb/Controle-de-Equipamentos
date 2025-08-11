package com.controleequipamentos.views;
import java.util.Scanner;
import com.controleequipamentos.model.*;

public class Cadastros {

    Erros erros = new Erros();
    Scanner scStr = new Scanner(System.in);

    public MotorEletrico cadastrarMotorEletrico() {
        boolean valido = false;
        String codigo = "";
        String nome = "";
        int quantidade = 0;
        double preco = 0.0;
        double potencia = 0.0;

        System.out.println("|| ====== Cadastrar Motor Elétrico ====== ||");
        System.out.println("!! ATENÇÃO: O código deve ser no seguinte formato (uma letra maiúscula e um número): ex A1B2-C3D4 !!");

        while (true) {
            System.out.print("Digite o código do motor: ");
            codigo = scStr.nextLine().trim();

            if (codigo.matches("[A-Z]\\d[A-Z]\\d-[A-Z]\\d[A-Z]\\d")) {
                break;
            } else {
               erros.erroCodigoInvalido();
            }
        }

        while(nome.isEmpty()){
            System.out.print("Digite o nome do motor: ");
            nome = scStr.nextLine();
        }

        while(!valido){
            System.out.print("Digite a quantidade de motores deste modelo: ");
            String quantidadeMotor = scStr.nextLine();
            try{
                quantidade = Integer.parseInt(quantidadeMotor);
                if (quantidade < 0) {
                    erros.erroQuantidadeInvalida();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.erroQuantidadeInvalida();
            }
        }

        valido = false;

        while(!valido){
            System.out.print("Digite o preço do motor: R$");
            String precoMotor = scStr.nextLine();
            try{
                preco = Double.parseDouble(precoMotor);
                if (preco < 0) {
                    erros.precoInvalido();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.precoInvalido();
            }
        }

        valido = false;

        while(!valido){
            System.out.print("Digite a potência do motor (kW): ");
            String potenciaMotor = scStr.nextLine();
            try{
                potencia = Double.parseDouble(potenciaMotor);
                if (potencia < 0) {
                    erros.potenciaInvalida();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.potenciaInvalida();
            }
        }

        return new MotorEletrico(codigo, nome, quantidade, preco, potencia);
    }


    //====================================================================================================


    public PainelControle cadastrarPainelControle() {
        boolean valido = false;
        String codigo = "";
        String nome = "";
        int quantidade = 0;
        double preco = 0.0;
        String tensao = "";

        System.out.println("|| ====== Cadastrar Painel de Controle ====== ||");
        System.out.println("!! ATENÇÃO: O código deve ser no seguinte formato (uma letra maiúscula e um número): ex A1B2-C3D4 !!");

        while (true) {
            System.out.print("Digite o código do motor: ");
            codigo = scStr.nextLine().trim();

            if (codigo.matches("[A-Z]\\d[A-Z]\\d-[A-Z]\\d[A-Z]\\d")) {
                break;
            } else {
               erros.erroCodigoInvalido();
            }
        }

        while(nome.isEmpty()){
            System.out.print("Digite o nome do painel: ");
            nome = scStr.nextLine();
        }

        while(!valido){
            System.out.print("Digite a quantidade de painéis deste modelo: ");
            String quantidadeMotor = scStr.nextLine();
            try{
                quantidade = Integer.parseInt(quantidadeMotor);
                if (quantidade < 0) {
                    erros.erroQuantidadeInvalida();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.erroQuantidadeInvalida();
            }
        }

        valido = false;

        while(!valido){
            System.out.print("Digite o preço do painel: R$");
            String precoMotor = scStr.nextLine();
            try{
                preco = Double.parseDouble(precoMotor);
                if (preco < 0) {
                    erros.precoInvalido();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException e){
                erros.precoInvalido();
            }
        }

        valido = false;

        while(tensao.isEmpty()){
            System.out.print("Digite a tensão do painel: ");
            tensao = scStr.nextLine();
        }

        return new PainelControle(codigo, nome, quantidade, preco, tensao);
    }
}
