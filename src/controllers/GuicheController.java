package controllers;

import models.Acento;
import models.Onibus;
import observer.Listener;
import observer.Observer;
import repositories.OnibusRepository;

import java.util.List;

public class GuicheController {

    private Observer<Acento> acentoObserver = new Observer<>();
    private Observer<Onibus> onibusObserver = new Observer<>();
    private OnibusRepository repository = new OnibusRepository();

    public Observer<Acento> registrarAcentoListener(Listener<Acento> listener) {
        this.acentoObserver.subscriver(listener);
        return this.acentoObserver;
    }

    public Observer<Onibus> registrarOnibusListener(Listener<Onibus> listener) {
        this.onibusObserver.subscriver(listener);
        return this.onibusObserver;
    }

    public List<Onibus> pegarTodosOsOnibus() {
        return this.repository.recuperarTodos();
    }

    public boolean comprarPassagem(String onibusId) {

        Onibus onibus = this.repository.recuperarPorId(onibusId);
        if (onibus.isLotado())
            return false;

        Acento acento = onibus.ocuparAcentoVago();
        this.acentoObserver.notificar(acento);

        if (onibus.isLotado())
            this.onibusObserver.notificar(onibus);

        return true;
    }

    public boolean reservarPassagem(String onibusId) {

        Onibus onibus = this.repository.recuperarPorId(onibusId);
        if (onibus.isLotado())
            return false;

        Acento acento = onibus.reservarAcentoVago();
        this.acentoObserver.notificar(acento);

        if (onibus.isLotado())
            this.onibusObserver.notificar(onibus);

        return true;
    }

    public Onibus criarOnibus(Onibus onibus) {
        return this.repository.criar(onibus);
    }
}
