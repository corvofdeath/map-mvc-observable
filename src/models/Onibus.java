package models;


import enums.Disponibilidade;

public class Onibus {

    private String id;
    private Acento[] acentos;
    private int capacidade;
    private int lotacao = 0;

    public Onibus(String id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;

        iniciar();
    }

    private void iniciar() {

        this.acentos = new Acento[this.capacidade];
        for (int i = 0; i < this.capacidade; i++)
            this.acentos[i] = new Acento(Disponibilidade.DISPONIVEL, i + 1);
    }

    public String getId() {
        return id;
    }
    

    public Acento[] getAcentos() {
        return acentos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void incrementarLocatacao() {
        this.lotacao += 1;
    }

    public boolean isLotado() {
        return lotacao == capacidade;
    }

    public Acento reservarAcentoVago() {

        Acento acento = this.acharPrimeiroAcentoDisponivel();
        acento.setDisponibilidade(Disponibilidade.RESERVADO);
        return acento;
    }

    public Acento ocuparAcentoVago() {

        Acento acento = this.acharPrimeiroAcentoDisponivel();
        acento.setDisponibilidade(Disponibilidade.INDISPONIVEL);
        return acento;
    }

    private Acento acharPrimeiroAcentoDisponivel() {

        for (Acento acento : this.acentos) {
            if (acento.getDisponibilidade() == Disponibilidade.DISPONIVEL) {
                return acento;
            }
        }

        return null;
    }
}
