from Models.Cliente import Cliente, Clientes
from Models.Conta import Conta
from Models.Cartão import Cartão
from Models.Lançamento import Lançamento
from Models.tipoLançamento import tipoLançamento
from Models.pedidoCartão import Pedido, Pedidos

print("Digite o nome do cliente:")
nome = input()
print("Digite o cpf do cliente: ")
cpf = input()
print("Digite o telefone do cliente: ")
telefone = input()
print("Digite a idade do cliente: ")
idade = int(input())

cliente = Cliente(1, nome, cpf, telefone, idade, False)
Clientes.inserir(cliente)

listaClientes = Clientes.listar()
for client in listaClientes:
    print(client)



