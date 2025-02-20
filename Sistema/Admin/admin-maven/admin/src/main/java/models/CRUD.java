package models;

import java.util.ArrayList;
import java.util.List;

public class CRUD<TipoObjeto extends VerificaId> {

    private List<TipoObjeto> listaObjetos;
    private final Class<TipoObjeto> tipoObjeto;

    public CRUD(Class<TipoObjeto> tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
        abrir();  // Inicializa a lista de objetos ao criar o CRUD
    }

    public void inserir(TipoObjeto objeto) {
        abrir();
        int id;
        if (tipoObjeto == Cliente.class && listaObjetos.isEmpty()) { id = -1; } 
        else { id = 0; }
        for (TipoObjeto obj : listaObjetos) {
            if (obj.getId() > id) {
                id = obj.getId();
            }
        }
        objeto.setId(id + 1);
        listaObjetos.add(objeto);
        salvar();
    }

    public List<TipoObjeto> listar() {
        abrir();
        return listaObjetos;
    }

    public boolean atualizar(int id, TipoObjeto novoObjeto) {
        abrir();
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getId() == id) {
                listaObjetos.set(i, novoObjeto);
                salvar();
                return true;
            }
        }
        return false;
    }

    public boolean deletar(int id) {
        abrir();
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getId() == id) {
                listaObjetos.remove(i);
                salvar();
                return true;
            }
        }
        return false;
    }

    // Método para salvar a lista de objetos no arquivo JSON
    private void salvar() {
        if (tipoObjeto == Cliente.class) {
            Clientes.salvar((List<Cliente>) (List<?>) listaObjetos); // Cast de forma segura
        } else if (tipoObjeto == Cartao.class) {
            Cartoes.salvar((List<Cartao>) (List<?>) listaObjetos); // Cast de forma segura
        } else if (tipoObjeto == TipoLancamento.class) {
            TiposLancamentos.salvar((List<TipoLancamento>) (List<?>) listaObjetos); // Cast de forma segura
        }
    }

    // Método para abrir os dados do arquivo JSON e carregar na lista de objetos
    private void abrir() {
        if (tipoObjeto == Cliente.class) {
            listaObjetos = (List<TipoObjeto>) (List<?>) Clientes.abrir(); // Cast de forma segura
        } else if (tipoObjeto == Cartao.class) {
            listaObjetos = (List<TipoObjeto>) (List<?>) Cartoes.abrir(); // Cast de forma segura
        } else if (tipoObjeto == TipoLancamento.class) {
            listaObjetos = (List<TipoObjeto>) (List<?>) TiposLancamentos.abrir(); // Cast de forma segura
        }
    }
}
