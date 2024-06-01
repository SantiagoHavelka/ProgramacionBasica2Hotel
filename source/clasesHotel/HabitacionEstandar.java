package clasesHotel;

public class HabitacionEstandar extends Habitacion{
	
	public HabitacionEstandar(Integer cantidadDeBanios, Integer cantidadDeCamas, Double precioBase,
			Integer numeroDeHabitacion, Servicio servicio, TiposDeCama tiposDeCama) {
		super(cantidadDeBanios, cantidadDeCamas, precioBase, numeroDeHabitacion, servicio, tiposDeCama);
	}

	@Override
	public Double obtenerPrecio() {
		return this.getPrecioBase();
	}
}
