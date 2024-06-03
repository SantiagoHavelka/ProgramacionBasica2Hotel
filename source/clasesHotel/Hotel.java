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
	
	@Override
	public Boolean registrarCliente(Cliente cliente) {
			return this.clientes.add(cliente);
	}
	
	@Override
	public Boolean agregarHabitacion(Habitacion habitacionEstandar) {
		return this.habitaciones.add(habitacionEstandar);
	}
	
	@Override
	public Boolean generarReserva(Reserva reserva) {
		return this.reservas.add(reserva);
	}
	
	@Override
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
	
	@Override
    public Boolean modificarReserva(Reserva reserva, LocalDate nuevaFechaLlegada, LocalDate nuevaFechaSalida) {


         for (ReservaCliente rc : reservasClientes) {
                if (!rc.getReserva().equals(reserva) &&
                    rc.getReserva().getHabitacion().equals(reserva.getHabitacion()) &&
                    (nuevaFechaLlegada.isBefore(rc.getReserva().getDiaSalida()) &&
                     nuevaFechaSalida.isAfter(rc.getReserva().getDiaLlegada()))) {
                    return false; 
                }
            }

            reserva.setDiaLlegada(nuevaFechaLlegada);
            reserva.setDiaSalida(nuevaFechaSalida);
            return true;
    }
	
	@Override
    public Boolean cancelarReserva(Cliente cliente, Reserva reserva, ArrayList<Cliente> acompaniantes) {

        for (ReservaCliente rc : this.reservasClientes) {
            if (rc.getCliente().getId().equals(cliente.getId())
                    && rc.getReserva().getId().equals(reserva.getId())
                    && rc.getAcompaniantes().equals(acompaniantes)) {
                ReservaCliente reservaCliente = new ReservaCliente(reserva, cliente, acompaniantes);
                this.reservasClientes.remove(reservaCliente);
                return true;
            }
        }
        return false;

    }
	
	@Override
	public List<ReservaCliente> getReservasClientes() {
		return reservasClientes;
	}
	
	@Override
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	
	
	

}
