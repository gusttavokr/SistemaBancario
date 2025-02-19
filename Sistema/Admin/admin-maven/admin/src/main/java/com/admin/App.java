package com.admin;

import view.View;
import java.util.Scanner;



public class App {
    public static int menu(Scanner scanner) {
        System.out.println("1-Inserir Cliente\n2-Listar Clientes\n3-Atualizar Cliente\n4-Deletar Cliente\n5-Inserir Tipo de Lançamento\n6-Listar Tipos de Lançamentos\n7-Atualizar Tipo de Lançamento\n8-Deletar Tipo de Lançamento\n9-Analisar Pedido de Cartão\n10-Listar Cartões\n11-Atualizar Cartão\n12-Deletar Cartão\n13-Listar Contas\n14-Listar Lançamentos");
        System.out.print("Digite a opção desejada: ");
        int op = scanner.nextInt();
        scanner.nextLine();
        return op;
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
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        View.inserirCliente(nome, cpf, telefone, idade, numeroConta);
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
        View.atualizarCliente(id, nome, cpf, telefone, idade); }

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
            View.analisarPedidosCartao(id, op);
        }
    }

    public static void listarContas() {
        View.listarContas();
    }

    public static void listarLancamentos() {
        View.listarLancamentos();
    }
    

    public static void main(String[] args) {
        
        System.out.println("BEM-VINDO, ADMIN!\n");
        Scanner scanner = new Scanner(System.in);
        boolean run = true;   
        while (run) {
            switch (menu(scanner)) {
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
                    System.out.println("FIM DE DE EXECUÇÃO");
                    run = false;
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        }


        scanner.close();
    }
}
