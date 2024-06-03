package clasesHotel;

public abstract class Habitacion {
	
	private Integer cantidadDeBanios;
	private Integer cantidadDeCamas;
	private Double precioBase;
	private Integer numeroDeHabitacion;
	private Servicio servicio;
	private TiposDeCama tiposDeCama;
	
	public Habitacion(Integer cantidadDeBanios, Integer cantidadDeCamas, Double precioBase, Integer numeroDeHabitacion,
			Servicio servicio, TiposDeCama tiposDeCama) {
		this.cantidadDeBanios = cantidadDeBanios;
		this.cantidadDeCamas = cantidadDeCamas;
		this.precioBase = precioBase;
		this.numeroDeHabitacion = numeroDeHabitacion;
		this.servicio = servicio;
		this.tiposDeCama = tiposDeCama;
	}
	
	public abstract Double obtenerPrecio();

	public Integer getCantidadDeBanios() {
		return cantidadDeBanios;
	}

	public void setCantidadDeBanios(Integer cantidadDeBanios) {
		this.cantidadDeBanios = cantidadDeBanios;
	}

	public Integer getCantidadDeCamas() {
		return cantidadDeCamas;
	}

	public void setCantidadDeCamas(Integer cantidadDeCamas) {
		this.cantidadDeCamas = cantidadDeCamas;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precio) {
		this.precioBase = precio;
	}

	public Integer getNumeroDeHabitacion() {
		return numeroDeHabitacion;
	}

	public void setNumeroDeHabitacion(Integer numeroDeHabitacion) {
		this.numeroDeHabitacion = numeroDeHabitacion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public TiposDeCama getTiposDeCama() {
		return tiposDeCama;
	}

	public void setTiposDeCama(TiposDeCama tiposDeCama) {
		this.tiposDeCama = tiposDeCama;
	}
}

