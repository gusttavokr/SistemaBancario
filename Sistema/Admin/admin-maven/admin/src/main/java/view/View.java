package view;

import models.Cliente;
import models.Conta;
import models.Cartao;
import models.Lancamento;
import models.TipoLancamento;
import models.PedidoCartao;
import models.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View {

    public static void criarAdmin() {
        CRUD<Cliente> clientes = new CRUD<Cliente>(Cliente.class);
        List<Cliente> listaObjetos = clientes.listar();
        if (listaObjetos.isEmpty()) {
            Cliente admin = new Cliente(0, "Admin", "Admin", "Admin", 18, "Admin", "Admin");
            admin.setAdmin(true);
            clientes.inserir(admin);
        }
    }

    public static int entrarNoSistema(String email, String senha) {
        CRUD<Cliente> clientes = new CRUD<Cliente>(Cliente.class);
        List<Cliente> listaClientes = clientes.listar();
        CRUD<Conta> contas = new CRUD<Conta>(Conta.class);
        List<Conta> listaContas = contas.listar();
        for (Cliente clt : listaClientes) {
            if (clt.getEmail().equals(email) && clt.getSenha().equals(senha)) {
                System.out.println(String.format("Seja bem-vindo, %s!", clt.getNome()));
                if (clt.getId() == 0) {
                    return 0; // o admin não tem conta, então retorna o id do cliente se o login for feito pelo admin
                }
                for (Conta cnt : listaContas) {
                    if (clt.getId() == cnt.getIdCliente()) {
                        return cnt.getId(); // id da conta
                    }
                }
            }
        }
        return -1;
    }

    public static void inserirCliente(String nome, String cpf, String telefone, int idade, String email, String senha) {
        Cliente cliente = new Cliente(0, nome, cpf, telefone, idade, email, senha);
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        clientes.inserir(cliente);
        // gerar numero aleatorio de 8 digitos e converter pra str -> 10000000, 99999999
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            numero.append(random.nextInt(10));
        }
        Conta conta = new Conta(0, cliente.getId(), numero.toString(), 0);
        CRUD<Conta> contas = new CRUD<>(Conta.class);
        contas.inserir(conta);
    }

    public static void listarClientes() {
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        List<Cliente> listaObjetos = clientes.listar();
        if (listaObjetos.isEmpty()) {
            System.out.println("NENHUM CLIENTE CADASTRADO");
        } else {
            for (Cliente c : listaObjetos) {
                System.out.println(c.toString());
            }
        }
    } 

    public static void atualizarCliente(int id, String nome, String cpf, String telefone, int idade, String email, String senha) {
        Cliente cliente = new Cliente(id, nome, cpf, telefone, idade, email, senha);
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        boolean idFound = clientes.atualizar(id, cliente);
        if (idFound) {
            System.out.println("CLIENTE ATUALIZADO!");
        } else {
            System.out.println("ID NÃO ENCONTRADO");
        }
    }

    public static void deletarCliente(int id) {
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        CRUD<Conta> contas = new CRUD<>(Conta.class);
        List<Conta> listaContas = contas.listar();
        int idConta = 0;
        for (Conta c : listaContas) {
            if (c.getIdCliente() == id) {
                if (c.getSaldo() > 0) {
                    System.out.println("CLIENTE POSSUI CONTA COM SALDO POSITIVO, EXCLUSÃO NEGADA");
                    return;
                }
                idConta = c.getId();
                break;
            }
        }
        boolean idClienteFound = clientes.deletar(id);
        boolean idContaFound = contas.deletar(idConta); 
        if (idClienteFound && idContaFound) {
            System.out.println("CLIENTE DELETADO!");
        } else {
            System.out.println("ID NÃO ENCONTRADO");
        }
    }

    public static void inserirTipoLancamento(String descricao) {
        TipoLancamento tipoLancamento = new TipoLancamento(0, descricao);
        CRUD<TipoLancamento> tiposLancamentos = new CRUD<>(TipoLancamento.class);
        tiposLancamentos.inserir(tipoLancamento);
    }

    public static void listarTiposLancamentos() {
        CRUD<TipoLancamento> tiposLancamentos = new CRUD<>(TipoLancamento.class);
        List<TipoLancamento> listaObjetos = tiposLancamentos.listar();
        if (listaObjetos.isEmpty()) {
            System.out.println("NENHUM TIPO DE LANÇAMENTO CADASTRADO");
        } else {
            for (TipoLancamento tp : listaObjetos) {
                System.out.println(tp.toString());
            }
        }
    }

    public static void atualizarTipoLancamento(int id, String descricao) {
        TipoLancamento tipoLancamento = new TipoLancamento(id, descricao);
        CRUD<TipoLancamento> tiposLancamentos = new CRUD<>(TipoLancamento.class);
        boolean idFound = tiposLancamentos.atualizar(id, tipoLancamento);
        if (idFound) {
            System.out.println("DESCRIÇÃO ATUALIZADA!");
        } else {
            System.out.println("ID NÃO ENCONTRADO!");
        }
    }

    public static void deletarTipoLancamento(int id) {
        CRUD<TipoLancamento> tiposLancamentos = new CRUD<>(TipoLancamento.class);
        boolean idFound = tiposLancamentos.deletar(id);
        if (idFound) {
            System.out.println("TIPO DE LANÇAMENTO DELETADO!");
        } else {
            System.out.println("ID NÃO ENCONTRADO!");
        }
    }

    public static boolean listarPedidosCartao() {
        CRUD<PedidoCartao> pedidos = new CRUD<>(PedidoCartao.class);
        List<PedidoCartao> listaObjetos = pedidos.listar();
        if (listaObjetos.isEmpty()) {
            System.out.println("NENHUM PEDIDO PARA ANALISAR");
            return false;
        } else {
            for (PedidoCartao pc : listaObjetos) {
                System.out.println(pc.toString());
            }
            return true;

        }
    }

    public static String gerarNumCartao() {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            numeroCartao.append(random.nextInt(10));
        }

        return numeroCartao.toString();
    }

    public static String gerarSenhaCartao() {
        Random random = new Random();
        StringBuilder senhaCartao = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            senhaCartao.append(random.nextInt(10));
        }

        return senhaCartao.toString();
    }

    public static void criarCartao(PedidoCartao pedido, Double limite, String validade) {
        CRUD<Cartao> cartoes = new CRUD<>(Cartao.class);
        if (pedido.getTipoCartao().equals("DEBITO")) {
            CRUD<Conta> contas = new CRUD<>(Conta.class);
            List<Conta> listaObjetos = contas.listar();
            for (Conta c : listaObjetos) {
                if (c.getId() == pedido.getIdConta()) {
                    limite = c.getSaldo(); // se o cartão solicitado for de debito, o limite vai ser o saldo da conta
                    break;
                }
            }
            String numero = gerarNumCartao();
            String senha = gerarSenhaCartao();
            Cartao cartao = new Cartao(0, pedido.getIdConta(), true, false, limite, validade, numero, senha);
            cartoes.inserir(cartao);
            System.out.println("CARTÃO CRIADO E ASSOCIADO À CONTA DO CLIENTE");
        } else if (pedido.getTipoCartao().equals("CREDITO")) {
            String numero = gerarNumCartao();
            String senha = gerarSenhaCartao();
            Cartao cartao = new Cartao(0, pedido.getIdConta(), false, true, limite, validade, numero, senha);
            cartoes.inserir(cartao);
            System.out.println("CARTÃO CRIADO E ASSOCIADO À CONTA DO CLIENTE");           
        }
    }

    public static void analisarPedidosCartao(int id, int op, Double limiteCartao, String validadeCartao) {
        CRUD<PedidoCartao> pedidos = new CRUD<>(PedidoCartao.class);
        List<PedidoCartao> listaObjetos = pedidos.listar();
        for (PedidoCartao pc : listaObjetos) {
            if (pc.getId() == id) {
                if (op == 1) { 
                    pc.setAprovacao(true); 
                    // cria o cartão
                    criarCartao(pc, limiteCartao, validadeCartao);
                }
                else if (op != 0) { 
                    System.out.println("OPÇÃO INVÁLIDA"); 
                    return;
                }
                // exclui o pedido apos aprovação ou reprovação
                pedidos.deletar(pc.getId());
                System.out.println("PEDIDO DELETADO");
                return;
            }
        }
        System.out.println("ID NÃO ENCONTRADO");
    }


    public static void listarContas() {
        CRUD<Conta> contas = new CRUD<>(Conta.class);
        List<Conta> listaObjetos = contas.listar();
        if (listaObjetos.isEmpty()) {
            System.out.println("NENHUMA CONTA CADASTRADA");
        } else {
            for (Conta c : listaObjetos) {
                System.out.println(c.toString());
            }
        }
    }

    public static void listarLancamentos() {
        CRUD<Lancamento> lancamentos = new CRUD<>(Lancamento.class);
        List<Lancamento> listaObjetos = lancamentos.listar();
        if (listaObjetos.isEmpty()) {
            System.out.println("NENHUM LANCAMENTO CADASTRADO");
        } else {
            for (Lancamento l : listaObjetos) {
                System.out.println(l.toString());
            }
        }
    }
}


