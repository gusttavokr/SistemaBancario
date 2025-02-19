package models;

public class PedidoCartao {
    private int id;
    private int idCliente;
    private int idConta;
    private String tipoCartao; // apenas DEBITO ou CREDITO
    private boolean aprovacao;

    public PedidoCartao(int id, int idCLiente, int idConta, String tipoCartao) {
        this.setId(id);
        this.setIdCliente(idCliente);
        this.setIdConta(idConta);
        this.setTipoCartao(tipoCartao);
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

    public void setTipoCartao(String tipoCartao) {
        if (tipoCartao.equals("DEBITO") || tipoCartao.equals("CREDITO")) {
            this.tipoCartao = tipoCartao;
        } else {
            throw new IllegalArgumentException("INVALID OPTION, INSERT 'DEBITO' OR 'CREDITO'");
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

    public String getTipoCartao() {
        return this.tipoCartao;
    }

    public boolean getAprovacao() {
        return this.aprovacao;
    }

    public String toString() {
        return String.format("ID Cliente: %d - ID Conta: %d - Tipo de Cartão: %s - Status Aprovação: %b", this.getIdCliente(), this.getIdConta(), this.getTipoCartao(), this.getAprovacao());
    }
}