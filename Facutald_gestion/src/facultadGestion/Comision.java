package facultadGestion;

import java.util.ArrayList;


public class Comision {

	private Integer cantidadDeAlumnos;
	private Integer cantidadDeProfesores;
	private Materia materia;
	private Double horarioDeEntrada;
	private Double horarioDeSalida;
	private Aula aula;
	private ArrayList<Nota>guardarNotas;
	private ArrayList<Profesor>profesores;
	private CicloElectivo cicloElectivo;
	private Universidad universidad;
	private static Integer generadorDeId=0;
	private  Integer id;
	private ArrayList<Alumno> alumnos;
	private Alumno alumno;



	public Comision( Integer cantidadDeAlumno, Materia materia,Double horarioDeEntrada, Double horarioDeSalida, CicloElectivo cicloElectivo) {
		this.cantidadDeAlumnos = cantidadDeAlumno;
		this.materia = materia;
		this.horarioDeEntrada = horarioDeEntrada;
		this.horarioDeSalida  = horarioDeSalida;
		this.guardarNotas = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.cicloElectivo = cicloElectivo;
		this.aula = null; // La universidad se lo asigna
		this.universidad = null;// Llama a la universidad si existe el profe y la comision
		this.id = incrementarElIdentificador();
		this.alumnos = new ArrayList<>(); 
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	
	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public static Integer getGeneradorDeId() {
		return generadorDeId;
	}

	public static void setGeneradorDeId(Integer generadorDeId) {
		Comision.generadorDeId = generadorDeId;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private static Integer incrementarElIdentificador(){
		generadorDeId++;
		return generadorDeId;
	}

         public CicloElectivo getCicloElectivo() {
		return cicloElectivo;
	}

	public void setCicloElectivo(CicloElectivo cicloElectivo) {
		this.cicloElectivo = cicloElectivo;
	}

	public  Integer getId() {
		return id;
	}

		public Integer getCantidadDeAlumnos() {
		return cantidadDeAlumnos;
	}

	public void setCantidadDeAlumnos(Integer cantidadDeAlumnos) {
		this.cantidadDeAlumnos = cantidadDeAlumnos;
	}

	public Integer getCantidadDeProfesores() {
		return cantidadDeProfesores;
	}

	public void setCantidadDeProfesores(Integer cantidadDeProfesores) {
		this.cantidadDeProfesores = cantidadDeProfesores;
	}

	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Double getHorarioDeEntrada() {
		return horarioDeEntrada;
	}

	public void setHorarioDeEntrada(Double horarioDeEntrada) {
		this.horarioDeEntrada = horarioDeEntrada;
	}

	public Double getHorarioDeSalida() {
		return horarioDeSalida;
	}

	public void setHorarioDeSalida(Double horarioDeSalida) {
		this.horarioDeSalida = horarioDeSalida;
	}

	
	public ArrayList<Nota> getGuardarNotas() {
		return guardarNotas;
	}

	public void setGuardarNotas(ArrayList<Nota> guardarNotas) {
		this.guardarNotas = guardarNotas;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void agregarProfesor(Profesor profesor) {	
		  // Llamamos a la universidad para que nos diga si existe la comision y el profe
    ArrayList<Comision> comisiones = this.universidad.getComisiones();
	    Boolean validar = false;
	    for(int i = 0; i < comisiones.size(); i++) {
	        if(comisiones.get(i).getId().equals(id)) {
	            validar = true;
	            break; // Una vez que encontramos la comisión, no es necesario seguir buscando
	        }
	    }
	    // Después de que verificamos que exista la comisión, comprobamos el profesor
	    if(universidad.getProfesores().contains(profesor) && validar) {
	        this.profesores.add(profesor);
	    }			
	}
	
	public boolean verificarCantidadP() {				
		if(this.profesores.size() == (this.cantidadDeAlumnos/20)) {
			return true;
		}			
		return false;
		
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

	

	public void asignarAula(Aula aula) {
		this.aula = aula;
	}
	
	public Aula getAula(Aula aula) {
		return this.aula = aula;
	}
	
	public void agregarAlumno(Alumno alumno) {	   
		// Verificamos si la comisión actual es la correcta para agregar al alumno
		    if (this.getId().equals(Comision.generadorDeId)) {
		        // Verificamos si el alumno no está ya en la lista de alumnos y si hay espacio disponible
		    	Integer contadorAlumno =  this.alumnos.size();
		        if (!this.alumnos.contains(alumno) && (contadorAlumno ) < this.cantidadDeAlumnos ) {
		            this.alumnos.add(alumno);
		        }
		    }
		}
	
	public boolean verificarQueElAlumnoNoEsteEnUnaComisionConElMismoHorario(Alumno alumno) {
		
		
		return false;
	}

	public String getDiaCursada1() {
		return this.cicloElectivo.getDiaDeCursada1();
	}
	
	public String getDiaCursada2() {
		return this.cicloElectivo.getDiaDeCursada2();
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