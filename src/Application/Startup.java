package Application;

import controllers.GuicheController;
import models.Onibus;
import views.Guiche;
import views.PainelCentral;
import views.Quiosque;

public class Startup {

    public static void main(String[] args) {

        GuicheController guicheController = new GuicheController();

        for (int i = 0; i < 2; i++) {
            guicheController.criarOnibus(new Onibus("A" + i, 12));
        }

        Guiche guiche = new Guiche(guicheController);
        PainelCentral painelCentral = new PainelCentral(guicheController);
        Quiosque quiosque = new Quiosque(guicheController);

        guiche.comprarPassagem("A1");
        guiche.comprarPassagem("A1");
        guiche.comprarPassagem("A0");
        guiche.comprarPassagem("A0");
        guiche.comprarPassagem("A1");

        guiche.reservarPassagem("A0");
        guiche.reservarPassagem("A0");
        guiche.reservarPassagem("A1");
        guiche.reservarPassagem("A0");
    }
}
