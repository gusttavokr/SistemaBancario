# from Models.Cliente import Cliente, Clientes
# from Models.Conta import Conta
# from Models.Cartão import Cartão
# from Models.Lançamento import Lançamento
# from Models.tipoLançamento import tipoLançamento
# from Models.pedidoCartão import Pedido, Pedidos

from View import View

class UI:

    cliente_id = 0
    cliente_nome = ""

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
        print("\n==============================")
        print("\nBem-vindo ao sistema bancário! \n")
        print("1- Atualizar dados, 2- Ver meus dados 3- Pedir Cartão, 4- Listar Pedidos, 5- Excluir pedido, 6- Listar cartões(em testes)\n")
        print("7- Transação(em testes), 8- Listar transações(em testes), 9- Depositar, 99- Sair\n")
        op= int(input("Selecione uma das opções: "))

        if op == 1:
            UI.atualizar()
        if op == 2:
            UI.verDados(cls.cliente_id)
        if op == 3:
            UI.pedirCartao(cls.cliente_id)
        if op == 4:
            UI.listarPedidos(cls.cliente_id)
        if op == 5:
            UI.excluirPedido(cls.cliente_id)
        if op == 6:
            UI.listarCartões(cls.cliente_id)
        if op == 7:
            UI.transacao(cls.cliente_id)
        if op == 8:
            print("Opção não disponível!")
        if op == 9:
            UI.depositar(cls.cliente_id)
        if op >=10:
            print("Opção não disponível")
        
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
    
    @classmethod
    def verDados(cls, cliente_id):
        View.verDados(cliente_id)

    @staticmethod
    def pedirCartao(cliente_id):
        print("Escolha: 1- Débito ou 2- Crédito\n")
        op = int(input("Digite: "))
        d = "DEBITO"
        c = "CREDITO"
        if op == 1:
            View.inserirPedido(cliente_id, d)
            print("\nPedido feito com sucesso!")
        else:
            View.inserirPedido(cliente_id, c)
            print("\nPedido feito com sucesso!")

    @classmethod
    def listarPedidos(cls, cliente_id):
        View.listarPedidos(cliente_id)
        

    @classmethod
    def excluirPedido(cls, cliente_id):
        View.listarPedidos(cliente_id)
        x = int(input("Selecione o id do pedido que você deseja excluir: "))
        View.excluirPedido(x)
        print("\nPedido excluído com sucesso!")

    @classmethod
    def listarCartões(cls, cliente_id):
        cartões = View.listarCartões(cliente_id)
        if cartões == None:
            print("Nenhum cartão disponível!")
        else:
            print(cartões)

    @classmethod
    def transacao(cls, cliente_id):
        #View.listarClientes(cliente_id)
        destino = int(input("Digite o número da conta destino para a transação: "))
        tipos = View.listarTipos()
        print(tipos)
        tipo = input("Insira o tipo de transação desejada: ")

    @classmethod
    def excluirConta(cls, cliente_id):
        View.excluirConta(cliente_id)
        print("Conta excluída com sucesso!")

    @classmethod
    def depositar(cls, cliente_id):
        x = int(input("Digite o valor que você deseja depositar: "))
        View.atualizarSaldo(cliente_id, x)
        print("Depósito feito com sucesso!")
        
UI.main()


