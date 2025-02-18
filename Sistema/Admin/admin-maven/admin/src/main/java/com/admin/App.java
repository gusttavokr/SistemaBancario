package com.admin;

import view.View;
import java.util.Scanner;



public class App {
    public static int menu(Scanner scanner) {
        System.out.println("1-Inserir Cliente\n2-Listar Clientes\n3-Atualizar Cliente\n4-Deletar Cliente\n5-Inserir Tipo de Lançamento\n6-Listar Tipos de Lançamentos\n7-Sair");
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
        View.inserirCliente(nome, cpf, telefone, idade);
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

    public static void listarTipoLancamento() {
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

                default:
                    System.out.println("FIM DE EXECUÇÃO");
                    run = false;
                    break;
            }
        }


        scanner.close();
    }
}
