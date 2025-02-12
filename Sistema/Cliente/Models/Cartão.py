import json
from Models.Modelo import Modelo

class Cartão:
    def __init__(self, id, tipo):
        self.__id = id
        self.__tipo = tipo

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')

    def getTipo(self):
        return self.__tipo
    def setTipo(self, tipo):
        if len(tipo) > 0:
            self.__tipo = tipo
        else:
            raise ValueError("Tipo inválido")

    def __str__(self):
        return f"ID = {self.getId()} - Tipo = {self.getTipo()}"

class Cartões(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("Sistema/Jso/Cartões.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    card = Cartão(obj["_Cartão_id"], obj["_Cartão_tipo"])
                    cls.objetos.append(card)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    @classmethod
    def salvar(cls):
        with open("Sistema/Json/Cartões.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)