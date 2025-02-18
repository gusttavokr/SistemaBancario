import models.Cliente;
import models.Conta;
import models.Cartao;
import models.Lancamento;
import models.TipoLancamento;
import models.PedidoCartao;
import models.CRUD;

import java.util.ArrayList;
import java.util.List;

public class View {

    public static void inserirCliente(String nome, String cpf, String telefone, int idade) {
        Cliente cliente = new Cliente(0, nome, cpf, telefone, idade);
        List<Cliente> clientes = new ArrayList<>(Cliente.class);
        clientes.inserir(cliente);
    }

    public static void listarClientes() {
        List<Cliente> clientes = new ArrayList<>(Cliente.class);

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    } 

    public static void atualizarCliente(int id, String nome, String cpf, String telefone, int idade) {
        Cliente cliente = new Cliente(id, nome, cpf, telefone, idade);
        List<Cliente> clientes = new ArrayList<>(Cliente.class);
        boolean idFound = clientes.atualizar(id, cliente);
        if (idFound) {
            System.out.println("CLIENTE ATUALIZADO!");
        } else {
            System.out.println("ID NÃO ENCONTRADO");
        }
    }

    public static void deletarCliente(int id) {
        List<Cliente> clientes = new ArrayList<>(Cliente.class);
        boolean idFound = clientes.deletar(id);
        if (idFound) {
            System.out.println("CLIENTE DELETADO!");
        } else {
            System.out.println("ID NÃO ENCONTRADO");
        }
    }
}