Prova Prática – Sistema de Controle de Equipamentos WEG Versão 1.0
Situação-Problema
A WEG precisa melhorar o controle dos equipamentos usados na manutenção das suas linhas de produção. O controle atual dificulta a localização rápida e o acompanhamento das quantidades disponíveis.

Você foi contratado como desenvolvedor Java para criar um sistema via terminal, que permita o cadastro, listagem, pesquisa, remoção e movimentação dos equipamentos.

O sistema deve utilizar os conceitos de Programação Orientada a Objetos que você estudou, incluindo tratamento de exceções para entradas inválidas.

Objetivo
Desenvolver uma aplicação Java com as classes necessárias para representar os equipamentos e gerenciar seu estoque, aplicando encapsulamento, herança, polimorfismo, sobrescrita, listas e tratamento de exceções.

Requisitos Técnicos
1. Classe Equipamento
Atributos:
codigo (String)
nome (String)
quantidade (int)
preco (double)
Construtores padrão e parametrizado
Métodos getters e setters
Método toString() sobrescrito para exibir os dados do equipamento
2. Subclasses de Equipamento
MotorEletrico com atributo adicional:
potencia (double)
PainelControle com atributo adicional:
tensao (String)
3. Classe EstoqueService
Gerenciar uma lista de Equipamento

Permitir:

Cadastrar equipamentos
Listar todos os equipamentos
Listar equipamentos filtrando por tipo (MotorEletrico ou PainelControle)
Pesquisar equipamento pelo código
Remover equipamento pelo código
Movimentar o estoque (adicionar ou retirar quantidade), não permitindo que a quantidade fique negativa
📌 Movimentação de Estoque
A movimentação de estoque permite atualizar a quantidade de equipamentos disponíveis, garantindo que o controle do estoque esteja sempre correto e atualizado.

O usuário poderá escolher entre duas operações principais:

Adicionar unidades

Esta opção é usada quando chegam equipamentos novos ou quando equipamentos retornam de conserto para o estoque.

Retirar unidades

Esta opção é utilizada para equipamentos que serão usados, descartados, enviados para conserto ou remetidos para outras filiais/setores.

Durante o processo, o sistema solicita o código do equipamento e a quantidade a movimentar, atualizando o estoque conforme a operação escolhida. Caso a retirada ultrapasse a quantidade disponível, o sistema impedirá a operação e exibirá uma mensagem de erro.

4. Classe InterfaceUsuario
Exibir menu via terminal com as opções:

1 - Cadastrar Equipamento

2 - Listar Todos

3 - Listar por Tipo

4 - Pesquisar por Código

5 - Remover por Código

6 - Movimentar Estoque

0 - Sair

Usar try-catch para validar as entradas
Chamar os métodos do EstoqueService para executar as operações
5. Classe Main
Instanciar as classes necessárias e executar o menu
Versão 2.0 – Melhorias e Novas Funcionalidades
Após a finalização da versão 1.0, foram solicitadas melhorias no sistema, contemplando as seguintes funcionalidades extras para aprimorar o controle e a usabilidade:

Funcionalidades Extras (para treinar e pensar)
Relatórios de Estoque
Implementar cálculos e exibir os seguintes relatórios:

Quantidade total de equipamentos em estoque.
Equipamento com maior preço.
Equipamento com maior quantidade disponível.
Equipamentos com estoque baixo (quantidade inferior a 5 unidades).
Busca Avançada por Nome e Preço
Permitir busca por equipamentos que contenham parte do nome informado (não sendo necessário o nome completo ou exato).

Dica: Utilize o método contains() da classe String para verificar se um texto está contido em outro.

Permitir busca por equipamentos com preço acima de um valor mínimo informado pelo usuário.

Exemplo de Tela do Menu – Sistema WEG Versão 2.0
===============================
  Sistema de Controle WEG 2.0
===============================

1 - Cadastrar Equipamento
2 - Listar Todos os Equipamentos
3 - Listar Equipamentos por Tipo
4 - Pesquisar Equipamento por Código
5 - Remover Equipamento por Código
6 - Movimentar Estoque (Adicionar/Retirar Quantidade)

7 - Relatórios de Estoque
8 - Busca Avançada por Nome
9 - Busca Avançada por Preço

0 - Sair

Digite a opção desejada:

Como funcionarão as novas opções:
7 - Relatórios de Estoque

Ao selecionar, o sistema exibirá um submenu ou direto os relatórios:

Quantidade total de equipamentos em estoque
Equipamento com maior preço
Equipamento com maior quantidade
Equipamentos com estoque baixo (quantidade < 5)
8 - Busca Avançada por Nome

O usuário digita uma parte do nome e o sistema lista todos os equipamentos que contenham esse texto no nome.

9 - Busca Avançada por Preço

O usuário informa um valor mínimo de preço e o sistema lista todos os equipamentos com preço acima desse valor.

Critérios de Avaliação
Uso correto de encapsulamento (private, getters/setters)
Implementação correta de herança e sobrescrita do método toString()
utilização de instanceof
Manipulação correta da lista de equipamentos (adicionar, listar, pesquisar, remover)
Implementação funcional da movimentação do estoque com restrição para não ficar negativo
Tratamento adequado de exceções para entradas inválidas
Operação lógica.
Separação lógica das responsabilidades entre as classes
Código organizado, legível (Clean code).
