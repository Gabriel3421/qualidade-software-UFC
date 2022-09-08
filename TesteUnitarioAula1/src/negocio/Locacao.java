package negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected String data;
	protected String hora;
	
	
	public Locacao(Cliente c, Filme f) throws Exception {
		if(!c.isActive) {
			throw new Exception("Cliente inativo");
		}
		this.cliente = c;
		this.filme = f;

		this.setDateAndTime();
		System.out.println("Aluguel criado!");
	}
	
	private void setDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String[] dateAndTime = dtf.format(now).split(" ");
		this.data = dateAndTime[0];
		this.hora = dateAndTime[1]; 
	}
}
