package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
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
        int id = 0;
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getId() > id) {
                id = listaObjetos.get(i).getId();
            }
        }
        objeto.setId(id+1);
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
            Clientes.salvar((List<Cliente>) listaObjetos);
        }
    }

    // Método para abrir os dados do arquivo JSON e carregar na lista de objetos
    private void abrir() {
        if (tipoObjeto == Cliente.class) {
            listaObjetos = (List<TipoObjeto>) Clientes.abrir();
        }
    }

}