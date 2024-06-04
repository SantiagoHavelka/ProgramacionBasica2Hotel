package clasesHotel;

import java.util.Objects;

public class Cliente {
	

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer edad;
	private Integer id;

	public Cliente(String nombre, String apellido, Integer dni, Integer edad, Integer id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.id= id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, edad, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(dni, other.dni)
				&& Objects.equals(edad, other.edad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}
	

	
	
	
	

	

}
