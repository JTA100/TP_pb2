package test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.AsignacionCursoAlumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Curso;
import facultadGestion.Materia;
import facultadGestion.Nota;
import facultadGestion.Universidad;

public class TestAsiganacionCursoAlumno {

	@Test
	public void queUnAlumnoSePuedaInscribirAUnaMateria() {
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";

		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
		// verificar que el alumno se pueda inscribir en el dia correcto
		LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
		boolean verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
		assertTrue(verificacion);

		// Si es el dia de inscripcion que se anote a una materia o mas
		// Materias
		Materia materia = new Materia("pb1", 2619);

		Universidad universidad = new Universidad("Unlam");
		Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
		universidad.agregarAlumno(alumno);
		universidad.agregarTodasLasMaterias();
	
		Integer cantidadDeAlumno = 100;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		
		Comision comision = new Comision(cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		boolean insribirAlumnoAMateria = universidad.insribirAlumnoAMateria(alumno, materia, null, null, null, null,comision);// Solo te puedes anotar en 5 materias
		assertTrue(insribirAlumnoAMateria);
	}
	
	@Test public void asignarLas2NotasSiRecursa() { 
		Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
		Materia materia = new Materia("pb1", 2619);
		
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
		//Se crea una comision 		
		Integer cantidadDeAlumno = 100;
		Integer cantidadDeProfesores = 0;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		//Se crea un curso
		Curso curso = new Curso(comision);
		
		// En la clase AsignacionCurso se relaciona con el alumno y curso
		Nota parcial1 = null; 
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;
	    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
	    
	    asignacionCursoAlumno.agregarCurso(curso);
	    //Se crean las notas
	    Double notaParcial1 = 1.0; 
	    Double notaParcial2 = 3.0; 
	    parcial1 = new Nota(notaParcial1); 
	    parcial2 = new Nota(notaParcial2); 
	    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
	    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
	    assertTrue(asignarNota1); 
	    assertTrue(asignarNota2);
	  
        boolean notaSiRecursa = asignacionCursoAlumno.recursa(parcial1,parcial2,alumno,curso);
        assertTrue(notaSiRecursa);
	}

	@Test public void guardarMateriasAprobadasSiPromociono() {
		Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
		Materia materia = new Materia("pb1", 2619);
		
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
		//Se crea una comision 		
		Integer cantidadDeAlumno = 100;
		Integer cantidadDeProfesores = 0;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		//Se crea un curso
		Curso curso = new Curso(comision);
		
		// En la clase AsignacionCurso se relaciona con el alumno y curso
		Nota parcial1 = null; 
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;
	    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
	    
	    asignacionCursoAlumno.agregarCurso(curso);
	    //Se crean las notas
	    Double notaParcial1 = 7.0; 
	    Double notaParcial2 = 7.0; 
	    parcial1 = new Nota(notaParcial1); 
	    parcial2 = new Nota(notaParcial2); 
	    //Se van a agregar las notas 
	    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
	    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
	    assertTrue(asignarNota1); 
	    assertTrue(asignarNota2);
	 
        boolean notaSiPromociona = asignacionCursoAlumno.promociona(parcial1,parcial2,alumno,curso);
        assertTrue(notaSiPromociona);
        
        Universidad universidad = new Universidad("Unlam");
        universidad.agregarComision(comision);
        //Guarda la materia si promociono
        boolean guardarMateriaAprobada = universidad.guardarMateriaAprobada(materia,alumno,comision);
        assertTrue(guardarMateriaAprobada);
       
	}
		
	@Test public void guardarMateriasAprobadaConRecuperatorio() {
		Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
		Materia materia = new Materia("pb1", 2619);
		
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
		//Se crea una comision 		
		Integer cantidadDeAlumno = 100;
		Integer cantidadDeProfesores = 0;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		//Se crea un curso
		Curso curso = new Curso(comision);
		
		// En la clase AsignacionCurso se relaciona con el alumno y curso
		Nota parcial1 = null; 
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;
	    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
	    
	    asignacionCursoAlumno.agregarCurso(curso);
	  		 
       //Dependiendo como que nota se saco en el recuperatorio se va a guardar la materia 
      //Se crean las notas
	    Double notaParcial1 = 4.0; 
	    Double notaParcial2 = 8.0; 
	    parcial1 = new Nota(notaParcial1); 
	    parcial2 = new Nota(notaParcial2); 
	    //Se van a agregar las notas si promocionaron
	    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
	    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
	    assertTrue(asignarNota1); 
	    assertTrue(asignarNota2);
	 
	    boolean notaSiRecupera = asignacionCursoAlumno.recupera(parcial1,parcial2,alumno,curso);
        assertTrue(notaSiRecupera); // Si recupera se le asigna una nota del recuperatorio
        //Va a recuperar la nota del primerParcial
        Double notaRecuperatorio = 7.0; 
	    recuperatorio = new Nota(notaRecuperatorio);
	    
        boolean asignarRecuperatorio = asignacionCursoAlumno.asignarRecuperatorio(recuperatorio,alumno,curso);
        assertTrue(asignarRecuperatorio);
        
	    boolean notaSiAproboElRecuperatorio = asignacionCursoAlumno.notaRecuperatorioSiAprueba(recuperatorio,alumno,curso);
	    assertTrue(notaSiAproboElRecuperatorio);
	    
	    Universidad universidad = new Universidad("Unlam");
        universidad.agregarComision(comision);
        
      	boolean validarSiConElRecuperatorioEstaEnCondicionDePromociona =  asignacionCursoAlumno.notaRecuperatorioEstaEnCondicionDePromocionar(recuperatorio,parcial2,alumno,curso); 
	    assertTrue(validarSiConElRecuperatorioEstaEnCondicionDePromociona);
	    //Si es en condicion de promocionar se guarda la materia como aprobada		    
        boolean guardarMateriaAprobadaConRecuperatorio = universidad.guardarMateriaAprobada(materia,alumno,comision);
        assertTrue(guardarMateriaAprobadaConRecuperatorio);
	}
	
		@Test public void guardarMateriasAprobadasConFinal() {
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
			String inicio = "2023-09-14";
			String finalizacion = "2023-12-31";
			String inscripcionInicio = "2023-09-13";
			String inscripcionFinalizacion = "2023-09-14";
			LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
			LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 6.0; 
		    Double notaParcial2 = 4.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
	       boolean notaFinalSiVaAFinal = asignacionCursoAlumno.notaFinalSiVaAFinal(parcial1,parcial2,alumno,curso);
	        assertTrue(notaFinalSiVaAFinal); // Si va a final se le asigna una nota del final
	        
	        Double notaFinals = 4.0; 
		    finals = new Nota(notaFinals);
		    
	        boolean asignarFinal = asignacionCursoAlumno.asignarNotaFinal(finals,alumno,curso);
	        assertTrue(asignarFinal);
	      
	  
	        Universidad universidad = new Universidad("Unlam");
	        universidad.agregarComision(comision);
	        
	      	boolean validarSiElFinalEstaAprobado =  asignacionCursoAlumno.notaFinalSiAprobo(finals,alumno,curso); 
		    assertTrue(validarSiElFinalEstaAprobado);
		    //Si es en condicion de promocionar se guarda la materia como aprobada		    
	        boolean guardarMateriaAprobadaConRecuperatorio = universidad.guardarMateriaAprobada(materia,alumno,comision);
	        assertTrue(guardarMateriaAprobadaConRecuperatorio);
		 
		  
		}
		
		@Test public void asignarLas2NotasSiVaAFinal() { 
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
			String inicio = "2023-09-14";
			String finalizacion = "2023-12-31";
			String inscripcionInicio = "2023-09-13";
			String inscripcionFinalizacion = "2023-09-14";
			LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
			LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 6.0; 
		    Double notaParcial2 = 4.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
	       boolean notaFinalSiVaAFinal = asignacionCursoAlumno.notaFinalSiVaAFinal(parcial1,parcial2,alumno,curso);
	        assertTrue(notaFinalSiVaAFinal); // Si va a final se le asigna una nota del final
	        
	        Double notaFinals = 4.0; 
		    finals = new Nota(notaFinals);
		    
	        boolean asignarFinal = asignacionCursoAlumno.asignarNotaFinal(finals,alumno,curso);
	        assertTrue(asignarFinal);
	        
	        boolean notaFinalSiAprueba = asignacionCursoAlumno.notaFinalSiAprobo(finals, alumno, curso);
	        assertTrue(notaFinalSiAprueba);
		}
		
		@Test public void asignarLas2NotasSiRecupera() { 
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
			String inicio = "2023-09-14";
			String finalizacion = "2023-12-31";
			String inscripcionInicio = "2023-09-13";
			String inscripcionFinalizacion = "2023-09-14";
			LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
			LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 6.0; 
		    Double notaParcial2 = 3.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
		    boolean notaSiRecupera = asignacionCursoAlumno.recupera(parcial1,parcial2,alumno,curso);
	        assertTrue(notaSiRecupera); // Si recupera se le asigna una nota del recuperatorio
	        
	        Double notaRecuperatorio = 4.0; 
		    recuperatorio = new Nota(notaRecuperatorio);
		    
	        boolean asignarRecuperatorio = asignacionCursoAlumno.asignarRecuperatorio(recuperatorio,alumno,curso);
	        assertTrue(asignarRecuperatorio);
	        
		    boolean notaSiAproboElRecuperatorio = asignacionCursoAlumno.notaRecuperatorioSiAprueba(recuperatorio,alumno,curso);
		    assertTrue(notaSiAproboElRecuperatorio);
	        
		}


@Test public void asignarLas2NotasSiPromociona() { 
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
			String inicio = "2023-09-14";
			String finalizacion = "2023-12-31";
			String inscripcionInicio = "2023-09-13";
			String inscripcionFinalizacion = "2023-09-14";
			LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
			LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 7.0; 
		    Double notaParcial2 = 8.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
	        boolean notaSiPromociona = asignacionCursoAlumno.promociona(parcial1,parcial2,alumno,curso);
	        assertTrue(notaSiPromociona);
	
		}

	
	
}
			