/* 
O QUE EU FIZ (19/02 - 15:44):

ATUALIZEI CLIENTE(EMAIL E SENHA)
CRIEI UM GERADOR DE NUMERO DE CONTA ALEATORIO 
CRIEI FUNÇÃO PARA CRIAR O CARTÃO EM CASO DE APROVAÇÃO DO ADM E ATUALIZEI A UI PARA PEGAR O LIMITE E A VALIDADE DO CARTÃO
CRIEI FUNÇÕES PARA GERAR NUMEROS DE CARTÃO E SENHA DE CARTÃO ALEATÓRIOS
ADICIONEI O CARTÃO CRIADO NA LISTA DE CARTÕES ASSOCIADA À SUPERCLASSE CRUD

FALTA FAZER:

LISTAR CARTÕES (UI E VIEW)
ATUALIZAR CARTÃO (UI E VIEW)
DELETAR CARTÃO (UI E VIEW)
PERSISTẼNCIA CONTAS (FAZER CLASSE A ATUALIZAR MÉTODO DA SUPERCLASSE)
PERSISTÊNCIA LANÇAMENTOS (FAZER CLASSE A ATUALIZAR MÉTODO DA SUPERCLASSE)
PERSISTÊNCIA PEDIDOS CARTÕES (FAZER CLASSE A ATUALIZAR MÉTODO DA SUPERCLASSE)
LOGIN ADM

*/