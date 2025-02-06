import json
from Models.Modelo import Modelo

class Usuário:
    def __init__(self, id, admin, nome, cpf, telefone):
        self.__id = id
        self.__admin = admin
        self.__nome = nome
        self.__cpf = cpf
        self.__telefone = telefone

    def getId(self):
        return self.__id
    def setId(self, id):
        return self.__id == id

    def getAdmin(self):
        return self.__admin
    def setAdmin(self, admin):
        return self.__admin == admin
    
    def getNome(self):
        return self.__nome
    def setNome(self, nome):
        return self.__nome == nome
    
    def getCPF(self):
        return self.__cpf
    def setCPF(self, cpf):
        return self.__cpf == cpf

    def getTelefone(self):
        return self.__telefone
    def setTelefone(self, telefone):
        return self.__telefone == telefone
    
    def __str__(self):
        return f"Id: {self.__getId()} - Nome: {self.__getNome()} - Cpf: {self.__getCPF()} - Telefone {self.__getTelefone()}"

class Usuários(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open ("Sistema/Json/Usuários.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    u = Usuário(obj["_Usuário_id"], obj["_Usuário_admin"], obj["_Usuário_nome"],  obj["_Usuário_cpf"],  obj["_Usuário_telefone"])
                    cls.objetos.append(u)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass

    @classmethod
    def salvar(cls):
        with open("Sistema/Json/Usuários.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=vars)
