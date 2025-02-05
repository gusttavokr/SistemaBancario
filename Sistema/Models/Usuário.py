class Usuário:
    def __init__(self, id, admin, nome, cpf, telefone):
        self.__id = id
        self.__admin = admin

    def getId(self):
        return self.__id
    def setId(self, id):
        return self.__id == id

    def getAdmin(self):
        return self.__admin
    def setAdmin(self, admin):
        return self.__admin == admin
    
    def __str__(self):
        return f"Id: {self.__id} - Admin: {self.__admin}"