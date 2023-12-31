package facultadGestion;

import java.util.ArrayList;



public class Alumno {
	private String nombre;
	private String apellido;
	private Integer dni;
	private ArrayList<Materia> materiasAprobadas;

	public Alumno(Integer dni, String apellido, String nombre) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.materiasAprobadas = new ArrayList<Materia>();

	}
	
	
	public String  getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 public void aprobarMateria(Materia materia) {
	        this.materiasAprobadas.add(materia);
	    }
	 
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

}
