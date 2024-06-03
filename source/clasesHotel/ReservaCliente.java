package clasesHotel;

import java.util.List;
import java.util.Objects;

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




	@Override
	public int hashCode() {
		return Objects.hash(acompaniantes, cliente, reserva);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaCliente other = (ReservaCliente) obj;
		return Objects.equals(acompaniantes, other.acompaniantes) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(reserva, other.reserva);
	}
	
	


}
