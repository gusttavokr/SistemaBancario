package models;

import java.util.List;

public class ObjectWithoutGetIdException extends RuntimeException {
    public ObjectWithoutGetIdException() {
        super("METHOD 'getId()' NOT FOUND");
    }
}

public interface VerificaGetId {
    int getId();
}

public class CRUD<TipoObjeto> {
    private List<TipoObjeto> listaObjetos;

    public CRUD(TipoObjeto listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public void inserir(TipoObjeto objeto) {
        if (objeto instanceof VerificaGetId) {
            int id = 0;
            if (listaObjetos.size() != 0) {
                for (int i = 0; i < listaObjetos.size(); i++) {
                    if (listaObjetos.get(i).getId() > id) {
                        id = listaObjetos.get(i).getId();
                    }
                }
            } else { id = -1; }
            objeto.setId(id+1);
            listaObjetos.add(objeto);
        } else {
            throw new ObjectWithoutGetIdException();
        }
    }

    public TipoObjeto listar() {
        return listaObjetos;
    }

    public void atualizar(int id, TipoObjeto novoObjeto) {
        if (novoObjeto instanceof VerificaGetId) {
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (listaObjetos.get(i).getId() == id) {
                    listaObjetos.set(i, novoObjeto);
                    break;
                }
            }
        } else {
            throw new ObjectWithoutGetIdException();
        }
    }

    public void deletar(int id, TipoObjeto novoObjeto) {
        if (novoObjeto instanceof VerificaGetId) {
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (listaObjetos.get(i).getId() == id) {
                    listaObjetos.set(i, novoObjeto);
                    break;
                }
            }
        } else {
            throw new ObjectWithoutGetIdException();
        }
    }


}