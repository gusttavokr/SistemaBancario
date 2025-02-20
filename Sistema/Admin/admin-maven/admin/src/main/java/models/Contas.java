package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class Contas {

    public static void salvar(List<Conta> listaObjetos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("/workspaces/SistemaBancario/Sistema/Json/contas.json")) {
            gson.toJson(listaObjetos, writer); // Converte a lista para JSON e escreve no arquivo
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public static List<Conta> abrir() {
        Gson gson = new Gson();
        List<Conta> listaObjetos = new ArrayList<>(); // Inicializando a lista com um ArrayList vazio
        try (FileReader reader = new FileReader("/workspaces/SistemaBancario/Sistema/Json/contas.json")) {
            Type tipoObjeto = new TypeToken<List<Conta>>() {}.getType(); // Define o tipo da lista
            listaObjetos = gson.fromJson(reader, tipoObjeto); // Desserializa o JSON para a lista de Contass
            if (listaObjetos == null) {
                listaObjetos = new ArrayList<>(); // Garantir que a lista não seja null
            }
        } catch (IOException erro) {
            System.err.println("Erro ao carregar dados do JSON para a lista: " + erro.getMessage());
        }
        return listaObjetos; // Retorna a lista de objetos (nunca null)
    }    
}
