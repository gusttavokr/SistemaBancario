import json
from Models.Modelo import Modelo

class Cliente:
    def __init__(self, id, nome, cpf, telefone, idade, admin):
        self.__id = id
        self.__nome = nome
        self.__cpf = cpf
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
        self.__nome = nome
    
    def getCPF(self):
        return self.__cpf
    def setCPF(self, cpf):
        self.__cpf = cpf

    def getTelefone(self):
        return self.__telefone
    def setTelefone(self, telefone):
        self.__telefone = telefone
    
    def getIdade(self):
        return self.__idade
    def setIdade(self, idade):
        if idade >= 18:
            self.__idade = idade
        else:
            raise ValueError("Idade insuficiente")
    
    def __str__(self):
        return f"Id: {self.getId()} - Nome: {self.getNome()} - Cpf: {self.getCPF()} - Telefone {self.getTelefone()} - Idade {self.getIdade()}"

class Clientes(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open ("Sistema/Json/clientes.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    u = Cliente(obj["_Cliente_id"], obj["_Cliente_nome"],  obj["_Cliente_cpf"],  obj["_Cliente_telefone"], obj["_Cliente_idade"], obj["_Cliente_admin"])
                    cls.objetos.append(u)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass

    @classmethod
    def salvar(cls):
        with open("Sistema/Json/clientes.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=vars)
