package com.admin;

import models.Cliente;
import models.Cartao;
import models.TipoLancamento;
import models.TiposLancamentos;
import models.CRUD;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class App 
{   
    public static int menu(Scanner scanner) {
        System.out.println("1-Inserir Cliente\n2-Listar Clientes\n3-Inserir Cartão\n4-Listar Cartões\n5-Inserir Tipo de Lançamento\n6-Listar Tipos de Lançamentos\n7-Sair");
        System.out.print("Digite a opção desejada: ");
        int op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }

    public static void inserirCliente(Scanner scanner, CRUD<Cliente> clientes) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = Integer.parseInt(scanner.nextLine()); // Usa nextLine() para ler e converte para int
        Cliente cliente = new Cliente(0, nome, cpf, telefone, idade);
        clientes.inserir(cliente);
    }
    
    public static void listarClientes(CRUD<Cliente> clientes) {
        List<Cliente> listaClientes = clientes.listar();
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
    }

    public static void inserirCartao(Scanner scanner, CRUD<Cartao> cartoes) {
        System.out.print("Digite o tipo do cartão: ");
        String tipo = scanner.nextLine();
        Cartao cartao = new Cartao(0, tipo);
        cartoes.inserir(cartao);
    }

    public static void listarCartoes(CRUD<Cartao> cartoes) {
        List<Cartao> listaCartoes = cartoes.listar();
        for (Cartao c : listaCartoes) {
            System.out.println(c.toString());
        }
    }

    public static void inserirTipoLancamento(Scanner scanner, CRUD<TipoLancamento> tiposLancamentos) {
        System.out.print("Digite a descrição do tipo de lançamento: ");
        String descricao = scanner.nextLine();
        TipoLancamento tipoLancamento = new TipoLancamento(0, descricao);
        tiposLancamentos.inserir(tipoLancamento);
    }

    public static void listarTiposLancamentos(CRUD<TipoLancamento> tiposLancamentos) {
        List<TipoLancamento> listaTiposLancamentos = tiposLancamentos.listar();
        for (TipoLancamento tp : listaTiposLancamentos) {
            System.out.println(tp.toString());
        }
    }

    public static void main( String[] args )
    {
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        CRUD<Cartao> cartoes = new CRUD<>(Cartao.class);
        CRUD<TipoLancamento> tiposLancamentos = new CRUD<>(TipoLancamento.class);
        Scanner scanner = new Scanner(System.in);
        boolean run = true;   
        while (run) {
        int op = menu(scanner);

        switch (op) {
            case 1:
                inserirCliente(scanner, clientes);
                break;
            case 2:
                listarClientes(clientes);
                break;
            case 3:
                inserirCartao(scanner, cartoes);
                break;
            case 4:
                listarCartoes(cartoes);
                break;
            case 5:
                inserirTipoLancamento(scanner, tiposLancamentos);
                break;
            case 6:
                listarTiposLancamentos(tiposLancamentos);
                break;
            case 7:
                System.out.print("FIM DE EXECUÇÃO");
                run = false;
                break;
            default:
                System.out.println("Opção inválida.");
                break;
            }
        }


        scanner.close();
    }
}
