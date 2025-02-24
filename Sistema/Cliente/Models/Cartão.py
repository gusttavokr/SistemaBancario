import json
from Models.Modelo import Modelo

class Cartão:
    def __init__(self, id, idConta, debito, credito, limite, validade, numero, senha):
        self.__id = id
        self.__idConta = idConta
        self.__debito = debito
        self.__credito = credito
        self.__limite = limite
        self.__validade = validade
        self.__numero = numero
        self.__senha = senha

    def getId(self):
        return self.__id
    def setId(self, id):
        if len(str(id)) > 0:
            self.__id = id
        else:
            raise ValueError('Id inválido')

    def getIdConta(self):
        return self.__idConta
    def setIdConta(self, idConta):
        if len(str(idConta)) > 0:
            self.__idConta = idConta
        else:
            raise ValueError('Id da conta inválido')

    def getDebito(self):
        return self.__debito
    def setDebito(self, debito):
        self.__debito = debito
    
    def getCredito(self):
        return self.__credito
    def setCredito(self, credito):
        self.__credito = credito
    
    def getLimite(self):
        return self.__limite
    def setLimite(self, limite):
        if limite > 0:
            self.__limite = limite
        else:
            raise ValueError('Limite inválido')
    
    def getValidade(self):
        return self.__validade
    def setValidade(self, validade):
        if len(validade) > 0:
            self.__validade = validade
        else:
            raise ValueError('Validade inválida')
    
    def getNumero(self):
        return self.__numero
    def setNumero(self, numero):
        if len(numero) > 0:
            self.__numero = numero
        else:
            raise ValueError('Numero inválido')

    def getSenha(self):
        return self.__senha
    def setSenha(self, senha):
        if len(senha) > 0:
            self.__senha = senha
        else:
            raise ValueError('Senha inválida')


    def to_json(self):
        dic = {}
        dic["id"] = self.getId()
        dic["idConta"] = self.getIdConta()
        dic["debito"] = self.getDebito()
        dic["credito"] = self.getCredito()
        dic["limite"] = self.getLimite()
        dic["validade"] = self.getValidade()
        dic["numero"] = self.getNumero()
        dic["senha"] = self.getSenha()

        return dic

    def __str__(self):
        return f"ID = {self.getId()} - Tipo = {self.getTipo()}"

class Cartões(Modelo):
    @classmethod
    def abrir(cls):
        cls.objetos = []
        try:
            with open("../Json/cartoes.json", mode="r") as arquivo:
                objetos_json = json.load(arquivo)
                for obj in objetos_json:
                    card = Cartão(
                        obj["id"],
                        obj["idConta"],
                        obj["debito"],
                        obj["credito"],
                        obj["limite"],
                        obj["validade"],
                        obj["numero"],
                        obj["senha"]
                    )
                    cls.objetos.append(card)
        except FileNotFoundError:
            pass
        except json.JSONDecodeError:
            pass
    @classmethod
    def salvar(cls):
        with open("../Json/cartoes.json", mode="w") as arquivo:
            json.dump(cls.objetos, arquivo, default =vars)