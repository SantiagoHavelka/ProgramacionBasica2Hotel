package testPackage;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clasesHotel.AdicionalesVip;
import clasesHotel.Cliente;
import clasesHotel.HabitacionEstandar;
import clasesHotel.HabitacionVip;
import clasesHotel.Hotel;
import clasesHotel.Reserva;
import clasesHotel.ReservaCliente;
import clasesHotel.Servicio;
import clasesHotel.ServicioVip;
import clasesHotel.TiposDeCama;
import clasesHotel.clienteYaRegistradoException;
import clasesHotel.habitacionYaReservadaException;
import clasesHotel.reservaInexistenteException;
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
	public void queSePuedaRegistrarUnClienteAlHotel() throws clienteYaRegistradoException {
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
		
		this.hotel.agregarHabitacion(habitacion);
		Double valorDeHabitacion = habitacion.saberValor();
		Double valorDeHabitacionEsperado = 3500.0;
		
		assertEquals(valorDeHabitacionEsperado, valorDeHabitacion);
	}
	
	@Test
	public void queSePuedaAgregarUnaReservaClienteAlHotel() throws habitacionYaReservadaException, clienteYaRegistradoException {
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, this.servicio, 5);
		Reserva reserva = this.crearReserva(2, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));

		Cliente cliente = this.crearCliente("Julieta", "Bernacchia", 21, 44511167, 1);
		this.hotel.registrarCliente(cliente);
		Cliente acompaniante1 = this.crearCliente("Santiago", "Aquino", 23, 42675483, 2);
		Cliente acompaniante2 =  this.crearCliente("Luca", "Bernacchia", 23, 43309999, 3);
		
		ArrayList<Cliente> acompaniantes = new ArrayList<>();
		acompaniantes.add(acompaniante1);
		acompaniantes.add(acompaniante2);
			
		ReservaCliente reservaCliente = this.crearReservaCliente(reserva, cliente, acompaniantes);
		
		Boolean sePudoAgregarReservaClienteAlHotel = this.hotel.agregarReservaCliente(reservaCliente);
		
		assertTrue(sePudoAgregarReservaClienteAlHotel);
		assertEquals(2, reservaCliente.getAcompaniantes().size());
		
	}
	
	@Test (expected = habitacionYaReservadaException.class)
	public void queUnClienteNoPuedaReservarUnaHabitacionYaReservadaPorOtroClienteEnEsasFechas() throws habitacionYaReservadaException, clienteYaRegistradoException {
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, this.servicio, 5);
		this.hotel.agregarHabitacion(estandar);

		Cliente cliente1 =  this.crearCliente("Julieta", "Bernacchia", 21, 44511167, 1);
		this.hotel.registrarCliente(cliente1);
		
		Reserva reserva1 = this.crearReserva(1, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		Cliente acompaniante1 =  this.crearCliente("Santiago", "Aquino", 23, 42675483, 2);
		Cliente acompaniante2 =  this.crearCliente("Luca", "Bernacchia", 23, 43309999, 3);
		
		ArrayList<Cliente> acompaniantes = new ArrayList<>();
		acompaniantes.add(acompaniante1);
		acompaniantes.add(acompaniante2);
		
		ReservaCliente reservaCliente = this.crearReservaCliente(reserva1, cliente1, acompaniantes);
		this.hotel.agregarReservaCliente(reservaCliente);

		Cliente cliente2 =  this.crearCliente("Pedro", "Gomez", 23, 41675483, 2);
		this.hotel.registrarCliente(cliente2);
		
		Cliente acompaniante1DelCliente2 =  this.crearCliente("Maria", "Gonzalez", 25, 42327456, 3);
		Cliente acompaniante2DelCliente2 =  this.crearCliente("Lucia", "Fernandez", 23, 43128320, 4);
		Reserva reserva2 = this.crearReserva(2, estandar, LocalDate.of(2024, 5, 30), LocalDate.of(2024, 6, 3));
		
		ArrayList<Cliente> acompaniantesDelSegundoCliente = new ArrayList<>();
		acompaniantesDelSegundoCliente.add(acompaniante1DelCliente2);
		acompaniantesDelSegundoCliente.add(acompaniante2DelCliente2);
		
		ReservaCliente reservaCliente2 = this.crearReservaCliente(reserva2, cliente2, acompaniantesDelSegundoCliente);
		this.hotel.agregarReservaCliente(reservaCliente2);

		assertEquals(1, hotel.getReservasClientes().size());
	}
	
	@Test
    public void queUnClientePuedaModificarLosDiasDeSuReserva() throws clienteYaRegistradoException, habitacionYaReservadaException {
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, this.servicio, 5);
        Cliente cliente = this.crearCliente("Julieta", "Bernacchia", 21, 44511167, 1);
        this.hotel.registrarCliente(cliente);
        
        Reserva reserva = this.crearReserva(1, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
        Cliente acompaniante1 = this.crearCliente("Santiago", "Aquino", 23, 4232749, 2);
        Cliente acompaniante2 = this.crearCliente("Luca", "Bernacchia", 23, 43128329, 3);
        
        ArrayList<Cliente> acompaniantes = new ArrayList<>();
        acompaniantes.add(acompaniante1);
        acompaniantes.add(acompaniante2);
        
       ReservaCliente reservaCliente =  this.crearReservaCliente(reserva, cliente, acompaniantes);
       this.hotel.agregarReservaCliente(reservaCliente);

        Boolean sePuedemodificarSuReserva = this.hotel.modificarReservaCliente(reservaCliente,LocalDate.of(2024, 5, 24), LocalDate.of(2024, 5, 29));

        assertTrue(sePuedemodificarSuReserva);
    }
	
	@Test (expected = habitacionYaReservadaException.class)
    public void queUnClienteNoPuedaModificarSusDiasDeLaReservaPorYaEstarOcupadaEsaHabitacionEnEsosDias() throws habitacionYaReservadaException, clienteYaRegistradoException {
		
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);

        Cliente cliente = this.crearCliente("Julieta", "Bernacchia", 21, 44511167, 1);
        this.hotel.registrarCliente(cliente);
        Reserva reserva = this.crearReserva(1, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
        Cliente acompaniante1 = this.crearCliente("Santiago", "Aquino", 23, 4232749, 2);
        Cliente acompaniante2 = this.crearCliente("Luca", "Bernacchia", 23, 43128329, 3);
        
        ArrayList<Cliente> acompaniantes = new ArrayList<>();
        acompaniantes.add(acompaniante1);
        acompaniantes.add(acompaniante2);
        
        ReservaCliente reservaClientes = this.crearReservaCliente(reserva, cliente, acompaniantes);
        this.hotel.agregarReservaCliente(reservaClientes);

        Cliente cliente2 = this.crearCliente("Martin", "de Oro", 23, 43874966, 2);
        this.hotel.registrarCliente(cliente2);
        
        Cliente acompaniante1DelCliente2 = this.crearCliente("Maria", "Gonzalez", 23, 4232745, 3);
        Cliente acompaniante2DelCliente2 = this.crearCliente("Luz", "Lopez", 23, 43128320, 4);
        Reserva reserva2 = this.crearReserva(2, estandar, LocalDate.of(2024, 5, 31), LocalDate.of(2024, 6, 3));
        
        ArrayList<Cliente> acompaniantesDelSegundoCliente = new ArrayList<>();
        acompaniantesDelSegundoCliente.add(acompaniante1DelCliente2);
        acompaniantesDelSegundoCliente.add(acompaniante2DelCliente2);
        
        
        ReservaCliente reservaClientes2 =  this.crearReservaCliente(reserva2, cliente2, acompaniantesDelSegundoCliente);
        this.hotel.agregarReservaCliente(reservaClientes2);

        this.hotel.modificarReservaCliente(reservaClientes2, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 28));

       
    }
	
	@Test
    public void queHayaDosClientesYUnoDeEllosDecidaCancelarSuReservaExitosamente() throws reservaInexistenteException, habitacionYaReservadaException, clienteYaRegistradoException {
		Habitacion estandar = this.crearHabitacionEstandar(36, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		Habitacion estandar2 = this.crearHabitacionEstandar(37, 2, PRECIO_BASE_HABITACION_POR_DIA, 1, TiposDeCama.INDIVIDUAL, servicio, 5);
		
        Reserva reserva = this.crearReserva(1, estandar, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
        Cliente cliente = this.crearCliente("Julieta", "Bernacchia", 21, 44511167, 1);
        this.hotel.registrarCliente(cliente);
        Cliente acompaniante1 = this.crearCliente("Santiago", "Aquino", 23, 4232749, 2);
        Cliente acompaniante2 = this.crearCliente("Luca", "Bernacchia", 23, 43128329, 3);
        
        ArrayList<Cliente> acompaniantes = new ArrayList<>();
        acompaniantes.add(acompaniante1);
        acompaniantes.add(acompaniante2);
        
        ReservaCliente reservaCliente = crearReservaCliente(reserva, cliente, acompaniantes);
        this.hotel.agregarReservaCliente(reservaCliente);
        
        Reserva reserva2 = this.crearReserva(4, estandar2, LocalDate.of(2024, 5, 23) , LocalDate.of(2024, 5, 30));
        Cliente cliente2 = this.crearCliente("Maria", "Gonzalez", 44510908, 21, 5);
        this.hotel.registrarCliente(cliente2);
        
        Cliente acompaniante3 = this.crearCliente("Martin", "De Oro", 43874966 , 22 , 6);
        Cliente acompaniante4 = this.crearCliente("Pedro", "Aquino", 42503455, 23, 7);
        
        ArrayList<Cliente> acompaniantesDelCliente2 = new ArrayList<>();
        acompaniantesDelCliente2.add(acompaniante3);
        acompaniantesDelCliente2.add(acompaniante4);
        
        ReservaCliente reservaCliente2 = this.crearReservaCliente(reserva2, cliente2, acompaniantesDelCliente2);
        this.hotel.agregarReservaCliente(reservaCliente2);

        Boolean sePuedeCancelar = this.hotel.cancelarReservaClientes(reservaCliente);

        assertTrue(sePuedeCancelar);
        assertEquals(1, hotel.getReservasClientes().size());
    }
	@Test
	public void queSePuedaObtenerElPrecioTotalDeUnaReservaClientePorLaCantidadDeDiasDeSuEstadia() throws clienteYaRegistradoException, habitacionYaReservadaException{
		Habitacion habitacion = this.crearHabitacionEstandar(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2,  TiposDeCama.INDIVIDUAL,this.servicio , 5);
		this.hotel.agregarHabitacion(habitacion);
		
		Reserva reserva = this.crearReserva(2, habitacion, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		this.hotel.generarReserva(reserva);
		
		Cliente cliente =  this.crearCliente("Santiago","Aquino", 42675483, 23, 1);
		Cliente cliente2 =  this.crearCliente("Juan","Perez", 42672223, 22, 2);
		Cliente cliente3 =  this.crearCliente("Lucas","Aquino", 41565483, 33, 3);
		this.hotel.registrarCliente(cliente);
		
		List<Cliente>acompaniantes = new ArrayList<>();
		acompaniantes.add(cliente2);
		acompaniantes.add(cliente3);
		
		ReservaCliente reservaClientes = this.crearReservaCliente(reserva, cliente, acompaniantes);
		this.hotel.agregarReservaCliente(reservaClientes);
		
		Double precioTotalReserva = this.hotel.obtenerPrecioTotalReserva(reservaClientes);
		Double precioEsperado = 20000.0;
		
		assertEquals(precioEsperado,precioTotalReserva );
	}
	@Test
	public void queSePuedaObtenerElPrecioTotalDeUnaReservaClienteDeHabitacionVip() throws clienteYaRegistradoException, habitacionYaReservadaException{
		Double porcentajePrecioASumar = 0.4;
		Habitacion habitacion = this.crearHabitacionVip(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2, TiposDeCama.KING_SIZE,this.servicioVip , 5, porcentajePrecioASumar);
		this.hotel.agregarHabitacion(habitacion);
		
		Reserva reserva = this.crearReserva(2, habitacion, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		this.hotel.generarReserva(reserva);
		
		Cliente cliente = this.crearCliente("Santiago","Aquino", 42675483, 23, 1);
		Cliente cliente2 = this.crearCliente("Juan","Perez", 42672223, 22, 2);
		Cliente cliente3 =  this.crearCliente("Lucas","Aquino", 41565483, 33, 3);
		this.hotel.registrarCliente(cliente);
		
		List<Cliente>acompañantes = new ArrayList<>();
		acompañantes.add(cliente2);
		acompañantes.add(cliente3);
		
		ReservaCliente reservaClientes = this.crearReservaCliente(reserva,cliente, acompañantes);
		this.hotel.agregarReservaCliente(reservaClientes);
		
		Double precioTotalReserva = this.hotel.obtenerPrecioTotalReserva(reservaClientes);
		Double precioEsperado = 28000.0;
		
		assertEquals(precioEsperado,precioTotalReserva );
	}
	@Test
	public void queSePuedaSaberCuantosAdicionalesTieneUnaHabitacionVip(){
		Double porcentajePrecioASumar = 0.4;
		HabitacionVip habitacion = (HabitacionVip) this.crearHabitacionVip(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2, TiposDeCama.KING_SIZE,this.servicioVip , 5, porcentajePrecioASumar);
		this.hotel.agregarHabitacion(habitacion);
		
		AdicionalesVip[]adicionalesVip = habitacion.obtenerAdicionales();
		int cantidadAdicionalesEsperada = 5;
		
		assertEquals(cantidadAdicionalesEsperada, adicionalesVip.length);
	}
	@Test (expected = clienteYaRegistradoException.class)
	public void queNoSePuedaRegistrarUnIndividuoYaRegistradoEnElHotel() throws clienteYaRegistradoException{
		
		Cliente cliente = this.crearCliente("Santiago","Aquino", 42675483, 23, 1);
		Cliente cliente2 = this.crearCliente("Santiago","Aquino", 42675483, 23, 1);
		
		this.hotel.registrarCliente(cliente);
	    this.hotel.registrarCliente(cliente2);
			
	}
	@Test (expected = reservaInexistenteException.class)
	public void queNoSePuedaCancelarUnaReservaClientePorSerInexistente() throws clienteYaRegistradoException, habitacionYaReservadaException, reservaInexistenteException {
		Habitacion habitacion = this.crearHabitacionEstandar(33, 5, PRECIO_BASE_HABITACION_POR_DIA, 2, TiposDeCama.DOBLE,this.servicio , 5);
		this.hotel.agregarHabitacion(habitacion);
		
		Reserva reserva = this.crearReserva(2, habitacion, LocalDate.of(2024, 5, 22), LocalDate.of(2024, 5, 30));
		this.hotel.generarReserva(reserva);
		
		Cliente cliente = this.crearCliente("Santiago","Aquino", 42675483, 23, 1);
		Cliente cliente2 = this.crearCliente("Juan","Perez", 42672223, 22, 2);
		Cliente cliente3 = this.crearCliente("Lucas","Aquino", 41565483, 33, 3);
		this.hotel.registrarCliente(cliente);
		
		List<Cliente>acompañantes = new ArrayList<>();
		acompañantes.add(cliente2);
		acompañantes.add(cliente3);
		
		ReservaCliente reservaClientes = this.crearReservaCliente(reserva, cliente, acompañantes);
		this.hotel.cancelarReservaClientes(reservaClientes);
		
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
