package clasesHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Hotel implements HotelInterface {
	
	private String nombre;
	private List<Cliente> clientes;
	private List<Habitacion> habitaciones;
	private List<Reserva>reservas;
	private List<ReservaCliente> reservasClientes;
	
	public Hotel(String nombre) {
		this.nombre=nombre;
		this.clientes =  new ArrayList<>();
		this.habitaciones = new ArrayList<>();
		this.reservas = new ArrayList<>();
		this.reservasClientes = new ArrayList<>();
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
	
	
	public Boolean agregarReservaCliente(Cliente cliente, Reserva reserva, List<Cliente> acompaniantes) {
		LocalDate fechaLlegada = reserva.getDiaLlegada();
		LocalDate fechaSalida = reserva.getDiaSalida();

		for (ReservaCliente rc : this.reservasClientes) {
			if (rc.getReserva().getHabitacion().getNumeroHabitacion()
					.equals(reserva.getHabitacion().getNumeroHabitacion())
					&& fechaLlegada.isBefore(rc.getReserva().getDiaSalida())
					&& fechaSalida.isAfter(rc.getReserva().getDiaLlegada()) || fechaLlegada.equals(rc.getReserva().getDiaSalida())
	                || fechaSalida.equals(rc.getReserva().getDiaLlegada())) {
				return false;
			}
		}

		ReservaCliente reservaCliente = new ReservaCliente(reserva, cliente, acompaniantes);
		return this.reservasClientes.add(reservaCliente);
	}

	public List<ReservaCliente> getReservasClientes() {
		return reservasClientes;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	
	
	

}
