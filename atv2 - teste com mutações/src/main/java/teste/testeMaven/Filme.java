package teste.testeMaven;

public class Filme {
	protected String nome;
	protected String id;
	protected double valor = 10;
	protected Genero genero;


	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}
}
