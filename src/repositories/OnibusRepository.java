package repositories;

import models.Onibus;

import java.util.ArrayList;
import java.util.List;

public class OnibusRepository {

    private List<Onibus> onibusList;

    public OnibusRepository() {
        this.onibusList = new ArrayList<>();
    }

    public Onibus criar(Onibus onibus) {
        this.onibusList.add(onibus);
        return onibus;
    }

    public List<Onibus> recuperarTodos() {
        return this.onibusList;
    }

    public Onibus recuperarPorId(String id) {

        for (Onibus onibus : this.onibusList) {
            if (onibus.getId().equals(id))
                return onibus;
        }

        return null;
    }
}
