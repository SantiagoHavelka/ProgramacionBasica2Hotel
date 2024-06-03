package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesHotel.Cliente;
import clasesHotel.Hotel;
import clasesHotel.Servicio;

public class TestHotel {

	private Hotel hotel = new Hotel("El Sueño");
	private Servicio servicio = new Servicio("Shows nocturnos", "Restaurant y desayuno", "Limpieza absoluta");
	@Test
	public void queExistaUnHotel() {
	assertNotNull(this.hotel);
	}

	@Test
	public void queSePuedaRegistrarUnClienteAlHotel() {
	Cliente cliente = new Cliente("Santiago","Aquino", 42675483, 23, 1);
	
	Boolean sePudoRegistrar = this.hotel.registrarCliente(cliente);
	assertTrue(sePudoRegistrar);	
}
	@Test
	public void queHayaUnServicioParaBrindar() {
	assertNotNull(this.servicio);
}
	


}
