import json
from Models.Modelo import Modelo

class Conta:
    def __init__(self, id, idCliente, numero, saldo):
        self.__id = id
        self.__idCliente = idCliente
        self.__numero = numero
        self.__saldo = saldo

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')
        
    def getNumero(self):
        return self.__numero
    def setNumero(self, numero):
        if len(numero) > 0 and len(numero) < 11:
            self.__numero = numero
        else:
            raise ValueError("Número inválido")
        
    def getSaldo(self):
        return self.__saldo
    def setSaldo(self, saldo):
        if saldo > 0:
            self.__saldo = saldo
        else:
            raise ValueError("Saldo inválido")
        
    def getIdCliente(self):
        return self.__idCliente
    def setIdCliente(self, idCliente):
        if len(str(idCliente)) > 0:
            self.__idCliente = idCliente
        else:
            raise ValueError('Id do cliente inválido')


    def __str__(self):
        return f"Id = {self.getId()} - IdCliente = {self.getIdCliente()} - Número = {self.getNumero()} - Saldo = {self.getSaldo()}"
    
class Contas(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("Sistema/Json/contas.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    c = Conta(obj["_Conta_id"], obj["_Conta_idCliente"], obj["_Conta_numero"], obj["_Conta_saldo"])
                    cls.objetos.append(c)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    @classmethod
    def salvar(cls):
        with open("Sistema/Json/Contas.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)