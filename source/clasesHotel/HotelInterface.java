package clasesHotel;

import java.time.LocalDate;
import java.util.List;

public interface HotelInterface {

	Boolean agregarReservaCliente(Cliente cliente, Reserva reserva, List<Cliente> acompaniantes);
	Boolean generarReserva(Reserva reserva);
	Boolean agregarHabitacion(Habitacion habitacionEstandar);
	Boolean registrarCliente(Cliente cliente);
	Boolean modificarReserva(Reserva reserva, LocalDate nuevaFechaLlegada, LocalDate nuevaFechaSalida);
	List<ReservaCliente> getReservasClientes();
	List<Habitacion> getHabitaciones();
	Boolean cancelarReserva(Cliente cliente, Reserva reserva, List<Cliente> acompaniantes);
}
