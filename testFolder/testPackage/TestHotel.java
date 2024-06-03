package testPackage;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import clasesHotel.Cliente;
import clasesHotel.HabitacionEstandar;
import clasesHotel.HabitacionVip;
import clasesHotel.Hotel;
import clasesHotel.Reserva;
import clasesHotel.ReservaCliente;
import clasesHotel.Servicio;
import clasesHotel.ServicioVip;
import clasesHotel.TiposDeCama;
import clasesHotel.Habitacion;
import clasesHotel.HabitacionEconomica;

public class TestHotel {

	private final Double PRECIO_BASE_HABITACION_POR_DIA = 2500.0;
	private Hotel hotel = new Hotel("El Sueño");
	private Servicio servicio = new Servicio("Shows nocturnos", "Restaurant y desayuno", "Limpieza absoluta");
	private Servicio servicioVip = new ServicioVip("Shows nocturnos", "Restaurant y desayuno", "Limpieza absoluta",
			"spa y masajes", "lavanderia y tintoreria", "transporte");
	

	@Test
	public void queExistaUnHotel() {
		assertNotNull(this.hotel);
	}

	@Test
	public void queSePuedaRegistrarUnClienteAlHotel() {
		Cliente cliente = this.crearCliente("Santiago", "Aquino", 42675483, 23, 1);

		Boolean sePudoRegistrar = this.hotel.registrarCliente(cliente);
		assertTrue(sePudoRegistrar);
	}
	
	@Test
	public void queHayaUnServicioParaBrindar() {
	assertNotNull(this.servicio);
	}
	
	@Test
	public void queHayaUnServicioVipParaBrindar() {
		assertNotNull(this.servicioVip);
	}
	
	@Test
	public void queSePuedaAgregarUnaHabitacionEstandarAlHotelConServicio() {
		Habitacion habitacionEstandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		
		Boolean agregarHabitacion = this.hotel.agregarHabitacion(habitacionEstandar);
		assertTrue(agregarHabitacion);	
	}
	
	@Test
	public void queSePuedaGenerarUnaReservaDeNoHaberNingunaEnElHotel() {
		Habitacion habitacion = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		
		Reserva reserva = this.crearReserva(2, habitacion, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		
		Boolean sePuedeGenerar = this.hotel.generarReserva(reserva);
		
		assertTrue(sePuedeGenerar);	
	}	
	
	@Test
	public void queSePuedaAgregarUnaHabitacionVipConServicioVipAlHotel() {
	Double porcentajePrecioASumar = 0.4;
	Habitacion habitacion = this.crearHabitacionVip(66, 4, PRECIO_BASE_HABITACION_POR_DIA, 3, TiposDeCama.KING_SIZE,this.servicioVip, 8, porcentajePrecioASumar);
	
	Boolean sePudoAgregarLaHabitacionVip = this.hotel.agregarHabitacion(habitacion);
	
	assertTrue(sePudoAgregarLaHabitacionVip);
	
	}
	
	@Test
	public void queSePuedaAgregarUnaHabitacionEconomicaConServicioAlHotel() {
		Double porcentajePrecioARestar = 0.3;
		Habitacion habitacion = this.crearHabitacionEconomica(33, 3, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL,this.servicio, 3, porcentajePrecioARestar);
		
		Boolean sePudoAgregarLaHabitacionEconomica = this.hotel.agregarHabitacion(habitacion);
		assertTrue(sePudoAgregarLaHabitacionEconomica);	
	}
	
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionEstandarPorDia() {
		Habitacion habitacion = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		this.hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 2500.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);

	}
	
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionEconomicaPorDia() {
		Double porcentajePrecioARestar = 0.3;
		Habitacion habitacion = this.crearHabitacionEconomica(23, 3, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL,this.servicio , 3, porcentajePrecioARestar);
		
		this.hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 1750.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);
			
	}
	
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionVipPorDia() {
		Double porcentajePrecioASumar = 0.4;
		Habitacion habitacion = this.crearHabitacionVip(66, 4, PRECIO_BASE_HABITACION_POR_DIA, 3, TiposDeCama.KING_SIZE,this.servicioVip, 8, porcentajePrecioASumar);
		
		hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 3500.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);
	}
	
	@Test
	public void queSePuedaAgregarUnaReservaClienteAlHotel() {
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		Reserva reserva = this.crearReserva(2, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));

		Cliente cliente = new Cliente("Julieta", "Bernacchia", 21, 44511167, 1);
		Cliente acompaniante1 = new Cliente("Santiago", "Aquino", 23, 42675483, 2);
		Cliente acompaniante2 = new Cliente("Luca", "Bernacchia", 23, 43309999, 3);
		ArrayList<Cliente> acompaniantes = new ArrayList<>();
		acompaniantes.add(acompaniante1);
		acompaniantes.add(acompaniante2);
			
		ReservaCliente reservaCliente = this.crearReservaCliente(reserva, cliente, acompaniantes);
		
		Boolean sePudoAgregarReservaClienteAlHotel = hotel.agregarReservaCliente(cliente, reserva, acompaniantes);
		
		assertTrue(sePudoAgregarReservaClienteAlHotel);
		assertTrue(hotel.getReservasClientes().contains(reservaCliente));
		assertTrue(reservaCliente.getAcompaniantes().contains(acompaniante1));
		assertTrue(reservaCliente.getAcompaniantes().contains(acompaniante2));
		assertEquals(2, reservaCliente.getAcompaniantes().size());
		
	}
	
	
	
	
	private Reserva crearReserva(Integer id, Habitacion habitacion,LocalDate diaLlegada, 
			LocalDate diaSalida) {
		return new Reserva(id, habitacion, diaLlegada, diaSalida);
	}
	
	private Habitacion crearHabitacionVip(Integer numeroHabitacion, Integer cantidadCamas, Double precioBase, Integer cantidadBanios,
			TiposDeCama tipoDeCama, Servicio servicioVip, Integer capacidadMaximaPersonas,  Double porcentajeAdicionalPrecio) {
		return new HabitacionVip(numeroHabitacion, cantidadCamas, precioBase, cantidadBanios, tipoDeCama, servicioVip, capacidadMaximaPersonas, porcentajeAdicionalPrecio);
	}
	
	private Habitacion crearHabitacionEstandar(Integer numeroHabitacion, Integer cantidadDeCamas, Double precioBase, Integer cantidadBanios, TiposDeCama tiposDeCama, Servicio servicio, Integer capacidadMaximaPersonas) {
		return new HabitacionEstandar(numeroHabitacion, cantidadDeCamas, precioBase, cantidadBanios, tiposDeCama, servicio, capacidadMaximaPersonas);
	}
	
	private Habitacion crearHabitacionEconomica(Integer numeroHabitacion, Integer cantidadCamas, Double precioBase, Integer cantidadBaños,
			TiposDeCama tipoDeCama, Servicio servicio, Integer capacidadMaximaPersonas, Double porcentajePrecioARestar) {
		return new HabitacionEconomica(numeroHabitacion, cantidadCamas, precioBase, cantidadBaños, tipoDeCama, servicio, capacidadMaximaPersonas, porcentajePrecioARestar);
	}
	
	private Cliente crearCliente(String nombre, String apellido, Integer dni, Integer edad, Integer id) {
		return new Cliente(nombre, apellido, dni, edad, id);
	}
	
	private ReservaCliente crearReservaCliente(Reserva reserva, Cliente cliente, List<Cliente> acompaniantes) {
		return new ReservaCliente(reserva, cliente, acompaniantes);
	}

}
