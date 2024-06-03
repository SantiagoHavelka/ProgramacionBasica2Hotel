package clasesHotel;

import java.util.List;

public interface HotelInterface {

	Boolean agregarReservaCliente(Cliente cliente, Reserva reserva, List<Cliente> acompaniantes);
	Boolean generarReserva(Reserva reserva);
	Boolean agregarHabitacion(Habitacion habitacionEstandar);
	Boolean registrarCliente(Cliente cliente);

}
