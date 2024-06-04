package clasesHotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
	public Boolean registrarCliente(Cliente cliente) throws clienteYaRegistradoException {
		Boolean sePudoRegistrar = false;
			for(Cliente clientes : this.clientes) {
				if(clientes.getId().equals(cliente.getId())) {
					throw new clienteYaRegistradoException("El cliente ya esta registrado");
				}
			}
			sePudoRegistrar = this.clientes.add(cliente);
			return sePudoRegistrar;		
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
	public Boolean agregarReservaCliente(ReservaCliente reservaClientes) throws habitacionYaReservadaException {
		Boolean sePudoAgregar = false;
		for(ReservaCliente rc : this.reservasClientes) {
				if(rc.getReserva().getHabitacion().getNumeroHabitacion().equals(reservaClientes.getReserva().getHabitacion().getNumeroHabitacion())
						&& rc.getReserva().getDiaLlegada().isBefore(reservaClientes.getReserva().getDiaSalida()) &&
						rc.getReserva().getDiaSalida().isAfter(reservaClientes.getReserva().getDiaLlegada())
						|| rc.getReserva().getDiaLlegada().equals(reservaClientes.getReserva().getDiaSalida())
						|| rc.getReserva().getDiaSalida().equals(reservaClientes.getReserva().getDiaLlegada())) {
					throw new habitacionYaReservadaException("La habitacion ya esta reservada en esa fecha");
				}
		}
		 sePudoAgregar = this.reservasClientes.add(reservaClientes);
		return sePudoAgregar;
	}
	
	@Override
	public Boolean modificarReservaCliente(ReservaCliente reservaClientes, LocalDate diaDeLlegada, LocalDate diaDeSalida) throws habitacionYaReservadaException {
		Boolean sePudoModificar = false;
		for(ReservaCliente reservaAModificar: this.reservasClientes) {
			if(!reservaAModificar.equals(reservaClientes) &&
					reservaAModificar.getReserva().getHabitacion().getNumeroHabitacion().equals(reservaClientes.getReserva().getHabitacion().getNumeroHabitacion())
					&& diaDeLlegada.isBefore(reservaAModificar.getReserva().getDiaSalida()) &&
					diaDeSalida.isAfter(reservaAModificar.getReserva().getDiaLlegada())
					|| diaDeLlegada.equals(reservaAModificar.getReserva().getDiaSalida())
					|| diaDeSalida.equals(reservaAModificar.getReserva().getDiaLlegada())) {
				throw new habitacionYaReservadaException("La habitacion ya esta reservada en esa fecha");
			}
		}
		reservaClientes.getReserva().setDiaLlegada(diaDeLlegada);
		reservaClientes.getReserva().setDiaSalida(diaDeSalida);
		sePudoModificar = true;
		return sePudoModificar;
	}
	
	@Override
    public Boolean cancelarReservaClientes(ReservaCliente reservaClientes) throws reservaInexistenteException {
	Boolean sePudoCancelar = false;
		
	ReservaCliente reservaACancelar = this.buscarReservaClientes(reservaClientes);
		if(reservaACancelar == null) {
			throw new reservaInexistenteException("La reserva no existe");
		}
	      sePudoCancelar = this.reservasClientes.remove(reservaACancelar);
	      return sePudoCancelar;
		
		}
	@Override
	public ReservaCliente buscarReservaClientes(ReservaCliente reservaClientes) {
		ReservaCliente buscada = null;
		for(ReservaCliente rc: this.reservasClientes) {
			if(rc.equals(reservaClientes)) {
				buscada = rc;
			}
		}
		return buscada;
	}
	@Override
	public Double obtenerPrecioTotalReserva(ReservaCliente reservaClientes) {
		Double precioTotalReserva = 0.0;
		for(ReservaCliente rc : this.reservasClientes) {
			if(rc.equals(reservaClientes)) {
			Long cantidadDeDias = ChronoUnit.DAYS.between(rc.getReserva().getDiaLlegada(), rc.getReserva().getDiaSalida());
			precioTotalReserva =rc.getReserva().getHabitacion().saberValor() * cantidadDeDias;
			}
		}
		return precioTotalReserva;
	}
	@Override
	public List<ReservaCliente> getReservasClientes() {
		return this.reservasClientes;
	}
	
	@Override
	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
}
