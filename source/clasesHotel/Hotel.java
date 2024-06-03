package clasesHotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	private String nombre;
	private List<Cliente> clientes;
	private List<Habitacion> habitaciones;
	private List<Reserva>reservas;
	
	public Hotel(String nombre) {
		this.nombre=nombre;
		this.clientes =  new ArrayList<>();
		this.habitaciones = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public Boolean registrarCliente(Cliente cliente) {
			return this.clientes.add(cliente);
	}

	public Boolean agregarHabitacion(Habitacion habitacionEstandar) {
		return this.habitaciones.add(habitacionEstandar);
	}

	public Boolean generarReserva(Reserva reserva) {
		return this.reservas.add(reserva);
	}

}
