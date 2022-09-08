package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	protected HashMap<Genero, Integer> descontoHmap = new HashMap<Genero, Integer>();
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			if(descontoHmap.get(locacao.filme.genero) != null) {
				valor +=locacao.filme.valor - (locacao.filme.valor * descontoHmap.get(locacao.filme.genero) / 100);
			}else {
				valor +=locacao.filme.valor;
			}
			
		}
		System.out.println(valor);
		return valor;
	}
	
	public void addLocacao(Locacao l) {
		this.alugueis.add(l);
	}
	public void addBulkFilmesLocacao(Cliente c, ArrayList<Filme> f) throws Exception {
		for(Filme filme : f){
			Locacao aux = new Locacao(c, filme);
			this.alugueis.add(aux);
		}
	}
	public void removeLocacao(Locacao l) {
		ArrayList<Locacao> aux = new ArrayList<Locacao>();
		this.alugueis.forEach(l1 -> {
			if(l1.cliente.nome != l.cliente.nome & l1.filme.nome != l.filme.nome) {
				aux.add(l1);
			}
		});
		this.alugueis = aux;
	}
	
	public void printLocacao() {
		this.alugueis.forEach(l -> {
			System.out.println(l.cliente.nome + " " + l.filme.nome);
		});
	}
	
	public Genero generoMaisAlugado() {
		Genero maiorGenero = null;
		int maiorAluguel = Integer.MIN_VALUE;
		HashMap<Genero, Integer> hmap = new HashMap<Genero, Integer>();
		int count;    
		for(Locacao aluguel : this.alugueis){
			if(hmap.get(aluguel.filme.genero)==null){
		         hmap.put(aluguel.filme.genero,1);
		       }else{
		         count=hmap.get(aluguel.filme.genero);
		         count++;
		         hmap.put(aluguel.filme.genero,count);
		       }
		}
		for (Map.Entry<Genero, Integer> entry : hmap.entrySet()) {
			Genero key = entry.getKey();
			Integer value = entry.getValue();
			if(value > maiorAluguel) {
				maiorAluguel = value;
				maiorGenero = key;
			}
		}
		System.out.println(maiorGenero);
		return maiorGenero;
	}

	public void addDesconto(Genero g, int desconto) {
		if(desconto > 0 & desconto <= 100) {
			descontoHmap.put(g, desconto);	
		}else {
			System.out.println("valor de desconto inválido");
		}
		
	}
	public void removeDesconto(Genero g) {
		descontoHmap.remove(g);			
	}
}
