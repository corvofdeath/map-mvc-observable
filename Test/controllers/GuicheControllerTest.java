package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import builders.OnibusBuilder;
import models.Onibus;

public class GuicheControllerTest {
	
	private GuicheController guicheController;
	private Onibus onibus;

	@Before
    public void setUp(){
		this.guicheController = new GuicheController();
		this.onibus = OnibusBuilder.mockOnibus().getOnibus();
	}
	
	@Test
	public void registrarAcentoListenerTest() {
		//assertEquals();
				
	}
	
	@Test
	public void pegarTodosOsOnibusTest() {
		this.guicheController.criarOnibus(this.onibus);
		assertFalse(this.guicheController.pegarTodosOsOnibus().isEmpty());
	}
	
	@Test
	public void comprarPassagemTest() {
		this.guicheController.criarOnibus(this.onibus);
		assertTrue(this.guicheController.comprarPassagem(this.onibus.getId()));
	}
	
	@Test
	public void reservarPassagemTest() {
		this.guicheController.criarOnibus(this.onibus);
		assertTrue(this.guicheController.reservarPassagem(this.onibus.getId()));
	}
	
	@Test
	public void criarOnibusTest() {
		assertEquals(this.guicheController.criarOnibus(this.onibus), this.onibus);
	}
}
