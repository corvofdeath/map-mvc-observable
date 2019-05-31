package views;

import controllers.GuicheController;
import enums.Disponibilidade;
import models.Acento;
import models.Onibus;
import observer.Listener;

import java.util.EventObject;
import java.util.List;

public class Quiosque {

    private Listener<Acento> listener;
    private GuicheController controller;
    private int maxItemsPorLinhal = 3;

    public Quiosque(GuicheController controller) {
        this.controller = controller;

        this.listener = new Listener<Acento>() {

            @Override
            public void notificar(EventObject e, Acento element) {
                exibir();
            }
        };

        this.controller.registrarAcentoListener(this.listener);
        exibir();
    }

    public void exibir() {

        StringBuilder builder = new StringBuilder();
        builder.append("============ QUIOSQUE =================");
        List<Onibus> onibusList = this.controller.pegarTodosOsOnibus();

        builder.append("\n");
        for (Onibus onibus : onibusList) {
            builder.append("\n");
            builder.append("Onibus: ");
            builder.append(onibus.getId());
            builder.append("\n");

            int itemsPorLinha = 0;
            for (Acento acento : onibus.getAcentos()) {

                if (itemsPorLinha == this.maxItemsPorLinhal) {
                    builder.append("\n");
                    itemsPorLinha = 0;
                }

                builder.append("Acento ");
                builder.append(acento.getNumero());
                builder.append(": ");
                builder.append(acento.getDisponibilidade().toString());

                if (itemsPorLinha < this.maxItemsPorLinhal) {
                    builder.append(", ");
                    itemsPorLinha++;
                }
            }

            builder.append("\n");
        }

        System.out.println(builder.toString());
    }
}
