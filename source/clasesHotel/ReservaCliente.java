package clasesHotel;

import java.util.List;

public class ReservaCliente {
	
	private Reserva reserva;
	private Cliente cliente;
	private List<Cliente> acompaniantes;
	
	public ReservaCliente(Reserva reserva, Cliente cliente, List<Cliente> acompaniantes) {
		this.reserva = reserva;
		this.cliente = cliente;
		this.acompaniantes = acompaniantes;
	}


	public Reserva getReserva() {
		return reserva;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	public List<Cliente> getAcompaniantes() {
		return acompaniantes;
	}


	
	


}
