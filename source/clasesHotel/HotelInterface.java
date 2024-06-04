package clasesHotel;

import java.time.LocalDate;
import java.util.List;

public interface HotelInterface {

	Boolean agregarReservaCliente(ReservaCliente reservaClientes) throws habitacionYaReservadaException;
	Boolean generarReserva(Reserva reserva);
	Boolean agregarHabitacion(Habitacion habitacionEstandar);
	Boolean registrarCliente(Cliente cliente) throws clienteYaRegistradoException;
	List<ReservaCliente> getReservasClientes();
	List<Habitacion> getHabitaciones();
	ReservaCliente buscarReservaClientes(ReservaCliente reservaClientes);
	Boolean cancelarReservaClientes(ReservaCliente reservaClientes) throws reservaInexistenteException;
	Boolean modificarReservaCliente(ReservaCliente reservaClientes, LocalDate diaDeLlegada, LocalDate diaDeSalida)
			throws habitacionYaReservadaException;
	Double obtenerPrecioTotalReserva(ReservaCliente reservaClientes);
}
