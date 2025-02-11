public class Cartao {
    private int id;
    private String tipo;
    
    public Cartao(int id, String tipo) {
        this.setId(id);
        this.setTipo(tipo);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setTipo(String tipo) {
        if (!tipo.isEmpty()) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("INVALID TYPE");
        }
    }

    public int getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String toString() {
        return String.format("Tipo do cartão: %s", this.getTipo());
    }
} 