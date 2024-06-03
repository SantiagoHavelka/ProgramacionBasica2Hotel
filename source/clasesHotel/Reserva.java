package clasesHotel;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {

	private Integer id;
	private Habitacion habitacion;
	private LocalDate diaLlegada;
	private LocalDate diaSalida;

	public Reserva(Integer id, Habitacion habitacion,LocalDate diaLlegada, 
			LocalDate diaSalida) {
		this.id = id;
		this.habitacion = habitacion;
		this.diaLlegada = diaLlegada;
		this.diaSalida = diaSalida;
		
	}
	

	public LocalDate getDiaLlegada() {
		return diaLlegada;
	}


	public void setDiaLlegada(LocalDate diaLlegada) {
		this.diaLlegada = diaLlegada;
	}


	public LocalDate getDiaSalida() {
		return diaSalida;
	}


	public void setDiaSalida(LocalDate diaSalida) {
		this.diaSalida = diaSalida;
	}


	public Integer getId() {
		return id;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash( diaLlegada, diaSalida, habitacion, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return 
				 Objects.equals(diaLlegada, other.diaLlegada) && Objects.equals(diaSalida, other.diaSalida)
				&& Objects.equals(habitacion, other.habitacion) && Objects.equals(id, other.id);
	}
	

}
