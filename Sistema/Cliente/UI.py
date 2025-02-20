from Models.Cliente import Cliente, Clientes
from Models.Conta import Conta
from Models.Cartão import Cartão
from Models.Lançamento import Lançamento
from Models.tipoLançamento import tipoLançamento
from Models.pedidoCartão import Pedido, Pedidos

from View import View

class UI:

    cliente_id = 0
    cliente_nome = ""

    #@staticmethod
    #def main():

    @staticmethod
    def menu_visitante():
        print("1- Criar conta, 2- Entrar no sistema, 99- Fim\n")
        op = int(input("Digite uma opção: "))
        if op == 1:
            UI.criarConta()
        if op == 2:
            UI.entrarNoSistema()
        return op


    @classmethod
    def criarConta(cls):
        cls.inserirCliente()

    @classmethod
    def entrarNoSistema(cls):
        email = input("Digite o seu email: ")
        senha = input("Digite a sua senha: ")
        obj = View.cliente_autenticar(email, senha)
        if obj == None:
            raise ValueError("Email ou senha inválidos")
        else:
            cls.cliente_id = obj["id"]
            cls.cliente_nome = obj["nome"]

    @classmethod
    def menuCliente(cls):
        print("Bem-vindo ao sistema bancário! \n")
        print("1- Atualizar dados, 2- Pedir Cartão(em testes), 3- Listar Pedidos, 4- Excluir pedido, 5- Listar cartões\n")
        print("6- Transação, 7- Listar operações, 8- Excluir conta, 99- Sair\n")
        op= int(input("Selecione uma das opções:"))

        if op == 1:
            UI.atualizar()
        if op == 2:
            UI.pedirCartao(cls.cliente_id)
        if op == 3:
            UI.listarPedidos()
            #case 1:
            #    UI.atualizar()
            #case 2:
            #    UI.pedirCartao()
            #case 3:
            #    UI.listarPedidos()
            #case 4:
            #    UI.excluirPedido()
            #case 5:
            #    UI.listarCartao()
            #case 6:
            #    UI.lancamento()
            #case 7: 
            #    UI.listarLancamento()
        return op
        
    @classmethod
    def main(cls):
        op = 0
        while op != 99:
            if cls.cliente_id == 0:
                op = UI.menu_visitante()
            else:
                op = UI.menuCliente()

    @classmethod
    def inserirCliente(cls):
        nome = input("Digite o seu nome: ")
        email = input("Digite o seu email: ")
        cpf = input("Digite o seu cpf: ")
        senha = input("Digite a sua senha: ")
        telefone = input("Digite o seu telefone: ")
        idade = int(input("Digite a sua idade: "))
        View.inserirCliente(nome, email, cpf, senha, telefone, idade)

    @staticmethod
    def atualizar():
        nome = input("Digite o seu nome: ")
        email = input("Digite o seu email: ")
        cpf = input("Digite o seu cpf: ")
        senha = input("Digite a sua senha: ")
        telefone = input("Digite o seu telefone: ")
        idade = int(input("Digite a sua idade: "))
        View.atualizarCliente(nome, email, cpf, senha, telefone, idade)

    @staticmethod
    def pedirCartao(cliente_id):
        print("Escolha: 1- Débito ou 2- Crédito\n")
        op = int(input("Digite: "))
        d = "DEBITO"
        c = "CREDITO"
        if op == 1:
            View.inserirPedido(cliente_id, d)
        else:
            View.inserirPedido(cliente_id, c)

    @classmethod
    def listarPedidos(cls):
        pedidos = View.listarPedidos()
        if len(pedidos) == 0:
            print("Nenhum pedido feito")
        else:
            for pedido in pedidos:
                print(pedido)

UI.main()


