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
        return f"ID = {self.__id} - Descrição = {self.__descrição}"
    
class tiposLançamentos(Modelo):
    