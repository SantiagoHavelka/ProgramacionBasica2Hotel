package clasesHotel;

public class HabitacionEstandar extends Habitacion{
	
	public HabitacionEstandar(Integer cantidadDeBanios, Integer cantidadDeCamas, Double precioBase,
			Integer numeroDeHabitacion, Servicio servicio, TiposDeCama tiposDeCama, Integer capacidadMaximaPersonas) {
		super(cantidadDeBanios, cantidadDeCamas, precioBase, numeroDeHabitacion, servicio, tiposDeCama ,capacidadMaximaPersonas );
	}

	@Override
	public Double saberValor() {
		return this.getPrecioBase();
	}
}
