from Models.Cliente import Cliente, Clientes
from random import randint

from Models.Cartão import Cartão, Cartões
from Models.Conta import Conta, Contas
from Models.Lançamento import Lançamento, Lançamentos
from Models.pedidoCartão import Pedido, Pedidos
from Models.tipoLançamento import tipoLancamento, tiposLancamentos

class View:

    # COISAS A VER:
    # - CLIENTE PRECISA DE SENHA COMO PARÂMETRO
    # - COMO CLIENTE VAI CRIAR UMA CONTA AO CRIAR UM CLIENTE
    
    @staticmethod
    def cliente_autenticar(email, senha):
        for c in Clientes.listar():
            if c.getEmail() == email and c.getSenha() == senha:
                return { "id" : c.getId(), "nome" : c.getNome() }
        return None

    @staticmethod
    def excluirConta(idcliente):
        for c in Contas.listar():
            if c.getId() == idcliente:
                if c.getSaldo() > 0:
                    raise ValueError('Saldo disponivel, impossivel excluir conta!')
                else:
                    Contas.excluir(idcliente)
        
    @staticmethod
    def inserirCliente(nome, email, cpf, senha, telefone, idade):
        for c in Clientes.listar():
            if c.getCPF() == cpf:
                raise ValueError("Cliente já existente")
        if nome == "" or idade < 18 or cpf == "" or email == "" or senha == "":
            raise ValueError("Cliente inválido")
        
        cliente = Cliente(0, nome, cpf, telefone, idade, email, senha, False)
        Clientes.inserir(cliente)
        
        
        numero = randint(10000000, 99999999)
        numero = str(numero)

        conta = Conta(0, cliente.getId(), numero, 0)
        Contas.inserir(conta)

    @staticmethod
    def listarClientes(cliente_id):
        for c in Contas.listar():
            if c.getId() != cliente_id:
                print(c.getNumero())

    @staticmethod
    def verDados(cliente_id):
        for c in Clientes.listar():
            if c.getId() == cliente_id:
                print(c)

    @staticmethod
    def atualizarCliente(clienteid, nome, email, cpf, senha, telefone, idade):
        for c in Clientes.listar():
            if c.getCPF() == cpf:
                raise ValueError('CPF já existente')
        if nome == "" or cpf == "":
            raise ValueError("Nome ou CPF vazios")
        cliente = Cliente(clienteid, nome, cpf, telefone, idade, email, senha, False)
        Clientes.atualizar(cliente)
    

    # PEDIDOS CARTÕES
    @staticmethod
    def inserirPedido(cliente_id, tipoCartão):
        x = None
        #print(Contas.listar())
        for i in Contas.listar():
            if i.getIdCliente() == cliente_id:
                x = i.getId()
        if x == None:
            raise ValueError("BUG")
        
        pedido = Pedido(0, cliente_id, x, tipoCartão)
        Pedidos.inserir(pedido)



    @staticmethod
    def listarPedidos(cliente_id):
        for p in Pedidos.listar():
            if p.getIdCliente() == cliente_id:
                print(p)

    @staticmethod
    def excluirPedido(id):
        Pedidos.excluir(id)


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
    def inserirLançamento(cliente_id, idTipoLançamento, numeroContaOrigem, numeroContaDestino, valor):
        for i in Contas.listar():
            if i.getNumero() == numeroContaDestino:
                conta = Conta(i.getId(), i.getIdCliente(), i.getNumero(), (i.getSaldo()+valor))
                Contas.atualizar(conta)

        for i in Contas.listar():
            if i.getId() == cliente_id:
                conta = Conta(i.getId(), i.getIdCliente(), i.getNumero(), (i.getSaldo()-valor))
                Contas.atualizar(conta)
        
        L = Lançamento(0, idTipoLançamento, numeroContaOrigem, numeroContaDestino, valor)
        Lançamentos.inserir(L)




    @staticmethod
    def listarTipos():
        x = tiposLancamentos.listar()
        if x == None:
            print("Nenhum tipo disponível")
        else:
            return x
            

    @staticmethod
    def listarLançamentos(x):
        Lançamentos.listar()
        # for L in Lançamentos.listar():
        #     if L.getNumeroContaOrigem() == x:
        #         print(L)

    @staticmethod
    def atualizarSaldo(id, x):
        for i in Contas.listar():
            if i.getId() == id:
                conta = Conta(i.getId(), i.getIdCliente(), i.getNumero(), (i.getSaldo()+x))
                Contas.atualizar(conta)

    # @staticmethod
    # def transacao()
