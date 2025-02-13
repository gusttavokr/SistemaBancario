import json
from Models.Modelo import Modelo

class Lançamento:
    def __init__(self, id, idTipoLançamento, numeroContaOrigem, numeroContaDestino):
        self.__id = id
        self.__idTipoLançamento = idTipoLançamento
        self.__numeroContaOrigem = numeroContaOrigem
        self.__numeroContaDestino = numeroContaDestino

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError("Id inválido")
        
    def getIdTipoLançamento(self):
        return self.__id
    def setIdTipoLançamento(self, idTipoLançamento):
        if len(str(idTipoLançamento)) > 0:
            self.__idTipoLançamento = idTipoLançamento
        else:
            raise ValueError("Id do tipo do lançamento inválido")
        
    def getNumeroContaOrigem(self):
        return self.__numeroContaOrigem
    def setNumeroContaOrigem(self, numeroContaOrigem):
        if numeroContaOrigem != "":
            self.__numeroContaOrigem = numeroContaOrigem
        else:
            raise ValueError("Número da conta origem inválido")
    
    def getNumeroContaDestino(self):
        return self.__numeroContaDestino
    def setNumeroContaDestino(self, numeroContaDestino):
        if numeroContaDestino != "":
            self.__numeroContaDestino = numeroContaDestino
        else:
            raise ValueError("Número da conta destino inválido")
    
    def __str__(self):
        return f"ID = {self.getId()} - IdTipoLançamento = {self.getIdTipoLançamento()} - Número da Conta Origem = {self.getNumeroContaOrigem()} - Número da conta Destino = {self.getNumeroContaDestino()}"
    
class Lançamentos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("Sistema/Json/lancamentos.json", mode ="r") as arquivo:
                objetos = json.dump(arquivo)
                for obj in objetos:
                    L = Lançamento(obj["_Lançamento_id"], obj["_Lançamento_idTipoLançamento"], obj["_Lançamento_numeroContaOrigem"], obj["_Lançamento_numeroContaDestino"])
                    cls.objetos.append(L)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    
    @classmethod
    def salvar(cls):
        with open("Sistema/Json/Lançamento.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)