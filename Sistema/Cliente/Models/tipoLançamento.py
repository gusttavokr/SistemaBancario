import json
from Models.Modelo import Modelo

class tipoLancamento:
    def __init__(self, id, descrição):
        self.__id = id
        self.__descricao = descrição

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError("Id inválido")
        
    def getDescrição(self):
        return self.__descricao
    def setDescrição(self, descrição):
        if len(descrição) > 0:
            self.__descricao = descrição
        else:
            raise ValueError("Descrição inválida")

    def to_json(self):
        dic = {}
        dic["id"] = self.getId()
        dic["descricao"] = self.getDescrição()

    def __str__(self):
        return f"ID = {self.getId()} - Descrição = {self.getDescrição()}"
    
class tiposLancamentos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("../Json/tiposLancamentos.json", mode = "r") as arquivo:
                objetos = json.load(arquivo)
                for obj in objetos:
                    tiposL = tipoLancamento(
                        obj["id"],
                        obj["descricao"]
                    )
                    cls.objetos.append(tiposL)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass

    @classmethod
    def salvar(cls):
        with open("../Json/tiposLancamentos.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=lambda o: o.to_json(), indent=4)