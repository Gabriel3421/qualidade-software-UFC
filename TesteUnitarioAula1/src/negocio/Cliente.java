package negocio;

import java.util.ArrayList;

public class Cliente {

	protected String nome;
	protected int id;
	protected boolean isActive = true;
	protected  ArrayList<Filme> filmesFavoritos = new ArrayList<Filme>();
	
	public Cliente(String nome, int id) {
		this.nome= nome;
		this.id= id;
	}
	public void toggleActive() {
		this.isActive = !this.isActive;
	}
	
	public void addFavorito(Filme f) {
		this.filmesFavoritos.add(f);
	}
	public void removeFavorito(Filme f) {
		ArrayList<Filme> aux = new ArrayList<Filme>();
		this.filmesFavoritos.forEach(f1 -> {
			if(f1.nome != f.nome) {
				aux.add(f1);
			}
		});
		this.filmesFavoritos = aux;
	}
	
	public void printFavorito() {
		this.filmesFavoritos.forEach(f1 -> {
			System.out.println(f1.nome);
		});
	}
	
}
