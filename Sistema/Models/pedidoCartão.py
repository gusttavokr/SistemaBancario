import json
from Models.Modelo import Modelo

class Pedido:
    def __init__(self, id, id_cliente, id_conta, id_cartão, aprovação):
        self.__id = id
        self.__idCliente = id_cliente
        self.__idConta = id_conta
        self.__idCartão = id_cartão
        self.__aprovação = aprovação

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')

    def getIdCliente(self):
        return self.__idCliente
    def setIdCliente(self, id_cliente):
        if len(str(id_cliente)) > 0:
            self.__idCliente == id_cliente
        else:
            raise ValueError('Id do cliente inválido')

    def getIdConta(self):
        return self.__idConta
    def setIdConta(self, id_conta):
        if len(str(id_conta)) > 0:
            self.__idConta == id_conta
        else:
            raise ValueError('Id da conta inválido')

    def getIdCartão(self):
        return self.__idCartão
    def setIdCartão(self, id_cartão):
        if len(str(id_cartão)) > 0:
            self.__idCartão == id_cartão
        else:
            raise ValueError('Id do cartão inválido')

    def getAprovação(self):
        return self.__aprovação
    def setAprovação(self, aprovação):
        self.__aprovação = aprovação        

    def __str__(self):
        return f"ID = {self.__id} - idCliente = {self.__idCliente} - idConta = {self.__idConta} - idCartão = {self.__idCartão} - Aprovação = {self.__aprovação}"
    
class Pedidos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("Sistema/Jso/PedidosCartão.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    p = Pedido(obj["_Pedido_id"], obj["_Pedido_idCliente"], obj["_Pedido_idConta"], obj["_Pedido_idCartão"], obj["_Pedido_aprovação"])
                    cls.objetos.append(p)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    @classmethod
    def salvar(cls):
        with open("Sistema/Json/PedidosCartão.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)