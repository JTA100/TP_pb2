package facultadGestion;

import java.time.LocalDate;
import java.util.ArrayList;


public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor>profesores;
	private ArrayList<Aula> aulas;
	private ArrayList<Materia>materias;
	private ArrayList<Materia>guardarMateriasAprobada;
	private ArrayList<Comision>comisiones;
	private ArrayList<CicloElectivo> cicloElectivo;
	private ArrayList<Curso> cursos;
	private ArrayList <Materia>materiasCorrelativas;

	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
		this.materiasCorrelativas = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cicloElectivo = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.guardarMateriasAprobada = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.profesores = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}


	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public ArrayList<CicloElectivo> getCicloElectivo() {
		return cicloElectivo;
	}

	public void setCicloElectivo(ArrayList<CicloElectivo> cicloElectivo) {
		this.cicloElectivo = cicloElectivo;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public ArrayList getMateriasCorrelativas() {
		return materiasCorrelativas;
	}

	public void setMateriasCorrelativas(ArrayList materiasCorrelativas) {
		this.materiasCorrelativas = materiasCorrelativas;
	}

	

	public ArrayList<Materia> getGuardarMateriasAprobada() {
		return guardarMateriasAprobada;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public boolean agregarProfesor(Profesor profesor) {
	    if (!validarDniPrfesor(profesor.getDni())) {
	        this.profesores.add(profesor);
	        return true;
	    }
	    return false;
	}
		       
	private boolean validarDniPrfesor(int dni) {
	    for (Profesor a : this.profesores) {
	        if (a.getDni() == dni) {
	    		return true;
	        }
	    }
	    return false;
	}
	
	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer alumnoDni) {
		// Verificar si el alumno está presente en la lista de alumnos
	    boolean alumnoEncontrado = false;
	    for (Alumno alumno : this.alumnos) {
	        if (alumno.getDni().equals(alumnoDni)) {
	            alumnoEncontrado = true;
	            break;
	        }
	    }
	    if (!alumnoEncontrado) {
	    	alumnoEncontrado = false ; // El alumno no se encontró en la lista
	    }
	    // Buscar el codigo de materia y que se encuentre el alumno
	    ArrayList<Materia> materiasSinAprobar = new ArrayList<>(this.materias);
	    for (Materia materiaAprobada : this.guardarMateriasAprobada) {
	        for (Materia materia : materiasSinAprobar) {
	            if (materiaAprobada.getCodigoMat().equals(materia.getCodigoMat()) && alumnoEncontrado){
	                materiasSinAprobar.remove(materia);
	                break;
	            }
	        }
	    }	 
	    return materiasSinAprobar;
	  }  
	
	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Integer idAlumno) {
		for(int  i = 0;i < this.alumnos.size();i++) {
			if(this.alumnos.get(i).getDni().equals(idAlumno)) {
				return this.guardarMateriasAprobada;
				
			}
		}
		return guardarMateriasAprobada;
	}
	
	public ArrayList<Materia> mostrarMateriasSinLasAprobadas(Alumno alumno) {
	    ArrayList<Materia> materiasSinAprobar = new ArrayList<>(this.materias);
	    
	    for (Materia materiaAprobada : this.guardarMateriasAprobada) {
	        for (Materia materia : materiasSinAprobar) {
	            if (materiaAprobada.getCodigoMat().equals(materia.getCodigoMat())) {
	                materiasSinAprobar.remove(materia);
	                break;
	            }
	        }
	    }	    
	    return materiasSinAprobar;
	}
			
	public void setGuardarMateriasAprobada(ArrayList<Materia> guardarMateriasAprobada) {
		this.guardarMateriasAprobada = guardarMateriasAprobada;
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
	
	/*public boolean guardarMateriaAprobada(Materia informaticaGeneral, Alumno alumno) {
		this.alumnos.add(alumno);
		this.guardarMateriasAprobada.add(informaticaGeneral);
		return true;
	}*/
	
	 private Alumno obtenerAlumnoPorDni(Integer dni) {
	        for (Alumno alum : this.alumnos) {
	            if (alum.getDni().equals(dni)) {
	                return alum;
	            }
	        }
	        return null;
	    }

	    private Comision obtenerComisionPorId(Integer idComision) {
	        for (Comision comi : this.comisiones) {
	            if (comi.getId().equals(idComision)) {
	                return comi;
	            }
	        }
	        return null;
	    }

	    private ArrayList<Materia> quitarLaMateriaQueAprobo() {
	        ArrayList<Materia> materiasNoAprobadas = new ArrayList<>(this.materias);
	        
	        for (Materia materiaAprobada : this.guardarMateriasAprobada) {
	            for (Materia materia : materiasNoAprobadas) {
	                if (materiaAprobada.getCodigoMat().equals(materia.getCodigoMat())) {
	                    materiasNoAprobadas.remove(materia);
	                    break;
	                }
	            }
	        }
	        
	        return materiasNoAprobadas;
	    }

	
	    public ArrayList<Materia> mostrarMateriaQueNoAprobo(Alumno alumno) {
	        if (this.alumnos.contains(alumno)) {
	            return quitarLaMateriaQueAprobo();
	        }
	        return null;
	    }

     //Test Aula
	 public void agregarAula(Aula aula) {
	    this.aulas.add(aula);			
			}

	 public boolean existeComisionYDocente(Integer idComision) {
			for(int i = 0; i< this.comisiones.size();i++) {
				if(this.comisiones.get(i).getId().equals(idComision) && this.comisiones.get(i).getProfesores() != null) {
					return true;
				}
			}
			return false;
		}
	 
	 public boolean asignarAulaAlaComision(Integer idComision,Integer idAula ) {
			
			for(int i = 0; i< this.comisiones.size();i++) {
			if(this.comisiones.get(i).getId().equals(idComision) && this.aulas.get(i).getId().equals(idAula)) {
				this.comisiones.get(i).asignarAula(this.aulas.get(i));
				return true;
			}
			}
			return false;
		}
		// Termina el test Aula
				
	     //Test comision
		public boolean agregarComision(Comision comision) {
			  if (validarComisionTurnoCicloMateria(comision)) {
			        return false;
			    }	    
			this.comisiones.add(comision);   
			    return true;
			}	
			
		public boolean validarComisionTurnoCicloMateria(Comision comision) {
			    for (Comision a : this.comisiones) {
			        if (a.getMateria().equals(comision.getMateria()) &&
			            a.getCicloElectivo().equals(comision.getCicloElectivo()) &&
			            a.getHorarioDeSalida().equals(comision.getHorarioDeSalida()) &&
			            a.getHorarioDeEntrada().equals(comision.getHorarioDeEntrada())) {
			        	return true;
			        }	            
			    }
			    return false;
			}
			//Fin del Test comision


		public boolean guardarMateriaAprobada(Integer idMateria, Integer idAlumno, Integer idComision) {
		    boolean validacion = false;
		    Materia materiaAprobada = null;
		    Alumno alumnoEncontrado = null;
		    Comision comisionEncontrada = null;

		    for (Materia mat : this.materias) {
		        if (mat.getCodigoMat().equals(idMateria)) {
		            materiaAprobada = mat;
		            break;
		        }
		    }
		    for (Alumno alum : this.alumnos) {
		        if (alum.getDni().equals(idAlumno)) {
		            alumnoEncontrado = alum;
		            break;
		        }
		    }

		    for (Comision comi : this.comisiones) {
		        if (comi.getId().equals(idComision)) {
		            comisionEncontrada = comi;
		            break;
		        }
		    }

		    if (materiaAprobada != null && alumnoEncontrado != null && comisionEncontrada != null) {
		        this.guardarMateriasAprobada.add(materiaAprobada);
		        validacion = true;
		    }

		    return validacion;
		}

		public boolean validarDiaDeInscripcion(CicloElectivo cicloElectivo2, LocalDate inscripcionDeMateriasInicio) {
		    return cicloElectivo2.getInscripcionDeMateriasInicio().isEqual(inscripcionDeMateriasInicio);
		}
	

		
	
}
