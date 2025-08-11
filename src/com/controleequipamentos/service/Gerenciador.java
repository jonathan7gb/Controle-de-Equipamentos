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

                        if (menuAcessar == 1) {
                            boolean achou = false;
                            int totalAchados = 0;
                            String nomeOuCodigo = menus.insiraNomeOuCodigoEquipamento();

                            for (Equipamento equip : lista_equipamentos) {
                                if (equip instanceof MotorEletrico motor) {
                                    if (nomeOuCodigo.toLowerCase().contains(motor.getNome().toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {
                                        achou = true;
                                        totalAchados++;
                                    }
                                }
                            }

                            boolean sair = false;

                            if (totalAchados == 1) {
                                visualizarDetalhes(erros, retornos, nomeOuCodigo, sair, menus, menuAcessarEquipamento);
                            } else if (totalAchados > 1) {
                                retornos.totalProdutosAchados(totalAchados);
                                for (Equipamento equip : lista_equipamentos) {
                                    if (equip instanceof MotorEletrico motor) {
                                        if (nomeOuCodigo.toLowerCase().contains(motor.getNome().toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {
                                            System.out.println(motor.getCodigo() + " - " + motor.getNome());
                                            System.out.println("=================================");
                                        }
                                    }
                                }

                                if (achou == false) {
                                    erros.erroEquipamentoNaoEncontrado();
                                }


                            } else if (menuAcessar == 2) {

                            } else if (menuAcessar == 0) {
                                break;
                            } else {
                                erros.opcaoInvalida();
                            }
                        }
                    }while (menuAcessar != 0) ;

                    }

                }//BREAK DO CASE 2 -> OPÇÃO MENU PRINCIPAL DO SISTEMA
            }
        //ENCERRA O SWITCH -> OPÇÃO MENU PRINCIPAL DO SISTEMA
    }


    public void visualizarDetalhes(Erros erros, Retornos retornos, String nomeOuCodigo, boolean sair, Menus menus, int menuAcessarEquipamento){
        for (Equipamento equip : lista_equipamentos) {
            if (equip instanceof MotorEletrico motor) {
                if (nomeOuCodigo.toLowerCase().contains(motor.getNome().toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {

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
}
