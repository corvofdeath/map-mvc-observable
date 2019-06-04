package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import builders.OnibusBuilder;
import models.Onibus;
import repositories.OnibusRepository;

public class OnibusRepositoryTest {
	 
	private OnibusRepository onibusRepository;
	private List<Onibus> listOnibus;
	private Onibus onibus;
	

	@Before
    public void setUp(){
		this.onibusRepository = new OnibusRepository();
		this.listOnibus = (List<Onibus>) OnibusBuilder.mockCollectionOnibus().getListOnibus();
		this.onibus = OnibusBuilder.mockOnibus().getOnibus();
	}
	
	@Test
	public void criarTest() {
		assertEquals(this.onibusRepository.criar(this.onibus), this.onibus);
		assertFalse(this.onibusRepository.recuperarTodos().isEmpty());
	}
	
	@Test
	public void recuperarTodosTest() {
		this.onibusRepository.criar(this.onibus);
		assertFalse(this.onibusRepository.recuperarTodos().isEmpty());
	}
	
	@Test
	public void recuperarPorIdTest() {
		this.onibusRepository.criar(this.onibus);
		assertEquals(this.onibusRepository.recuperarPorId(this.onibus.getId()).getId(), this.onibus.getId());
	}
}
