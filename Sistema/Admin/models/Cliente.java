package models;

public class Cliente  implements VerificaGetId {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;
    private boolean admin;

    public Cliente(int id, String nome, String cpf, String telefone, int idade) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.setIdade(idade);
        this.setAdmin(this.getId());
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("INVALID NAME");
        }
    }

    public void setCpf(String cpf) {
        if (!cpf.isEmpty()) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("INVALID CPF");
        }  
    }

    public void setTelefone(String telefone) {
        if (!telefone.isEmpty()) {
            this.telefone = telefone;;
        } else {
            throw new IllegalArgumentException("INVALID FONE");
        }  
    }

    public void setIdade(int idade) {
        if (idade >= 18) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("INVALID AGE");
        }
    }

    public void setAdmin(int id) {
        if (id == 0) {
            this.admin = true;
        } else {
            this.admin = false;
        }
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public int getIdade() {
        return this.idade;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public String toString() {
        return String.format("Nome: %s - CPF: %s - Telefone: %s - Idade: %d", this.getNome(), this.getCpf(), this.getTelefone(), this.getIdade());
    }

}

public class Clientes extends CRUD<Cliente> {

    public Clientes(List<Cliente> listaClientes) {
        super(listaClientes);
    }

    abrir() {
        
    }
}



// // ProductCRUD.java
// import java.util.List;

// public class ProductCRUD extends CRUD<Product> {

//     public ProductCRUD(List<Product> db) {
//         super(db);
//     }

//     // Aqui você pode adicionar métodos específicos para manipular produtos, se necessário.
// }