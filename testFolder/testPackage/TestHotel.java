package testPackage;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import clasesHotel.Cliente;
import clasesHotel.HabitacionEstandar;
import clasesHotel.HabitacionVip;
import clasesHotel.Hotel;
import clasesHotel.Reserva;
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
		Cliente cliente = new Cliente("Santiago", "Aquino", 42675483, 23, 1);

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
		Habitacion habitacionEstandar = new HabitacionEstandar(2, 1, this.PRECIO_BASE_HABITACION_POR_DIA, 36, this.servicio, TiposDeCama.INDIVIDUAL, 5);
		
		Boolean agregarHabitacion = this.hotel.agregarHabitacion(habitacionEstandar);
		assertTrue(agregarHabitacion);	
	}
	@Test
	public void queSePuedaGenerarUnaReservaDeNoHaberNingunaEnElHotel() {
		Habitacion habitacion = new HabitacionEstandar(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2,this.servicio,TiposDeCama.INDIVIDUAL, 5);
		
		Reserva reserva = new Reserva(2, habitacion, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		
		Boolean sePuedeGenerar = this.hotel.generarReserva(reserva);
		
		assertTrue(sePuedeGenerar);	
	}	
	@Test
	public void queSePuedaAgregarUnaHabitacionVipConServicioVipAlHotel() {
	Double porcentajePrecioASumar = 0.4;
	Habitacion habitacion = new HabitacionVip(66, 4, PRECIO_BASE_HABITACION_POR_DIA, 3, TiposDeCama.KING_SIZE,this.servicioVip, 8, porcentajePrecioASumar );
	
	Boolean sePudoAgregarLaHabitacionVip = this.hotel.agregarHabitacion(habitacion);
	
	assertTrue(sePudoAgregarLaHabitacionVip);
	
	}
	@Test
	public void queSePuedaAgregarUnaHabitacionEconomicaConServicioAlHotel() {
		Double porcentajePrecioARestar = 0.3;
		Habitacion habitacion = new HabitacionEconomica(33, 3, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL,this.servicio, 3, porcentajePrecioARestar);
		
		Boolean sePudoAgregarLaHabitacionEconomica = this.hotel.agregarHabitacion(habitacion);
		assertTrue(sePudoAgregarLaHabitacionEconomica);	
	}
	
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionEstandarPorDia() {
		Habitacion habitacion = new HabitacionEstandar(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2,this.servicio , TiposDeCama.INDIVIDUAL, 5);
		this.hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 2500.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);

	}
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionEconomicaPorDia() {
		Double porcentajePrecioARestar = 0.3;
		Habitacion habitacion = new HabitacionEconomica(23, 3, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL,this.servicio , 3, porcentajePrecioARestar);
		
		this.hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 1750.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);
			
	}
	@Test
	public void queSePuedaSaberElValorDeUnaHabitacionVipPorDia() {
		Double porcentajePrecioASumar = 0.4;
		Habitacion habitacion = new HabitacionVip(66, 4, PRECIO_BASE_HABITACION_POR_DIA, 3, TiposDeCama.KING_SIZE,this.servicioVip, 8, porcentajePrecioASumar );
		
		hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 3500.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);
	}

}
