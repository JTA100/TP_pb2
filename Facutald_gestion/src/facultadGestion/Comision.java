package facultadGestion;

import java.util.ArrayList;

public class Comision {

	private Integer id;
	private Integer cantidadDeAlumnos;
	private Integer cantidadDeProfesores;
	private Alumno alumno;
	private Materia materia;
	private Double horarioDeEntrada;
	private Double horarioDeSalida;
	private Aula aula;
	private ArrayList<Nota>guardarNotas;
	private ArrayList<Profesor>profesores;
	private CicloElectivo cicloElectivo;


	public Comision( Integer cantidadDeAlumno, Alumno alumno, Materia materia,
			Double horarioDeEntrada, Double horarioDeSalida, CicloElectivo cicloElectivo) {
		this.id = 0;
		incrementarElIdentificador();
		this.cantidadDeAlumnos = cantidadDeAlumno;
		this.alumno = alumno;
		this.materia = materia;
		this.horarioDeEntrada = horarioDeEntrada;
		this.horarioDeSalida  = horarioDeSalida;
		this.guardarNotas = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cicloElectivo = cicloElectivo;
		this.aula = null; // La universidad se lo asigna
	}
	
                public void agregarProfesor(Profesor profesor) {		
		this.profesores.add(profesor);
	}

	public boolean verificarCantidadP() {				
		if(this.profesores.size() == (this.cantidadDeAlumnos/20)) {
			return true;
		}			
		return false;
		
	}













                @Override
	public String toString() {
		return "Comision [id=" + id + ", cantidadDeAlumnos=" + cantidadDeAlumnos + ", cantidadDeProfesores="
				+ cantidadDeProfesores + ", alumno=" + alumno + ", materia=" + materia + ", horarioDeEntrada="
				+ horarioDeEntrada + ", horarioDeSalida=" + horarioDeSalida + ", guardarNotas=" + guardarNotas + "]";
	}