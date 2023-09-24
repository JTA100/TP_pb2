package facultadGestion;

import java.util.ArrayList;


public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Aula> aulas;



	
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();

	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public boolean agregarAlumno(Alumno alumno) {
	    if (!validarDniAlumno(alumno.getDni())) {
	        this.alumnos.add(alumno);
	        return true;
	    }
	    return false;
	}
		       
	private boolean validarDniAlumno(int dni) {
	    for (Alumno a : this.alumnos) {
	        if (a.getDni() == dni) {
	    		return true;
	        }
	    }
	    return false;
	}
		           

	//Test Aula
			public void agregarAula(Aula aula) {
				this.aulas.add(aula);
				
			}

			public Aula obtenerAulaPorNumero(Integer numeroDeAula) {
				// TODO Auto-generated method stub
				return null;
			}

			public Integer obtenerCantidadAulas() {
				// TODO Auto-generated method stub
				return null;
			}

			
			
	
}
