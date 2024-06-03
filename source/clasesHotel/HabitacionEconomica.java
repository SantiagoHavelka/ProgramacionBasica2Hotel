package clasesHotel;

public class HabitacionEconomica extends Habitacion {

	private Double porcentajeDePrecioARestar;
	public HabitacionEconomica(Integer numeroHabitacion, Integer cantidadCamas, Double precioBase, Integer cantidadBaños,
			TiposDeCama tipoDeCama, Servicio servicio, Integer capacidadMaximaPersonas, Double porcentajePrecioARestar) {
		super(numeroHabitacion, cantidadCamas, precioBase, cantidadBaños, servicio, tipoDeCama, capacidadMaximaPersonas);{
			this.porcentajeDePrecioARestar = porcentajePrecioARestar;
		}

}
	@Override
	public Double saberValor() {	
		return this.getPrecioBase() - (this.getPrecioBase()*porcentajeDePrecioARestar);
	}

}
