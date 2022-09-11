package teste.testeMaven;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente c;
	@Before
	public void setUp() throws Exception {
		this.c = new Cliente("Gabriel", 1);
	}

	@After
	public void tearDown() throws Exception {
	
	}
	
	@Test
	public void testClient() {
		assertEquals("Gabriel", c.nome);
		assertEquals(1, c.id);
	}

	@Test
	public void testToggleActive() {
		c.toggleActive();
		assertEquals(false, c.isActive);
		c.toggleActive();
		assertEquals(true, c.isActive);
	}
	@Test
	public void testAddFavorito() {
		Filme f = new Filme("Java muito feliz", Genero.ROMANCE);
		c.addFavorito(f);
		ArrayList<Filme> aux = new ArrayList<Filme>();
		aux.add(f);
		assertArrayEquals(aux.toArray(), c.filmesFavoritos.toArray());
	}
	@Test
	public void testRemoveFavorito() {
		Filme f = new Filme("Java muito feliz", Genero.ROMANCE);
		c.addFavorito(f);
		c.removeFavorito(f);
		ArrayList<Filme> aux = new ArrayList<Filme>();
		assertArrayEquals(aux.toArray(), c.filmesFavoritos.toArray());
	}

}
