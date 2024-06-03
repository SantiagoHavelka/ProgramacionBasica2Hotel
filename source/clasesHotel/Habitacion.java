package clasesHotel;

import java.util.Objects;

public abstract class Habitacion {
	
	private Integer cantidadDeBanios;
	private Integer cantidadDeCamas;
	private Double precioBase;
	private Integer numeroDeHabitacion;
	private Servicio servicio;
	private TiposDeCama tiposDeCama;
	private Integer capacidadMaximaPersonas;
	
	public Habitacion(Integer cantidadDeBanios, Integer cantidadDeCamas, Double precioBase, Integer numeroDeHabitacion,
			Servicio servicio, TiposDeCama tiposDeCama, Integer capacidadMaximaPersonas) {
		this.cantidadDeBanios = cantidadDeBanios;
		this.cantidadDeCamas = cantidadDeCamas;
		this.precioBase = precioBase;
		this.numeroDeHabitacion = numeroDeHabitacion;
		this.servicio = servicio;
		this.tiposDeCama = tiposDeCama;
		this.capacidadMaximaPersonas = capacidadMaximaPersonas;
	}
	
	public Double getPrecioBase() {
		return precioBase;
	}

	public abstract Double saberValor();
		
	

	public Integer getNumeroHabitacion() {
		return numeroDeHabitacion;
	}


	public Integer getCapacidadMaximaPersonas() {
		return capacidadMaximaPersonas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadDeBanios, cantidadDeCamas, capacidadMaximaPersonas, numeroDeHabitacion, precioBase,
				servicio, tiposDeCama);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		return Objects.equals(cantidadDeBanios, other.cantidadDeBanios)
				&& Objects.equals(cantidadDeCamas, other.cantidadDeCamas)
				&& Objects.equals(capacidadMaximaPersonas, other.capacidadMaximaPersonas)
				&& Objects.equals(numeroDeHabitacion, other.numeroDeHabitacion)
				&& Objects.equals(precioBase, other.precioBase) && Objects.equals(servicio, other.servicio)
				&& tiposDeCama == other.tiposDeCama;
	}
	


}

