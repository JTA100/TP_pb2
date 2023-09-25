package facultadGestion;

import java.util.ArrayList;

public class Comision {

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
	private static Integer id=0;


	public Comision( Integer cantidadDeAlumno, Alumno alumno, Materia materia,
			Double horarioDeEntrada, Double horarioDeSalida, CicloElectivo cicloElectivo) {
		this.cantidadDeAlumnos = cantidadDeAlumno;
		this.alumno = alumno;
		this.materia = materia;
		this.horarioDeEntrada = horarioDeEntrada;
		this.horarioDeSalida  = horarioDeSalida;
		this.guardarNotas = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cicloElectivo = cicloElectivo;
		this.aula = null; // La universidad se lo asigna
		incrementarElIdentificador();
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
	

private void incrementarElIdentificador(){
		id++;
	}


//Y borrar este metodo, esta de mas :

public void setId(Integer id) {
		id = id;
	}


public boolean validarNota(Nota parcial1, Nota parcial2,AsignacionCursoAlumno asignacionCursoAlumno,Curso curso) {
		ArrayList<Curso> cursos = asignacionCursoAlumno.getCursos();
		for(int i = 0; i < cursos.size();i++)
		if(curso != null && cursos.get(i).equals(curso))
		if(asignacionCursoAlumno.promociona(parcial1, parcial2, alumno, curso)) {
			this.guardarNotas.add(parcial1);
			this.guardarNotas.add(parcial2);
			return true;
		}
		return false;
	}

	public boolean validarNotaFinal(Nota finals, AsignacionCursoAlumno asignacionCursoAlumno, Curso curso) {
		ArrayList<Curso> cursos = asignacionCursoAlumno.getCursos();
		for(int i = 0; i < cursos.size();i++)
		if(curso != null && cursos.get(i).equals(curso))
		if(asignacionCursoAlumno.notaFinalSiAprobo(finals, alumno, curso)) {
			this.guardarNotas.add(finals);
			return true;
		}
		return false;
	}








	
	@Override
    public int hashCode() {
        return id.hashCode();
    }






                @Override
	public String toString() {
		return "Comision [id=" + id + ", cantidadDeAlumnos=" + cantidadDeAlumnos + ", cantidadDeProfesores="
				+ cantidadDeProfesores + ", alumno=" + alumno + ", materia=" + materia + ", horarioDeEntrada="
				+ horarioDeEntrada + ", horarioDeSalida=" + horarioDeSalida + ", guardarNotas=" + guardarNotas + "]";
	}
                
}