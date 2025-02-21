import json
from Models.Modelo import Modelo

class Cliente:
    def __init__(self, id, nome, cpf, telefone, idade, email, senha, admin = False):
        self.__id = id
        self.__nome = nome
        self.__email = email
        self.__cpf = cpf
        self.__senha = senha
        self.__telefone = telefone
        self.__idade = idade
        self.__admin = admin

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')

    def getAdmin(self):
        return self.__admin
    def setAdmin(self, admin):
        self.__admin = admin
    
    def getNome(self):
        return self.__nome
    def setNome(self, nome):
        if len(nome) > 0:
            self.__nome = nome
        else:
            raise ValueError('Nome inválido')

    def getEmail(self):
        return self.__email
    def setEmail(self, email):
        if email != "":
            self.__email = email
        else:
            raise ValueError("Email inválido")

    def getSenha(self):
        return self.__senha
    def setSenha(self, senha):
        if senha != "":
            self.__senha = senha
        else:
            raise ValueError("Senha inválida")
    
    def getCPF(self):
        return self.__cpf
    def setCPF(self, cpf):
        if len(cpf) > 0:
            self.__cpf = cpf
        else:
            raise ValueError('CPF inválido')

    def getTelefone(self):
        return self.__telefone
    def setTelefone(self, telefone):
        if len(telefone) > 0:
            self.__telefone = telefone
        else:
            raise ValueError('Telefone inválido')
    
    def getIdade(self):
        return self.__idade
    def setIdade(self, idade):
        if idade >= 18:
            self.__idade = idade
        else:
            raise ValueError("Idade insuficiente")
    
    def __str__(self):
        return f"Id: {self.getId()} - Nome: {self.getNome()} - Cpf: {self.getCPF()} - Telefone: {self.getTelefone()} - Idade: {self.getIdade()}"

    def to_json(self):

        dic = {}
        dic["id"] = self.getId()
        dic["nome"] = self.getNome()
        dic["cpf"] = self.getCPF()
        dic["telefone"] = self.getTelefone()
        dic["idade"] = self.getIdade()
        dic["email"] = self.getEmail()
        dic["senha"] = self.getSenha()
        dic["admin"] = self.getAdmin()
        return dic

class Clientes(Modelo):
    @classmethod
    def salvar(cls):
        with open("../Json/clientes.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=lambda o: o.to_json(), indent=4)
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open ("../Json/clientes.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    u = Cliente(
                        obj["id"],
                        obj["nome"],
                        obj["cpf"],
                        obj["telefone"],
                        obj["idade"],
                        obj["email"],
                        obj["senha"],
                        obj["admin"]
                    )
                    cls.objetos.append(u)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass

