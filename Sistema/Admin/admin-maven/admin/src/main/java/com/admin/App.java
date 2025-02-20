package com.admin;

import view.View;
import java.util.Scanner;



public class App {

    public static int menuVisitante(Scanner scanner) {
        while(true) {
            System.out.println("1-Entrar no Sistema\n2-Cadastrar Conta\n3-Sair");
            System.out.print("Digite a opção desejada: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Digite seu e-mail: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();
                    int idConta = View.entrarNoSistema(email, senha);
                    if (idConta == -1) { System.out.println("E-MAIL OU SENHA INVÁLIDOS"); }
                    else { return idConta; }
                    break;
                case 2:
                    inserirCliente(scanner);
                    System.out.println("CLIENTE CADASTRADO COM SUCESSO");
                    break;
                case 3:
                    System.out.println("FIM DE EXECUÇÃO");
                    System.exit(0);
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        }
    }

    public static boolean menuAdmin(Scanner scanner) {
        while (true) {
            System.out.println("1-Inserir Cliente\n2-Listar Clientes\n3-Atualizar Cliente\n4-Deletar Cliente\n5-Inserir Tipo de Lançamento\n6-Listar Tipos de Lançamentos\n7-Atualizar Tipo de Lançamento\n8-Deletar Tipo de Lançamento\n9-Analisar Pedido de Cartão\n10-Listar Cartões\n11-Atualizar Cartão\n12-Deletar Cartão\n13-Listar Contas\n14-Listar Lançamentos");
            System.out.print("Digite a opção desejada: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    inserirCliente(scanner);
                    break;
                case 2:
                    listarClientes(scanner);
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    deletarCliente(scanner);
                    break;
                case 5:
                    inserirTipoLancamento(scanner);
                    break;
                case 6:
                    listarTiposLancamentos(scanner);
                    break;
                case 7:
                    atualizarTipoLancamento(scanner);
                    break;
                case 8:
                    deletarTipoLancamento(scanner);
                    break;
                case 9:
                    analisarPedidosCartao(scanner); // criar PedidosCartao com abrir e salvar
                    break;
                case 10:
                    listarCartoes(); // fazer view e ui
                    break;
                case 11:
                    atualizarCartao(scanner); // fazer view e ui
                    break;
                case 12:
                    deletarCartao(scanner); // fazer view e ui
                case 13:
                    listarContas(); // criar Contas com salvar e abrir
                    break;
                case 14:
                    listarLancamentos(); // criar Lancamentos com salvar e abrir
                    break;
                case 15:
                    return true; // logout recebe true caso o usuário deseje sair
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        }
    }

    public static void inserirCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite um e-mail para o cliente: ");
        String email = scanner.nextLine();
        System.out.print("Digite uma senha para o cliente: ");
        String senha = scanner.nextLine();
        View.inserirCliente(nome, cpf, telefone, idade, email, senha);
    }

    public static void listarClientes() {
        View.listarClientes();
    }

    public static void atualizarCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente desejado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o novo telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a nova idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo email do cliente: ");
        String email = scanner.nextLine();
        System.out.print("Digite a nova senha do cliente: ");
        String senha = scanner.nextLine();
        View.atualizarCliente(id, nome, cpf, telefone, idade, email, senha); }

    public static void deletarCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente desejado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        View.deletarCliente(id);
    }

    public static void inserirTipoLancamento(Scanner scanner) {
        System.out.print("Digite a descrição do tipo de lançamento: ");
        String descricao = scanner.nextLine();
        View.inserirTipoLancamento(descricao);
    }

    public static void listarTiposLancamentos() {
        View.listarTipoLancamento();
    }

    public static void atualizarTipoLancamento(Scanner scanner) {
        System.out.print("Digite o ID do tipo que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a nova descrição do tipo de lançamento: ");
        int descricao = scanner.nextLine();
        View.atualizarTipoLancamento(id, descricao);
    }

    public static void analisarPedidosCartao(Scanner scanner) {
        boolean pedidosExist = View.listarPedidosCartao();
        if (pedidosExist) {
            System.out.print("Digite o ID do pedido que deseja analisar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite 1 para aprovar ou 0 para reprovar: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            if (op == 1) {
                System.out.print("Digite o limite do cartão(se o cartão for de débito apenas digite 0): ");
                Double limite = nextDouble();
                scanner.nextLine();
                System.out.print("Digite a validade(MM/AA): ");
                String validade = scanner.nextLine();
                View.analisarPedidosCartao(id, op, limite, validade);
            } else {
                View.analisarPedidosCartao(id, op, 0, "00/00");
            }
        }
    }

    public static void listarContas() {
        View.listarContas();
    }

    public static void listarLancamentos() {
        View.listarLancamentos();
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Loop principal do programa
            int idConta = menuVisitante(scanner); // Exibe o menu do visitante
            if (idConta == 0) {
                // Menu do admin
                boolean logout = menuAdmin(scanner);
                if (logout) {
                    System.out.println("Logout realizado. Voltando ao menu do visitante.");
                }
            } else {
                // Menu do cliente (a ser implementado)
                System.out.println("*MENU DO CLIENTE*");
            }
        }
        // scanner.close(); // Não é necessário fechar o scanner no loop principal
    }
}
