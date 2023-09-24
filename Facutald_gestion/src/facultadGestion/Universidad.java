package facultadGestion;

import java.util.ArrayList;


public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Aula> aulas;
	private ArrayList<Materia>materias;
	private ArrayList<Comision>comisiones;

	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.comisiones = new ArrayList<>();
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
		           
	//Metodo del test asignacionCursoAlumno
	public void agregarTodasLasMaterias() {
		//Primer cuatrimestre
		Materia pb1 = new Materia("pb1",2619);
		Materia informaticaGeneral = new Materia("InformaticaGeneral",2620);
		Materia matematicaGeneral = new Materia("matematicaGeneral",2621);
		Materia inglesTecnico1 = new Materia("inglesTecnico1",2622);
		//Segundo cuatrimestre
		Materia pb2 = new Materia("pb2",2623);
		Materia pw1 = new Materia("pw1",2624);
		Materia baseDeDatos = new Materia("baseDeDatos",2625);
		Materia disenioGrafico = new Materia("disenioGrafico",2626);
		Materia inglesTecnico2 = new Materia("inglesTecnico2",2627);
		//Tercer cuatrimestre
		Materia disenioDeAplicacionesWeb = new Materia("disenioDeAplicacionesWeb",2629);
		Materia pw2 = new Materia("pw2",2628);
		Materia visualizacionesEInterfaces = new Materia("visualizacionesEInterfaces",2630);
		Materia tallerWeb1 = new Materia("tallerWeb1",2631);
		//Cuarto cuatrimestre
		Materia  baseDeDatos2 = new Materia("baseDeDatos2",2632);
		Materia pw3 = new Materia("pw3",2633);
		Materia tecnologiasDeRedes = new Materia("tecnologiasDeRedes",2634);
		Materia tallerWeb2 = new Materia("tallerWeb2",2635);
		Materia seguridadYCalidadEnAplicacionesWeb = new Materia("seguridadYCalidadEnAplicacionesWeb",2636);
		
		this.materias.add(pb1);
		this.materias.add(informaticaGeneral);
		this.materias.add(matematicaGeneral);
		this.materias.add(inglesTecnico1);
		this.materias.add(pb2);
		this.materias.add(pw1);
		this.materias.add(baseDeDatos);
		this.materias.add(disenioGrafico);
		this.materias.add(inglesTecnico2);
		this.materias.add(disenioDeAplicacionesWeb);
		this.materias.add(pw2);
		this.materias.add(visualizacionesEInterfaces);
		this.materias.add(tallerWeb1);
		this.materias.add(baseDeDatos2);
		this.materias.add(pw3);
		this.materias.add(tecnologiasDeRedes);
		this.materias.add(tallerWeb2);
		this.materias.add(seguridadYCalidadEnAplicacionesWeb);	
	}
	
	public boolean insribirAlumnoAMateria(Alumno alumno, Materia materia1, Materia materia2, Materia materia3, Materia materia4,Materia materia5,Comision comision) {//Solo se puede anotar en 5 mat debido a los horarios
		  boolean verificar = false;
		  final int LIMITE_DE_MATERIAS = 5; // Establece el límite deseado

		    ArrayList<Materia> materiasAInscribir = new ArrayList<>();
		    materiasAInscribir.add(materia1);
		    materiasAInscribir.add(materia2);
		    materiasAInscribir.add(materia3);
		    materiasAInscribir.add(materia4);
		    materiasAInscribir.add(materia5);

		    int contadorMateriasInscriptas = 0;

		    for (Materia materia : materiasAInscribir) {
		        if (materia != null) {
		            if (contadorMateriasInscriptas >= LIMITE_DE_MATERIAS) {
		            	
		                verificar = true; // El alumno ya se inscribió en el límite de materias
		            }
		            if (this.alumnos.contains(alumno) && this.materias.contains(materia) && (this.guardarMateriasAprobada.contains(materia) == false)) {// No verifica si ya aprobo la materia 
		                contadorMateriasInscriptas++;
		            } else {
		                verificar = true; // El alumno ya se inscribió en el límite de materias; // La materia no cumple alguna condición
		                this.comisiones.add(comision);
		                /*
		                 * Comision: Representa grupos de estudiantes que cursarán una materia en un ciclo lectivo específico . Tiene asignados profesores, alumnos, y registros de exámenes.
		                 */
		           }
		        }
		    }
		    return verificar;
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
