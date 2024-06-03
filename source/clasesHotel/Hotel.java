package clasesHotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	private String nombre;
	private List<Cliente> clientes;
	private List<Habitacion> habitaciones;
	
	public Hotel(String nombre) {
		this.nombre=nombre;
		this.clientes =  new ArrayList<>();
	}

	public Boolean registrarCliente(Cliente cliente) {
			return this.clientes.add(cliente);
	}

	public Boolean agregarHabitacion(Habitacion habitacionEstandar) {
		return this.habitaciones.add(habitacionEstandar);
	}

}
