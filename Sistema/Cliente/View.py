from Models.Cliente import Cliente, Clientes
from random import randint

from Models.Cartão import Cartão, Cartões
from Models.Conta import Conta, Contas
from Models.Lançamento import Lançamento, Lançamentos
from Models.pedidoCartão import Pedido, Pedidos
from Models.tipoLançamento import tipoLançamento, tiposLançamentos

class View:


    # COISAS A VER:
    # - CLIENTE PRECISA DE SENHA COMO PARÂMETRO
    # - COMO CLIENTE VAI CRIAR UMA CONTA AO CRIAR UM CLIENTE


    @staticmethod
    def inserirCliente(nome, email, cpf, senha, telefone, idade):
        for c in Clientes.listar():
            if c.getCPF() == cpf:
                raise ValueError("Cliente já existente")
        if nome == "" or idade < 18 or cpf == "" or email == "" or senha == "":
            raise ValueError("Cliente inválido")
        
        cliente = Cliente(0, nome, email, cpf, senha, telefone, idade, False)
        Clientes.inserir(cliente)
        
        
        numero = randint(10000000, 99999999)
        numero = str(numero)

        conta = Conta(0, cliente.getId(), numero, 0)
        Contas.inserir(conta)

    @staticmethod
    def atualizarCliente(id, nome, cpf, telefone, idade):
        for c in Clientes.listar():
            if c.getCPF() == cpf:
                raise ValueError('CPF já existente')
        if nome == "" or cpf == "":
            raise ValueError("Nome ou CPF vazios")
        cliente = Cliente(id, nome, cpf, telefone, idade)
        Clientes.atualizar(cliente)
    

    # PEDIDOS CARTÕES
    @staticmethod
    def inserirPedido(id, idCliente, idConta, tipoCartão):
        for p in Pedidos.listar():
            if p.getId() == id and p.getIdCliente() == idCliente:
                raise ValueError("Pedido já feito!")
        if tipoCartão == "":
            raise ValueError("Tipo do cartão inválido")
        
        Ped = Pedido(id, idCliente, idConta, tipoCartão)
        Pedidos.inserir(Ped)

    @staticmethod
    def listarPedidos(idCliente, idConta):
        for p in Pedidos.listar():
            if p.getIdCliente() == idCliente and p.getIdConta() == idConta:
                return p
            else:
                raise ValueError("Nenhum pedido feito!")

    @staticmethod
    def excluirPedido(id):
        Pedidos.excluir(Pedidos.listar(id))


    # CARTÕES
    @staticmethod
    def listarCartões(idConta):
        for c in Cartões.listar():
            if c.getIdConta() == idConta:
                return c
            else:
                raise ValueError("Você não tem nenhum cartão")



    # LANÇAMENTOS
    @staticmethod
    def inserirLançamento(id, idTipoLançamento, numeroContaOrigem, numeroContaDestino, valor):
        for c in Clientes.listar():
            if c.getNumeroContaDestino() == None:
                raise ValueError('Essa conta não existe!')
        if valor < 0 or valor == "":
            raise ValueError("Valor de lançamento inválido!")
        L = Lançamento(id, idTipoLançamento, numeroContaOrigem, numeroContaDestino, valor)
        Lançamentos.inserir(L)

    @staticmethod
    def listarLançamentos(numeroContaOrigem):
        for L in Lançamentos.listar():
            if L.getNumeroContaOrigem() == numeroContaOrigem:
                return L
            else:
                raise ValueError("Nenhum lançamento feito!")

