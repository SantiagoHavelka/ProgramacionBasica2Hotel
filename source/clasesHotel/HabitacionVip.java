package clasesHotel;

public class HabitacionVip extends Habitacion {
	private AdicionalesVip[] adicionales;
	private Double porcentajeAdicionalPrecio;
	
	public HabitacionVip(Integer numeroHabitacion, Integer cantidadCamas, Double precioBase, Integer cantidadBanios,
			TiposDeCama tipoDeCama, Servicio servicioVip, Integer capacidadMaximaPersonas,  Double porcentajeAdicionalPrecio) {
		super(numeroHabitacion, cantidadCamas, precioBase, cantidadBanios, servicioVip, tipoDeCama, capacidadMaximaPersonas);
		this.porcentajeAdicionalPrecio =  porcentajeAdicionalPrecio;
	}

	@Override
	public Double saberValor() {
		return this.getPrecioBase()+ (this.getPrecioBase()*porcentajeAdicionalPrecio);
	}

	public AdicionalesVip[] obtenerAdicionales() {
		this.adicionales = (AdicionalesVip.values());
		return adicionales;
	}

}
