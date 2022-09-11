package teste.testeMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected String data;
	protected String hora;
	protected String hash;
	
	public Locacao(Cliente c, Filme f) throws Exception {
		if(!c.isActive) {
			throw new Exception("Cliente inativo");
		}
		this.cliente = c;
		this.filme = f;

		this.setDateAndTime();
		this.hash = cliente.nome+filme.nome+data+hora;
		System.out.println("Aluguel criado!");
	}
	
	private void setDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String[] dateAndTime = formatter.format(date).split(" ");
		this.data = dateAndTime[0];
		this.hora = dateAndTime[1]; 
	}
}
