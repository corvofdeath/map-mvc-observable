package models;

import enums.Disponibilidade;

public class Acento {

    private Disponibilidade disponibilidade;
    private int numero;

    public Acento(Disponibilidade disponibilidade, int numero) {
        this.disponibilidade = disponibilidade;
        this.numero = numero;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getNumero() {
        return numero;
    }
}
