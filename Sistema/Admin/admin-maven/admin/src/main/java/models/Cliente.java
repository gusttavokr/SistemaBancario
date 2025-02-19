package models;

public class Cliente implements VerificaId{
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;
    private String email;
    private String senha;
    private boolean admin;

    public Cliente() {
        // Construtor sem parâmetros para o Gson
    }
    
    public Cliente(int id, String nome, String cpf, String telefone, int idade, String email, String senha) {
        super();
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.setIdade(idade);
        this.setEmail(email);
        this.setSenha(senha);
        this.setAdmin(false);
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

    public void setEmail(String email) {
        if (!(email.isEmpty())) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("INVALID EMAIL");
        }
    }

    public void setSenha(String senha) {
        if (!(senha.isEmpty())) {
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("INVALID PASSWORD");
        }
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public String toString() {
        return String.format("Nome: %s - CPF: %s - Telefone: %s - Idade: %d - E-mail: %s - Senha: %s", this.getNome(), this.getCpf(), this.getTelefone(), this.getIdade(), this.getEmail(), this.getSenha());
    }

}