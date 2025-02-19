package models;

import java.util.Arrays;

public class Conta implements VerificaId {
    private int id;
    private int idCliente;
    private String numero;
    private double saldo;

    public Conta(int id, int idCliente, String numero, double saldo) {
        this.setId(id);
        this.setIdCliente(idCliente);
        this.setNumero(numero);
        this.setSaldo(saldo);
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("INVALID ID");
        }
    }

    public void setIdCliente(int idCliente) {
        if (idCliente > 0) {
            this.idCliente = idCliente;
        } else {
            throw new IllegalArgumentException("INVALID ID CLIENT");
        }
    }

    public void setNumero(String numero) {
        if (!numero.isEmpty()) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT NUM");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            throw new IllegalArgumentException("INVALID ACCOUNT BALANCE");
        }
    }

    public int getId() {
        return this.id;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String toString() {
        return String.format("ID do Cliente: %d - ID dos Cartões: %d - Número: %s - Saldo: R$ %.2f", this.getIdCliente(), Arrays.toString(this.getIdCartao()), this.getNumero(), this.getSaldo());
    }
}
