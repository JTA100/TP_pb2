package facultadGestion;

import java.util.ArrayList;

public class AsignacionCursoProfesor {

	private Profesor profesor;
	private Curso curso;
	private static Integer id = 0;
	private ArrayList <Profesor> profesores;
	
	public AsignacionCursoProfesor(Profesor profesor,Curso curso,Integer id) {
		this.profesor = profesor;
		this.curso = curso;
		incrementadorId();
		this.profesores = new ArrayList<>();
	}

	private void incrementadorId() {
		++id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AsignacionCursoProfe [profesor=" + profesor + ", curso=" + curso + ", id=" + id + "]";
	}
	

}
