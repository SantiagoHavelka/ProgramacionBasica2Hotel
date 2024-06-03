package clasesHotel;

public class HabitacionEstandar extends Habitacion{
	
	public HabitacionEstandar(Integer numeroDeHabitacion, Integer cantidadDeCamas, Double precioBase, Integer cantidadDeBanios, TiposDeCama tiposDeCama, Servicio servicio, Integer capacidadMaximaPersonas) {
		super(cantidadDeBanios, cantidadDeCamas, precioBase, numeroDeHabitacion, servicio, tiposDeCama ,capacidadMaximaPersonas );
	}

	@Override
	public Double saberValor() {
		return this.getPrecioBase();
	}
}
