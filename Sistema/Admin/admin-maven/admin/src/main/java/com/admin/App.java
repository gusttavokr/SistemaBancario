package com.admin;

import models.Cliente;
import models.Cartao;
import models.TipoLancamento;
import models.CRUD;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();

        Cliente cliente = new Cliente(0, nome, cpf, telefone, idade);
        CRUD<Cliente> clientes = new CRUD<>(Cliente.class);
        clientes.inserir(cliente);
        List<Cliente> listaClientes = clientes.listar();
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
        scanner.close();
    }
}
