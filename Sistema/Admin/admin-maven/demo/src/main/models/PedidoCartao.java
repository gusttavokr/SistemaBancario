package models;

public class PedidoCartao {
    private int id;
    private int idCliente;
    private int idConta;
    private int idCartao;
    private boolean aprovacao;

    public PedidoCartao(int id, int idCLiente, int idConta, int idCartao) {
        this.setId(id);
        this.setIdCliente(idCliente);
        this.setIdConta(idConta);
        this.setIdCartao(idCartao);
        this.aprovacao = false;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setIdCliente(int idCliente) {
        if (idCliente > 0) {
            this.idCliente = idCliente;
        } else {
            throw new IllegalArgumentException("INVALID CLIENT ID");
        }
    }

    public void setIdConta(int idConta) {
        if (idConta > 0) {
            this.idConta = idConta;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT ID");
        }
    }

    public void setIdCartao(int idCartao) {
        if (idCartao > 0) {
            this.idCartao = idCartao;
        } else {
            throw new IllegalArgumentException("INVALID CARD ID");
        }
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public int getId() {
        return this.id;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public int getIdConta() {
        return this.idConta;
    }

    public int getIdCartao() {
        return this.idCartao;
    }

    public boolean getAprovacao() {
        return this.aprovacao;
    }

    public String toString() {
        return String.format("ID Cliente: %d - ID Conta: %d - ID Cartão: %d - Status Aprovação: %b", this.getIdCliente(), this.getIdConta(), this.getIdCartao(), this.getAprovacao());
    }
}