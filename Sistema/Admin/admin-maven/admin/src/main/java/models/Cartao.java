package models;

class InvalidCardException extends RuntimeException {
    public InvalidCardException(String errorMsg) {
        super(errorMsg);
    }
}

public class Cartao implements VerificaId {
    private int id;
    private int idConta;
    private boolean debito = false;
    private boolean credito = false;
    private double limite;
    private String validade;
    private String numero;
    private String senha;

    public Cartao() {
        // Construtor sem parâmetros para o Gson
    }

    public Cartao(int id, int idConta, boolean debito, boolean credito, double limite, String validade, String numero, String senha) {
        this.setId(id);
        this.setIdConta(idConta);
        this.setDebito(debito);
        this.setCredito(credito);
        this.setLimite(limite);
        this.setValidade(validade);
        this.setNumero(numero);
        this.setSenha(senha);
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setIdConta(int idConta) {
        if (idConta >= 0) {
            this.idConta = idConta;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT ID");
        }
    }

    public void setDebito(boolean debito) {
        if (!(this.getCredito())) {
            this.debito = debito;
        } else {
            throw new IllegalArgumentException("THIS CARD ALREADY CREDIT");
        }
    }

    public void setCredito(boolean credito) {
        if (!(this.debito)) {
            this.credito = credito;
        } else {
            throw new InvalidCardException("THIS CARD ALREADY DEBIT");
        }
    }

    public void setLimite(Double limite) {
        if (limite > 0) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException("INVALID LIMIT");
        }
    }

    public void setValidade(String validade) {
        if (!(validade.isEmpty())) {
            this.validade = validade;
        } else {
            throw new IllegalArgumentException("INVALID EXPIRATION DATE");
        }
    }

    public void setNumero(String numero) {
        if (!(numero.isEmpty())) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("INVALID CARD NUM");
        }
    }

    public void setSenha(String senha) {
        if (!(senha.isEmpty())) {
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("INVALID PASSWORD");
        }
    }

    public int getId() {
        return this.id;
    }

    public int getIdConta() {
        return this.idConta;
    }

    public boolean getDebito() {
        return this.debito;
    }

    public boolean getCredito() {
        return this.credito;
    }

    public double getLimite() {
        return this.limite;
    }

    public String getValidade() {
        return this.validade;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getSenha() {
        return this.senha;
    }

    public String toString() {
        return String.format("ID da Conta: %d - Debito: %b - Crédito: %b - Limite: %.2f - Validade: %s - Número: %s - Senha: %s", this.getIdConta(), this.getDebito(), this.getCredito(), this.getLimite(), this.getValidade(), this.getNumero(), this.getSenha());
    }


}

