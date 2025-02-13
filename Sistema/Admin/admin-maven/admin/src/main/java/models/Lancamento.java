package models;

public class Lancamento {
    private int id;
    private int idTipoLancamento;
    private String numeroContaOrigem;
    private String numeroContaDestino;
    private double valor;

    public Lancamento(int id, int idTipoLancamento, String numeroContaOrigem, String numeroContaDestino, double valor) {
        this.setId(id);
        this.setIdTipoLancamento(idTipoLancamento);
        this.setNumeroContaOrigem(numeroContaOrigem);
        this.setNumeroContaDestino(numeroContaDestino);
        this.setValor(valor);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setIdTipoLancamento(int idTipoLancamento) {
        if (idTipoLancamento > 0) {
            this.idTipoLancamento = idTipoLancamento;
        } else {
            throw new IllegalArgumentException("INVALID OPERATION ID");
        }
    }

    public void setNumeroContaOrigem(String numeroContaOrigem) {
        if (!numeroContaOrigem.isEmpty()) {
            this.numeroContaOrigem = numeroContaOrigem;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT NUM");
        }
    }

    public void setNumeroContaDestino(String numeroContaDestino) {
        if (!numeroContaDestino.isEmpty()) {
            this.numeroContaDestino = numeroContaDestino;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT NUM");
        }
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("INVALID VALUE"); 
        }
    }

    public int getId() {
        return this.id;
    }

    public int getIdTipoLancamento() {
        return this.idTipoLancamento;
    }

    public String getNumeroContaOrigem() {
        return this.numeroContaOrigem;
    }

    public String getNumeroContaDestino() {
        return this.numeroContaDestino;
    }

    public double getValor() {
        return this.valor;
    }

    public String toString() {
        return String.format("ID Tipo de Lançamento: %d - Conta de Origem: %s - Conta de Destino: %s - Valor: R$ %.2f", this.getIdTipoLancamento(), this.getNumeroContaOrigem(), this.getNumeroContaDestino(), this.getValor());
    }
}
