package models;

public class TipoLancamento implements VerificaId {
    private int id;
    private String descricao;

    public TipoLancamento() {
        // Construtor sem parâmetros para o Gson
    }

    public TipoLancamento(int id, String descricao) {
        this.setId(id);
        this.setDescricao(descricao);
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("INVALID DESCRIPTION");
        }
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String toString() {
        return String.format("Descrição: %s", this.getDescricao());
    }
}