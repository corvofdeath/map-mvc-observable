package views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import builders.OnibusBuilder;
import controllers.GuicheController;
import models.Onibus;

public class GuicheTest {
	
	private Guiche guiche;
	private GuicheController guicheController;
	private Onibus onibus;

	@Before
    public void setUp(){
		this.guicheController = new GuicheController();
		this.guiche = new Guiche(this.guicheController);
		this.onibus = OnibusBuilder.mockOnibus().getOnibus();
	}
	
	@Test
	public void comprarPassagem() {
		this.guicheController.criarOnibus(this.onibus);
		assertTrue(this.guiche.comprarPassagem(this.onibus.getId()));
	}
	
	@Test
	public void reservarPassagem() {
		this.guicheController.criarOnibus(this.onibus);
		assertTrue(this.guiche.reservarPassagem(this.onibus.getId()));
	}
}

