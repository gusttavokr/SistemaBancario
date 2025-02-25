import json
from Models.Modelo import Modelo

class Lançamento:
    def __init__(self, id, idTipoLançamento, numeroContaOrigem, numeroContaDestino, valor):
        self.__id = id
        self.__idTipoLançamento = idTipoLançamento
        self.__numeroContaOrigem = numeroContaOrigem
        self.__numeroContaDestino = numeroContaDestino
        self.__valor = valor

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
        if len(numeroContaOrigem) > 0:
            self.__numeroContaOrigem = numeroContaOrigem
        else:
            raise ValueError("Número da conta origem inválido")
    
    def getNumeroContaDestino(self):
        return self.__numeroContaDestino
    def setNumeroContaDestino(self, numeroContaDestino):
        if len(numeroContaDestino) > 0:
            self.__numeroContaDestino = numeroContaDestino
        else:
            raise ValueError("Número da conta destino inválido")

    def getValor(self):
        return self.__valor
    def setValor(self, valor):
        if valor >= 0:
            self.__valor = valor
        else:
            raise ValueError("Valor inválido")
    
    
    
    def to_json(self):
        dic = {}
        dic["id"] = self.getId()
        dic["idTipoLançamento"] = self.getIdTipoLançamento()
        dic["numeroContaOrigem"] = self.getNumeroContaOrigem()
        dic["numeroContaDestino"] = self.getNumeroContaDestino()
        dic["valor"] = self.getValor()
        return dic

    def __str__(self):
        return f"ID = {self.getId()} - IdTipoLançamento = {self.getIdTipoLançamento()} - Número da Conta Origem = {self.getNumeroContaOrigem()} - Número da conta Destino = {self.getNumeroContaDestino()}"
    
class Lançamentos(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("../Json/Lancamentos.json", mode ="r") as arquivo:
                objetos = json.dump(arquivo)
                for obj in objetos:
                    L = Lançamento(
                        obj["id"],
                        obj["idTipoLançamento"],
                        obj["numeroContaOrigem"],
                        obj["numeroContaDestino"],
                        obj["valor"]
                    )
                    cls.objetos.append(L)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    
    @classmethod
    def salvar(cls):
        with open("../Json/Lancamentos.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default=lambda o: o.to_json(), indent=4)