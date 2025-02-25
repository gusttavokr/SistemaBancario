package com.admin;

import models.Cliente;
import models.Conta;
import models.Cartao;
import models.Lancamento;
import models.TipoLancamento;
import models.PedidoCartao;
import view.View;

import java.util.List;
import java.util.Scanner;



public class App {

    public static int menuVisitante(Scanner scanner) {
        while(true) {
            System.out.println("=========BEM-VINDO AO SISTEMA BANCÁRIO=========");
            System.out.println("1-ENTRAR NO SISTEMA\n2-REALIZAR CADASTRO\n3-SAIR");
            System.out.print("DIGITE A OPÇÃO DESEJADA: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch(op) {
                case 1:
                    System.out.print("DIGITE SEU E-MAIL: ");
                    String email = scanner.nextLine();
                    System.out.print("DIGITE SUA SENHA: ");
                    String senha = scanner.nextLine();
                    int idConta = View.entrarNoSistema(email, senha);
                    if (idConta == -1) { System.out.println("E-MAIL OU SENHA INVÁLIDOS"); }
                    else if (idConta == 0) { return idConta; }
                    else { System.out.println("ENTRADA NEGADA, APENAS O ADMIN TEM PERMISSÃO DE ACESSO"); }
                    break;
                case 2:
                    inserirCliente(scanner);
                    System.out.println("CLIENTE CADASTRADO COM SUCESSO");
                    break;
                case 3:
                    System.out.println("FIM DE EXECUÇÃO");
                    return -1;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        }
    }

    public static boolean menuAdmin(Scanner scanner) {
        while (true) {
            System.out.println("=========MENU DO ADMIN=========");
            System.out.println("1-INSERIR CLIENTE\n2-LISTAR CLIENTES\n3-ATUALIZAR CLIENTE\n4-DELETAR CLIENTE\n\n5-INSERIR TIPO DE LANÇAMENTO\n6-LISTAR TIPOS DE LANÇAMENTOS\n7-ATUALIZAR TIPO DE LANÇAMENTO\n8-DELETAR TIPO DE LANÇAMENTO\n\n9-ANALISAR PEDIDO DE CARTÃO\n10-LISTAR CARTÕES\n11-ATUALIZAR CARTÃO\n12-DELETAR CARTÃO\n\n13-LISTAR CONTAS\n14-LISTAR LANÇAMENTOS\n\n15-LOGOUT");
            System.out.print("DIGITE A OPÇÃO DESEJADA: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    inserirCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
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
                    listarTiposLancamentos();
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
                    break;
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
        System.out.print("DIGITE O NOME DO CLIENTE: ");
        String nome = scanner.nextLine();
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        System.out.print("DIGITE O TELEFONE DO CLIENTE: ");
        String telefone = scanner.nextLine();
        System.out.print("DIGITE A IDADE DO CLIENTE: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DIGITE O E-MAIL DO CLIENTE: ");
        String email = scanner.nextLine();
        System.out.print("DIGITE A SENHA DO CLIENTE: ");
        String senha = scanner.nextLine();
        View.inserirCliente(nome, cpf, telefone, idade, email, senha);
    }

    public static void listarClientes() {
        List<Cliente> clientes= View.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("NENHUM CLIENTE CADASTRADO");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.toString());
            }
        }
    }

    public static void atualizarCliente(Scanner scanner) {
        System.out.print("Digite O ID DO CLIENTE DESEJADO: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DIGITE O NOVO TELEFONE DO CLIENTE: ");
        String telefone = scanner.nextLine();
        System.out.print("DIGITE A NOVA IDADE DO CLIENTE: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DIGITE O NOVO E-MAIL DO CLIENTE: ");
        String email = scanner.nextLine();
        System.out.print("DIGITE A NOVA SENHA DO CLIENTE: ");
        String senha = scanner.nextLine();
        View.atualizarCliente(id, telefone, idade, email, senha); }

