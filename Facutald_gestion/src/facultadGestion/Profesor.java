package facultadGestion;

public class Profesor {
	
	private String nombre;
	private Integer dni;
	private String apellido;
	
	public Profesor(Integer dni,String apellid, String nombre) {
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		return "Profesor [nombre=" + nombre + ", dni=" + dni + ", apellido=" + apellido + "]";
	}
}
	

	