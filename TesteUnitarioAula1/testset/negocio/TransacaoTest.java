package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransacaoTest {

	Transacao t;
	Cliente c;
	Cliente c1;
	Filme f;
	Filme f1;
	Filme f2;
	Filme f3;
	
	Locacao l;
	Locacao l1;
	Locacao l2;
	@Before
	public void setUp() throws Exception {
		t = new Transacao();
		f = new Filme("Java muito feliz", Genero.ROMANCE);
		f1 = new Filme("Java 1", Genero.ROMANCE);
		f2 = new Filme("Java 2", Genero.COMEDIA);
		f3 = new Filme("Java 3", Genero.DRAMA);
		c = new Cliente("Gabriel", 1);
		c1 = new Cliente("Gabriel2", 2);
		
		l = new Locacao(c, f);
		l1 = new Locacao(c, f1);
		l2 = new Locacao(c, f2);	
		t.generoMaisAlugado();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void valorLocacaoTotalTest() {
		t.addLocacao(l);	
		assertEquals(10.0, t.valorLocacaoTotal(), 0);
	}
	@Test
	public void addLocacaoTest() {
		t.addLocacao(l);
		t.addLocacao(l1);
		ArrayList<Locacao> alugueis = new ArrayList<Locacao>();
		alugueis.add(l);
		alugueis.add(l1);
		assertArrayEquals(alugueis.toArray(), t.alugueis.toArray());
	}
	@Test
	public void removeLocacaoTest() {
		ArrayList<Locacao> alugueis = new ArrayList<Locacao>();
		t.addLocacao(l);
		t.removeLocacao(l);
		assertArrayEquals(alugueis.toArray(), t.alugueis.toArray());
	}
	@Test
	public void addDescontoTest() {
		t.addDesconto(Genero.ROMANCE, 10);
		assertEquals(10, t.descontoHmap.get(Genero.ROMANCE), 0);
	}
	@Test
	public void removeDescontoTest() {
		t.addDesconto(Genero.ROMANCE, 10);
		t.removeDesconto(Genero.ROMANCE);
		assertEquals(null, t.descontoHmap.get(Genero.ROMANCE));
	}
	
	@Test
	public void generoMaisAlugadoTest() throws Exception {
		Locacao l3 = new Locacao(c1, f3);
		t.addLocacao(l);
		t.addLocacao(l1);
		t.addLocacao(l2);
		t.addLocacao(l3);
		assertEquals(Genero.ROMANCE, t.generoMaisAlugado());
	}
		
	@Test
	public void addBulkFilmesLocacaoTest() throws Exception {
		Locacao l3 = new Locacao(c1, f3);
		ArrayList<Locacao> alugueis = new ArrayList<Locacao>();
		alugueis.add(l3);
		c1.addFavorito(f3);
		t.addBulkFilmesLocacao(c1, c1.filmesFavoritos);
		assertEquals(alugueis.get(0).cliente.nome, t.alugueis.get(0).cliente.nome);
		assertEquals(alugueis.get(0).filme.nome, t.alugueis.get(0).filme.nome);
	}
}
