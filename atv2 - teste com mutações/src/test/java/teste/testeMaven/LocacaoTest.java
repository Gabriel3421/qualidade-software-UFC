package teste.testeMaven;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String[] dateAndTime = formatter.format(date).split(" ");
		assertEquals("Gabriel", l.cliente.nome);
		assertEquals("Java", l.filme.nome);
		assertEquals(dateAndTime[0], l.data);
		assertEquals(dateAndTime[1], l.hora);
	}
//	@Rule
//	public ExpectedException exceptionRule = ExpectedException.none();
//	@Test
//	public void testLocacaoInative() throws Exception {
//		c.toggleActive();
//		exceptionRule.expectMessage("Cliente inativo");
//		new Locacao(this.c, this.filme);
//	}

}