    public static void deletarCliente(Scanner scanner) {
        System.out.print("DIGITE O ID DO CLIENTE DESEJADO: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        View.deletarCliente(id);
    }

    public static void inserirTipoLancamento(Scanner scanner) {
        System.out.print("DIGITE A NOVA DESCRIÇÃO: ");
        String descricao = scanner.nextLine();
        View.inserirTipoLancamento(descricao);
    }

    public static void listarTiposLancamentos() {
        List<TipoLancamento> tiposLancamentos = View.listarTiposLancamentos();
        if (tiposLancamentos.isEmpty()) {
            System.out.println("NENHUM TIPO DE LANÇAMENTO CADASTRADO");
        } else {
            for (TipoLancamento tl : tiposLancamentos) {
                System.out.println(tl.toString());
            }
        }
    }

    public static void atualizarTipoLancamento(Scanner scanner) {
        System.out.print("DIGITE O ID DO TIPO QUE DESEJA ATUALIZAR: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DIGITE A NOVA DESCRIÇÃO: ");
        String descricao = scanner.nextLine();
        View.atualizarTipoLancamento(id, descricao);
    }

    public static void deletarTipoLancamento(Scanner scanner) {
        System.out.print("Digite o ID do tipo de lançamento desejado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        View.deletarTipoLancamento(id);
    }

    public static void analisarPedidosCartao(Scanner scanner) {
        List<PedidoCartao> pedidos = View.listarPedidosCartao();
        if (!(pedidos.isEmpty())) {
            for (PedidoCartao pc : pedidos) {
                System.out.println(pc.toString());
            }
            System.out.print("DIGITE O ID DO PEDIDO QUE DESEJA ANALISAR: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("DIGITE 1 PARA APROVAR OU 0 PARA REPROVAR: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            if (op == 1) {
                System.out.print("DIGITE O LIMITE DO CARTÃO(SE O CARTÃO FOR DE DÉBITO APENAS DIGITE 0): ");
                Double limite = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("DIGITE A VALIDADE(MM/AA): ");
                String validade = scanner.nextLine();
                View.analisarPedidosCartao(id, op, limite, validade);
            } else {
                View.analisarPedidosCartao(id, op, 0.0, "00/00");
            }
        } else {
            System.out.println("NENHUM PEDIDO DE CARTÃO CADASTRADO");
        }
    }

    public static void listarCartoes() {
        List<Cartao> cartoes = View.listarCartoes();
        if (cartoes.isEmpty()) {
            System.out.println("NENHUM CARTÃO CADASTRADO");
        } else {
            for (Cartao c : cartoes) {
                System.out.println(c.toString());
            }
        }
    }

    public static void atualizarCartao(Scanner scanner) {
        System.out.print("DIGITE O ID DO CARTÃO: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DIGITE O NOVO LIMITE DO CARTÃO: ");
        Double limite = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("DIGITE A NOVA VALIDADE DO CARTÃO(MM/AA): ");
        String validade = scanner.nextLine();
        View.atualizarCartao(id, limite, validade);
    }

    public static void deletarCartao(Scanner scanner) {
        System.out.print("DIGITE O ID DO CARTÃO: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        View.deletarCartao(id);
    }

    public static void listarContas() {
        List<Conta> contas = View.listarContas();
        if (contas.isEmpty()) {
            System.out.println("NENHUMA CONTA CADASTRADA");
        } else {
            for (Conta c : contas) {
                System.out.println(c.toString());
            }
        }
    }

    public static void listarLancamentos() {
        List<Lancamento> lancamentos = View.listarLancamentos();
        if (lancamentos.isEmpty()) {
            System.out.println("NENHUM LANÇAMENTO CADASTRADO");
        } else {
            for (Lancamento l : lancamentos) {
                System.out.println(l.toString());
            }
        }
    }

    public static void main(String[] args) {
        View.criarAdmin();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int idConta = menuVisitante(scanner);
            if (idConta == 0) {
                boolean logout = menuAdmin(scanner);
                if (logout) { System.out.println("LOGOUT REALIZADO"); } 
            } else if (idConta == -1) { break; }
        }
        scanner.close();
    }   
}
