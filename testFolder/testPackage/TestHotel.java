package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesHotel.Cliente;
import clasesHotel.HabitacionEstandar;
import clasesHotel.Hotel;
import clasesHotel.Servicio;
import clasesHotel.ServicioVip;
import clasesHotel.TiposDeCama;
import clasesHotel.Habitacion;

public class TestHotel {

	private Hotel hotel = new Hotel("El Sueño");
	private Servicio servicio = new Servicio("Shows nocturnos", "Restaurant y desayuno", "Limpieza absoluta");
	private Servicio servicioVip = new ServicioVip("Shows nocturnos", "Restaurant y desayuno", "Limpieza absoluta",
			"spa y masajes", "lavanderia y tintoreria", "transporte");
	private final Double PRECIO_BASE_HABITACION = 2500.0;

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
		assertNotNull(servicioVip);
	}
	
	@Test
	public void queHayaUnaHabitacionEstandarEnElHotel() {
		Habitacion habitacionEstandar = new HabitacionEstandar(2, 1, this.PRECIO_BASE_HABITACION, 36, servicio, TiposDeCama.INDIVIDUAL);
		
		Boolean agregarHabitacion = hotel.agregarHabitacion(habitacionEstandar);
		//falta agregar la clase reserva y hacer el metodo obtenerElPrecioTotalDeUnaReserva.
		assertTrue(agregarHabitacion);
		
	}

}
