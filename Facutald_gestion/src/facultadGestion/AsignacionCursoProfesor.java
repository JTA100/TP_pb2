package facultadGestion;

import java.util.ArrayList;

import ar.edu.unlam.gestion.Profesor;

public class AsignacionCursoProfesor {

	private Profesor profesor;
	private Curso curso;
	private Integer id;
	private ArrayList <Profesor> profesores;
	
	public AsignacionCursoProfesor(Profesor profesor,Curso curso,Integer id) {
		this.profesor = profesor;
		this.curso = curso;
		this.id = id;
		this.profesores = new ArrayList<>();
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

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AsignacionCursoProfe [profesor=" + profesor + ", curso=" + curso + ", id=" + id + "]";
	}
	

}
