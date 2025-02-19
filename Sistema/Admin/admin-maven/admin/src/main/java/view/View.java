import models.Cliente;
import models.Conta;
import models.Cartao;
import models.Lancamento;
import models.TipoLancamento;
import models.TiposLancamentos;
import models.PedidoCartao;
import models.CRUD;

import java.util.ArrayList;
import java.util.List;

public class View {

    public static void inserirCliente(String nome, String cpf, String telefone, int idade, String numeroConta) {
        Cliente cliente = new Cliente(0, nome, cpf, telefone, idade);
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        clientes.inserir(cliente);
        Conta conta = new Conta(0, cliente.getId(), numero, 0);
        CRUD<Conta> contas = new CRUD<>(Conta.class);
        contas.inserir(conta);
    }

    public static void listarClientes() {
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        List<Cliente> listaObjetos = clientes.listar();
        if (listaObjetos == null) {
            System.out.println("NENHUM CLIENTE CADASTRADO");
        } else {
            for (Cliente c : listaObjetos) {
                System.out.println(c.toString());
            }
        }
    } 

    public static void atualizarCliente(int id, String nome, String cpf, String telefone, int idade) {
        Cliente cliente = new Cliente(id, nome, cpf, telefone, idade);
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
                if (c.getSaldo()) {
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
        if (listaObjetos == null) {
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
        CRUD<TipoLancamento> tipoLancamentos = new CRUD<>(TipoLancamento.class);
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
        if (listaObjetos == null) {
            System.out.println("NENHUM PEDIDO PARA ANALISAR");
            return false;
        } else {
            for (PedidoCartao pc : listaObjetos) {
                System.out.println(pc.toString());
            }
            return true;

        }
    }
    public static void analisarPedidosCartao(int id, int op) {
        CRUD<PedidoCartao> pedidos = new CRUD<>(PedidoCartao.class);
        List<PedidoCartao> listaObjetos = pedidos.listar();
        for (PedidoCartao pc : listaObjetos) {
            if (pc.getId() == id) {
                if (op == 1) { 
                    pc.setAprovacao(true); 
                    // cria o cartão
                    
                }
                else if (op != 0) { 
                    System.out.println("OPÇÃO INVÁLIDA"); 
                    return;
                }
                // exclui o pedido apos aprovação ou reprovação
                listaObjetos.deletar(pc.getId());
                return;
            }
        }
        System.out.println("ID NÃO ENCONTRADO");
    }


    public static void listarContas() {
        CRUD<Conta> contas = new CRUD<>(Conta.class);
        List<Conta> listaObjetos = contas.listar();
        if (listaObjetos == null) {
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
        if (listaObjetos == null) {
            System.out.println("NENHUM LANCAMENTO CADASTRADO");
        } else {
            for (Lancamento l : listaObjetos) {
                System.out.println(l.toString());
            }
        }
    }
}