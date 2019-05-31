package views;

import controllers.GuicheController;

public class Guiche {

    private GuicheController guicheController;

    public Guiche(GuicheController guicheController) {
        this.guicheController = guicheController;
    }

    public boolean comprarPassagem(String onibusId) {
        return this.guicheController.comprarPassagem(onibusId);
    }

    public boolean reservarPassagem(String onibusId) {
        return this.guicheController.reservarPassagem(onibusId);
    }
}
