package negocio;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando app Locadora");
		Transacao t = new Transacao();
		t.addDesconto(Genero.ROMANCE, 10);
		Filme f = new Filme("Java muito feliz", Genero.ROMANCE);
		Filme f1 = new Filme("Java 1", Genero.ROMANCE);
		Filme f2 = new Filme("Java 2", Genero.COMEDIA);
		Filme f3 = new Filme("Java 3", Genero.DRAMA);
		Cliente c = new Cliente("Gabriel", 1);
		Cliente c1 = new Cliente("Gabriel2", 2);
		c1.addFavorito(f3);
		c1.printFavorito();
		Locacao l = new Locacao(c, f);
		Locacao l1 = new Locacao(c, f1);
		Locacao l2 = new Locacao(c, f2);
		//Locacao l3 = new Locacao(c1, f3);
		t.addLocacao(l);
		t.addLocacao(l1);
		t.addLocacao(l2);
		//t.addLocacao(l3);
		
		t.printLocacao();
		t.valorLocacaoTotal();
		t.addBulkFilmesLocacao(c1, c1.filmesFavoritos);
		t.valorLocacaoTotal();
		t.generoMaisAlugado();
		System.out.println("FIM app Locadora");
		
	}

}
