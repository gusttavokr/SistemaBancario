import json
from Models.Modelo import Modelo

class tipoLançamento:
    def __init__(self, id, descrição):
        self.__id = id
        self.__descrição = descrição

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError("Id inválido")
        
    def getDescrição(self):
        return self.__descrição
    def setDescrição(self, descrição):
        if len(descrição) > 0:
            self.__descrição = descrição
        else:
            raise ValueError("Descrição inválida")

    def __str__(self):
        return f"ID = {self.getId()} - Descrição = {self.getDescrição()}"
    
class tiposLançamentos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("Sistema/Json/tiposLançamentos.json", mode = "r") as arquivo:
                objetos = json.dump(arquivo)
                for obj in objetos:
                    tiposL = tipoLançamento(obj["_tipoLançamento_id"], obj["_tipoLançamento_descrição"])
                    cls.objetos.append(tiposL)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass

    @classmethod
    def salvar(cls):
        with open("Sistema/Json/tiposLançamentos.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)