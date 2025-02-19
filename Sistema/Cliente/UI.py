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
        op = 0

        while op != 3:
            print("1- Criar conta, 2- Entrar no sistema, 3- Fim\n")
            op = int(input("Digite uma opção: "))
            if op == 1:
                UI.criarConta()
            elif op == 2:
                UI.entrarNoSistema()


    @classmethod
    def criarConta(cls):
        cls.inserirCliente()

    @classmethod
    def entrarNoSistema(cls):
        email = input("Digite o seu email: ")
        senha = input("Digite a sua senha: ")
        obj = View.cliente_autenticar(email, senha)
        if obj == None:
            print("Email ou senha inválidos")
        else:
            cls.cliente_id = obj["id"]
            cls.cliente_nome = obj["nome"]
    
    @classmethod
    def main(cls):
        UI.menu_visitante()






    @classmethod
    def inserirCliente():
        nome = input("Digite o seu nome: ")
        email = input("Digite o seu email: ")
        cpf = input("Digite o seu cpf: ")
        senha = input("Digite a sua senha: ")
        telefone = input("Digite o seu telefone: ")
        idade = int(input("Digite a sua idade: "))
        View.inserirCliente(nome, email, cpf, senha, telefone, idade)

UI.main()


