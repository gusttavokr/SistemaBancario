import json
from Models.Modelo import Modelo

class Pedido:
    def __init__(self, id, id_cliente, id_conta, tipoCartao, aprovacao = False):
        self.__id = id
        self.__idCliente = id_cliente
        self.__idConta = id_conta
        self.__tipoCartao = tipoCartao
        self.__aprovacao = aprovacao

    def getId(self):
        return self.__id
    def setId(self, id):
        if id > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')

    def getIdCliente(self):
        return self.__idCliente
    def setIdCliente(self, id_cliente):
        if len(str(id_cliente)) > 0:
            self.__idCliente = id_cliente
        else:
            raise ValueError('Id do cliente inválido')

    def getIdConta(self):
        return self.__idConta
    def setIdConta(self, id_conta):
        if len(str(id_conta)) > 0:
            self.__idConta = id_conta
        else:
            raise ValueError('Id da conta inválido')

    def gettipoCartão(self):
        return self.__tipoCartao
    def settipoCartão(self, tipoCartao):
        if len(str(tipoCartao)) > 0:
            self.__tipoCartao = tipoCartao
        else:
            raise ValueError('Tipo do cartão inválido')

    def getAprovação(self):
        return self.__aprovacao
    def setAprovação(self, aprovação):
        self.__aprovacao = aprovação        

    def to_json(self):
        dic = {}
        dic["id"] = self.getId()
        dic["id_cliente"] = self.getIdCliente()
        dic["id_conta"] = self.getIdConta()
        dic["tipoCartao"] = self.gettipoCartão()
        dic["aprovacao"] = self.getAprovação()

        return dic

    def __str__(self):
        return f"ID = {self.getId()} - idCliente = {self.getIdCliente()} - idConta = {self.getIdConta()} - Tipo Cartão = {self.gettipoCartão()} - Aprovação = {self.getAprovação()}"
    
class Pedidos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("../Json/pedidosCartao.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    p = Pedido(
                        obj["id"],
                        obj["id_cliente"],
                        obj["id_conta"],
                        obj["tipoCartao"],
                        obj["aprovacao"]
                    )
                    cls.objetos.append(p)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    @classmethod
    def salvar(cls):
        with open("../Json/pedidosCartao.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=lambda o: o.to_json(), indent=4)