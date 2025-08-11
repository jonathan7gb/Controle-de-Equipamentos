package com.controleequipamentos.service;
import com.controleequipamentos.model.*;
import com.controleequipamentos.views.*;
import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

    private List<Equipamento> lista_equipamentos;

    public Gerenciador(){
        this.lista_equipamentos = new ArrayList<>();
    }



    public void gerenciardorEquipamentos(int opcaoMenuPrincipal, Menus menus, Cadastros cadastros, Erros erros, Retornos retornos){

        switch (opcaoMenuPrincipal) {
            //========= CADASTRO DE EQUIPAMENTOS =========
            case 1 -> {
                int menuCadastro = -1;

                do {
                    menuCadastro = menus.menuCadastrarEquipamentos();

                    if (menuCadastro == 1) {
                        MotorEletrico motor_eletrico = cadastros.cadastrarMotorEletrico();
                        lista_equipamentos.add(motor_eletrico);
                    } else if (menuCadastro == 2) {
                        PainelControle painel_controle = cadastros.cadastrarPainelControle();
                        lista_equipamentos.add(painel_controle);
                    } else if (menuCadastro == 0) {
                        break;
                    } else {
                        erros.opcaoInvalida();
                    }
                } while (menuCadastro != 0);
            } //BREAK DO CASE 1 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 2 -> {
                // ========== ACESSAR EQUIPAMENTO ========
                if (lista_equipamentos.isEmpty()) {
                    erros.nenhumEquipamentoCadastrado();
                } else {
                    int menuAcessar = -1;
                    int menuAcessarEquipamento = -1;

                    do {
                        menuAcessar = menus.menuEscolhaAcessoEquipamento();
                        int totalAchados = 0;
                        if (menuAcessar == 1) {
                            boolean achou = false;
                            totalAchados = 0;
                            String nomeOuCodigo = menus.insiraNomeOuCodigoEquipamento();

                            for (Equipamento equip : lista_equipamentos) {
                                if (equip instanceof MotorEletrico motor) {
                                    if (motor.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {
                                        achou = true;
                                        totalAchados++;
                                    }
                                }
                            }

                            boolean sair = false;

                             if (totalAchados >= 1) {
                                retornos.totalProdutosAchados(totalAchados);
                                for (Equipamento equip : lista_equipamentos) {
                                    if (equip instanceof MotorEletrico motor) {
                                        if (motor.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {
                                            System.out.println("|| " + motor.getCodigo() + " - " + motor.getNome());
                                            System.out.println("|| ==============================");
                                        }
                                    }
                                }

                                String codigoEquip = menus.insiraCodigo();
                                 visualizarDetalhesMotor(erros, retornos, codigoEquip, sair, menus, menuAcessarEquipamento);
                            }

                            if (!achou) {
                                erros.erroEquipamentoNaoEncontrado();
                            }

                        } else if (menuAcessar == 2) {
                               boolean achou = false;
                               totalAchados = 0;
                               String nomeOuCodigo = menus.insiraNomeOuCodigoEquipamento();

                                for (Equipamento equip : lista_equipamentos) {
                                    if (equip instanceof PainelControle painel) {
                                        if (painel.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(painel.getCodigo())) {
                                            achou = true;
                                            totalAchados++;
                                        }
                                    }
                                }

                                boolean sair = false;

                                if (totalAchados >= 1) {
                                    retornos.totalProdutosAchados(totalAchados);
                                    for (Equipamento equip : lista_equipamentos) {
                                        if (equip instanceof PainelControle painel) {
                                            if (painel.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(painel.getCodigo())) {
                                                System.out.println("|| " + painel.getCodigo() + " - " + painel.getNome());
                                                System.out.println("|| ==============================");
                                            }
                                        }
                                    }

                                    String codigoEquip = menus.insiraCodigo();
                                    visualizarDetalhesPainel(erros, retornos, codigoEquip, sair, menus, menuAcessarEquipamento);
                                }

                                if (!achou) {
                                    erros.erroEquipamentoNaoEncontrado();
                                }
                            } else if (menuAcessar == 0) {
                                break;
                            } else {
                                erros.opcaoInvalida();
                            }

                    }while (menuAcessar != 0) ;

                    }

                }//BREAK DO CASE 2 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 3 -> {

            }
            }//ENCERRA O SWITCH -> OPÇÃO MENU PRINCIPAL DO SISTEMA
    }


    public void visualizarDetalhesMotor(Erros erros, Retornos retornos, String nomeOuCodigo, boolean sair, Menus menus, int menuAcessarEquipamento){
        for (Equipamento equip : lista_equipamentos) {
            if (equip instanceof MotorEletrico motor) {
                if (motor.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {

                    while(menuAcessarEquipamento != 0 && !sair){
                        menuAcessarEquipamento = menus.menuAcessoEquipamento(motor.getNome());
                        switch (menuAcessarEquipamento){
                            case 1 -> {
                                System.out.println("|| ===== DETALHES ===== ||");
                                System.out.println(motor);
                                System.out.println("|| ==================== ||");
                                break;
                            }
                            case 2 ->{
                                int escolhaMovimentarEstoque = menus.movimentarEstoque(motor.getQuantidade());
                                if (escolhaMovimentarEstoque == 1){
                                    int quantidade = menus.insiraQuantidade("adicionar");
                                    motor.setQuantidade(motor.getQuantidade() + quantidade);
                                }else if (escolhaMovimentarEstoque == 2 ){
                                    int quantidade = menus.insiraQuantidade("remover");
                                    int quantidadeValidar = motor.getQuantidade() - quantidade;
                                    if(quantidadeValidar < 0){
                                        erros.erroMovimentacaoInvalida("quantidade não pode ser menor que 0");
                                    }else{
                                        motor.setQuantidade(quantidadeValidar);
                                    }
                                }else if(escolhaMovimentarEstoque == 0){
                                    break;
                                }else{
                                    erros.opcaoInvalida();
                                }
                            }
                            case 3 ->{
                                retornos.produtoRemovidoComSucesso();
                                lista_equipamentos.remove(motor);
                                sair = true;
                            }
                            case 0 ->{
                                break;
                            }
                            default -> {
                                erros.opcaoInvalida();
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    public void visualizarDetalhesPainel(Erros erros, Retornos retornos, String nomeOuCodigo, boolean sair, Menus menus, int menuAcessarEquipamento){
        for (Equipamento equip : lista_equipamentos) {
            if (equip instanceof PainelControle painel) {
                if (painel.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(painel.getCodigo())) {

                    while(menuAcessarEquipamento != 0 && !sair){
                        menuAcessarEquipamento = menus.menuAcessoEquipamento(painel.getNome());
                        switch (menuAcessarEquipamento){
                            case 1 -> {
                                System.out.println("|| ===== DETALHES ===== ||");
                                System.out.println(painel);
                                System.out.println("|| ==================== ||");
                                break;
                            }
                            case 2 ->{
                                int escolhaMovimentarEstoque = menus.movimentarEstoque(painel.getQuantidade());
                                if (escolhaMovimentarEstoque == 1){
                                    int quantidade = menus.insiraQuantidade("adicionar");
                                    painel.setQuantidade(painel.getQuantidade() + quantidade);
                                }else if (escolhaMovimentarEstoque ==2 ){
                                    int quantidade = menus.insiraQuantidade("remover");
                                    int quantidadeValidar = painel.getQuantidade() - quantidade;
                                    if(quantidadeValidar < 0){
                                        erros.erroMovimentacaoInvalida("quantidade não pode ser menor que 0");
                                    }else{
                                        painel.setQuantidade(quantidadeValidar);
                                    }
                                }else if(escolhaMovimentarEstoque == 0){
                                    break;
                                }else{
                                    erros.opcaoInvalida();
                                }
                            }
                            case 3 ->{
                                retornos.produtoRemovidoComSucesso();
                                lista_equipamentos.remove(painel);
                                sair = true;
                            }
                            case 0 ->{
                                break;
                            }
                            default -> {
                                erros.opcaoInvalida();
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}
