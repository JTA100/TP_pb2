package facultadGestion;

public class Profesor {
	
	private String nombre;
	private Integer dni;
	
	
	public Profesor(Integer dni, String nombre) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", dni=" + dni + "]";
	}
}
	

	