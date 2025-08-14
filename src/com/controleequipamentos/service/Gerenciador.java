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

    public List<Equipamento> getLista_equipamentos() {
        return lista_equipamentos;
    }

    public void setLista_equipamentos(List<Equipamento> lista_equipamentos) {
        this.lista_equipamentos = lista_equipamentos;
    }

    public void gerenciardorEquipamentos(int opcaoMenuPrincipal, Menus menus, Cadastros cadastros, Erros erros, Retornos retornos){

        switch (opcaoMenuPrincipal) {
            //========= CADASTRO DE EQUIPAMENTOS =========
            case 1 -> {
                int menuCadastro = -1;

                do {
                    menuCadastro = menus.menuCadastrarEquipamentos();
                    boolean cadastrado = false;

                    if (menuCadastro == 1) {
                        MotorEletrico motor_eletrico = cadastros.cadastrarMotorEletrico();
                        for(Equipamento equip : lista_equipamentos){
                            if(equip.getCodigo().equals(motor_eletrico.getCodigo())){
                                erros.erroEquipamentoJaCadastrado();
                                cadastrado =  true;
                                return;
                            }
                        }

                        if(cadastrado == false){
                            lista_equipamentos.add(motor_eletrico);
                            retornos.equipamentoAdicionadoComSucesso();

                        }

                    } else if (menuCadastro == 2) {
                        PainelControle painel_controle = cadastros.cadastrarPainelControle();
                        for(Equipamento equip : lista_equipamentos){
                            if(equip.getCodigo().equals(painel_controle.getCodigo())){
                                erros.erroEquipamentoJaCadastrado();
                                cadastrado =  true;
                                return;
                            }
                        }
                        if(cadastrado == false) {
                            lista_equipamentos.add(painel_controle);
                            retornos.equipamentoAdicionadoComSucesso();
                        }
                    } else if (menuCadastro == 0) {
                        break;
                    } else {
                        erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de cadastro
                    }
                } while (menuCadastro != 0);
            } //BREAK DO CASE 1 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 2 -> {
                // ========== ACESSAR EQUIPAMENTO ========
                if(lista_equipamentos.isEmpty()){
                    erros.nenhumEquipamentoCadastrado(); // Caso a Lista esteja vazia printa erro
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
                                            retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
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
                                                retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
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
                                erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de acesso
                            }

                    }while (menuAcessar != 0) ;

                    }

                }//BREAK DO CASE 2 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 3 -> {
                // ============ LISTAR EQUIPAMENTOS ========
                int escolhaListar = 0;
                do {
                    escolhaListar = menus.listarEquipamentos();

                    switch (escolhaListar) {
                        case 1 -> {
                            boolean encontrado = false;
                            System.out.println("|| ====== MOTORES ELÉTRICOS ===== ||");
                            for(Equipamento equip : lista_equipamentos){
                                if (equip instanceof MotorEletrico motor){
                                    retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                erros.erroEquipamentoNaoEncontrado();
                            }
                        } //BREAK DO CASE 1 -> ESCOLHA LISTAR

                        case 2 -> {
                            boolean encontrado = false;
                            System.out.println("|| ====== PAINÉIS DE CONTROLE ===== ||");
                            for(Equipamento equip : lista_equipamentos){
                                if (equip instanceof PainelControle painel){
                                    retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                erros.erroEquipamentoNaoEncontrado();
                            }
                        } //BREAK DO CASE 2 -> ESCOLHA LISTAR

                        case 3 -> {
                            boolean encontrado = false;
                            System.out.println("|| ====== TODOS EQUIPAMENTOS ===== ||");
                            for(Equipamento equip : lista_equipamentos){
                                if (equip instanceof PainelControle painel){
                                    retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                    encontrado = true;
                                }else if (equip instanceof MotorEletrico motor){
                                    retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                erros.erroEquipamentoNaoEncontrado();
                            }
                        } //BREAK DO CASE 3 -> ESCOLHA LISTAR

                        case 0 -> {
                            break;
                        } //BREAK DO CASE 0 -> ESCOLHA LISTAR

                        default -> {
                            erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de listar
                        } //BREAK DO CASE DEFAULT -> ESCOLHA LISTAR
                    }
                }while(escolhaListar != 0);
            }//BREAK DO CASE 3 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 4 ->{
                // ============ RELATÓRIOS DE EQUIPAMENTOS ========
                int opcaoRelatorio = -1;
                do{
                    opcaoRelatorio = menus.menuRelatorios();

                    switch (opcaoRelatorio){
                        case 1 -> {
                            retornos.totalEquipamentosEmEstoque(Equipamento.getQuantidadeDeEquipamentosEmEstoque());
                        }//BREAK DO CASE 1 -> ESCOLHA RELATÓRIOS

                        case 2 -> {
                            if(lista_equipamentos.isEmpty()){
                                erros.nenhumEquipamentoCadastrado(); // Caso a Lista esteja vazia printa erro
                                break;
                            }else {
                                boolean achou = false;
                                double maiorPreco = 0.0;
                                String codigoDoMaior = "";
                                for (Equipamento equip : lista_equipamentos) {
                                    if (equip instanceof MotorEletrico motor) {
                                        if (motor.getPreco() > maiorPreco) {
                                            maiorPreco = motor.getPreco();
                                            codigoDoMaior = motor.getCodigo();
                                        }
                                    } else if (equip instanceof PainelControle painel) {
                                        if (painel.getPreco() > maiorPreco) {
                                            maiorPreco = painel.getPreco();
                                            codigoDoMaior = painel.getCodigo();
                                        }
                                    }
                                }

                                for (Equipamento equipamento : lista_equipamentos) {
                                    if (equipamento instanceof MotorEletrico motor) {
                                        if (motor.getCodigo().equals(codigoDoMaior)) {
                                            System.out.println("|| PRODUTO MAIS CARO EM ESTOQUE");
                                            retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                            System.out.println("|| Preço: R$" + motor.getPreco());
                                            System.out.println("|| ==============================");
                                            achou = true;
                                        }
                                    } else if (equipamento instanceof PainelControle painel) {
                                        if (painel.getCodigo().equals(codigoDoMaior)) {
                                            System.out.println("|| PRODUTO MAIS CARO EM ESTOQUE");
                                            retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                            System.out.println("|| Preço: R$" + painel.getPreco());
                                            System.out.println("|| ==============================");
                                            achou = true;
                                        }
                                    }
                                }

                                if (!achou) {
                                    erros.erroEquipamentoNaoEncontrado(); // Erro caso o equipamento não seja encontrado
                                }
                            }

                        }//BREAK DO CASE 2 -> ESCOLHA RELATÓRIOS

                        case 3 -> {
                            if(lista_equipamentos.isEmpty()){
                                erros.nenhumEquipamentoCadastrado(); // Caso a Lista esteja vazia printa erro
                                break;
                            }else {
                                boolean achou = false;
                                int maiorQuantidade = 0;
                                String codigoDoMaior = "";
                                for (Equipamento equip : lista_equipamentos) {
                                    if (equip instanceof MotorEletrico motor) {
                                        if (motor.getQuantidade() > maiorQuantidade) {
                                            maiorQuantidade = motor.getQuantidade();
                                            codigoDoMaior = motor.getCodigo();
                                        }
                                    } else if (equip instanceof PainelControle painel) {
                                        if (painel.getQuantidade() > maiorQuantidade) {
                                            maiorQuantidade = painel.getQuantidade();
                                            codigoDoMaior = painel.getCodigo();
                                        }
                                    }
                                }

                                for (Equipamento equipamento : lista_equipamentos) {
                                    if (equipamento instanceof MotorEletrico motor) {
                                        if (motor.getCodigo().equals(codigoDoMaior)) {
                                            System.out.println("|| PRODUTO COM MAIS QUANTIDADE EM ESTOQUE");
                                            retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                            System.out.println("|| Quantidade: " + motor.getQuantidade());
                                            System.out.println("|| ==============================");
                                            achou = true;
                                        }
                                    } else if (equipamento instanceof PainelControle painel) {
                                        if (painel.getCodigo().equals(codigoDoMaior)) {
                                            System.out.println("|| PRODUTO COM MAIS QUANTIDADE EM ESTOQUE");
                                            retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                            System.out.println("|| Quantidade: " + painel.getQuantidade());
                                            System.out.println("|| ==============================");
                                            achou = true;
                                        }
                                    }
                                }

                                if (!achou) {
                                    erros.erroEquipamentoNaoEncontrado(); // Erro caso o equipamento não seja encontrado
                                }
                            }
                        }//BREAK DO CASE 3 -> ESCOLHA RELATÓRIOS

                        case 4 -> {
                            if(lista_equipamentos.isEmpty()){
                                erros.nenhumEquipamentoCadastrado(); // Caso a Lista esteja vazia printa erro
                                break;
                            }else{
                                System.out.println("|| PRODUTO(S) COM QUANTIDADE EM ESTOQUE INFERIOR A 5 ");
                                for(Equipamento equipamento : lista_equipamentos){
                                    if(equipamento instanceof MotorEletrico motor){
                                        if(motor.getQuantidade() < 5){
                                            retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                        }
                                    }else if(equipamento instanceof PainelControle painel){
                                        if (painel.getQuantidade() < 5){
                                            retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                        }
                                    }
                                }
                            }
                        }//BREAK DO CASE 4 -> ESCOLHA RELATÓRIOS

                        default -> {
                            erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de acesso
                            break;
                        }
                    }
                }while(opcaoRelatorio != 0);

            }//BREAK DO CASE 4 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

            case 5 -> {
                if(lista_equipamentos.isEmpty()){
                    erros.nenhumEquipamentoCadastrado(); // Caso a Lista esteja vazia printa erro
                    break;
                }else{
                    boolean achou = false;
                    System.out.println("\n|| ===== Buscar por preço ===== ||");
                    double precoMinimo = menus.insiraPrecoPesquisa("mínimo");
                    double precoMaximo = menus.insiraPrecoPesquisa("máximo");
                    System.out.println("\n|| RESULTADOS - R$" + precoMinimo +" -> R$" + precoMaximo + " ||\n");

                    for(Equipamento equipamento : lista_equipamentos){
                        if (equipamento instanceof MotorEletrico motor){
                            if(motor.getPreco() >= precoMinimo && motor.getPreco() <= precoMaximo) {
                                System.out.println("|| Preço: R$" + motor.getPreco());
                                retornos.visuazlizarEquipamento(motor.getCodigo(), motor.getNome());
                                achou = true;
                            }
                        }else if(equipamento instanceof PainelControle painel){
                            if(painel.getPreco() >= precoMinimo && painel.getPreco() <= precoMaximo) {
                                System.out.println("|| Preço: R$" + painel.getPreco());
                                retornos.visuazlizarEquipamento(painel.getCodigo(), painel.getNome());
                                achou = true;
                            }
                        }
                    }

                    System.out.println("");

                    if (!achou) {
                        erros.erroEquipamentoNaoEncontrado(); // Erro caso o equipamento não seja encontrado
                        System.out.println("");
                        System.out.println("");
                    }
                }
            }//BREAK DO CASE 5 -> OPÇÃO MENU PRINCIPAL DO SISTEMA

        }//ENCERRA O SWITCH -> OPÇÃO MENU PRINCIPAL DO SISTEMA
    }


    public void visualizarDetalhesMotor(Erros erros, Retornos retornos, String nomeOuCodigo, boolean sair, Menus menus, int menuAcessarEquipamento){
        boolean encontrado = false;
        for (Equipamento equip : lista_equipamentos) {
            if (equip instanceof MotorEletrico motor) {
                if (motor.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(motor.getCodigo())) {
                    encontrado = true;
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
                                    erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de movimentar estoque
                                }
                            }
                            case 3 ->{
                                retornos.equipamentoRemovidoComSucesso();
                                lista_equipamentos.remove(motor);
                                Equipamento.setQuantidadeDeEquipamentosEmEstoque(Equipamento.getQuantidadeDeEquipamentosEmEstoque() - 1);
                                sair = true;
                            }
                            case 0 ->{
                                break;
                            }
                            default -> {
                                erros.opcaoInvalida(); // Erro caso a opção seja inválida no menu de acesso
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (!encontrado) {
            erros.erroEquipamentoNaoEncontrado(); // Erro caso o equipamento não seja encontrado
        }
    }

    public void visualizarDetalhesPainel(Erros erros, Retornos retornos, String nomeOuCodigo, boolean sair, Menus menus, int menuAcessarEquipamento){
       boolean encontrado = false;
        for (Equipamento equip : lista_equipamentos) {
            if (equip instanceof PainelControle painel) {
                if (painel.getNome().toLowerCase().contains(nomeOuCodigo.toLowerCase()) || nomeOuCodigo.equalsIgnoreCase(painel.getCodigo())) {
                    encontrado = true;
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
                                retornos.equipamentoRemovidoComSucesso();
                                lista_equipamentos.remove(painel);
                                Equipamento.setQuantidadeDeEquipamentosEmEstoque(Equipamento.getQuantidadeDeEquipamentosEmEstoque() - 1);
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
        if (!encontrado) {
            erros.erroEquipamentoNaoEncontrado(); // Erro caso o equipamento não seja encontrado
        }
    }
}
