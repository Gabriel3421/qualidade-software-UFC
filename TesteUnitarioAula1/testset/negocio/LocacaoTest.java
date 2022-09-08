package negocio;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LocacaoTest {
	Cliente c;
	Filme filme;
	
	@Before
	public void setUp() throws Exception {
		this.filme= new Filme("Java", Genero.DRAMA);
		this.c = new Cliente("Gabriel", 1);
		System.out.println("Antes");
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testLocacao() throws Exception {
		Locacao l = new Locacao(this.c, this.filme);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String[] dateAndTime = dtf.format(now).split(" ");
		assertEquals("Gabriel", l.cliente.nome);
		assertEquals("Java", l.filme.nome);
		assertEquals(dateAndTime[0], l.data);
		assertEquals(dateAndTime[1], l.hora);
	}
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	public void testLocacaoInative() throws Exception {
		c.toggleActive();
		Locacao l = new Locacao(this.c, this.filme);
		exceptionRule.expectMessage("Cliente inativo");
	}

}
