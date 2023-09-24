package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Profesor;
import facultadGestion.Universidad;

public class TestUniversidad {

	@Test
	public void QueNoSePuedeAgregarDosAlumnosConElMismoDNI() {
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

		Universidad universidad = new Universidad("Unlam");
		universidad.agregarTodasLasMaterias();

		Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
		Alumno alumno2 = new Alumno(1234, "Estevez", "Gaston");
		Alumno alumno3 = new Alumno(1235, "Cardelli", "Agustin");
		
		boolean seAgregoAlumno1 = universidad.agregarAlumno(alumno);
		boolean seAgregoAlumno2 = universidad.agregarAlumno(alumno2);
		boolean seAgregoAlumno3 = universidad.agregarAlumno(alumno3);

		assertTrue(seAgregoAlumno1);
		assertFalse(seAgregoAlumno2);
		assertTrue(seAgregoAlumno3);
	}
	
	
	@Test
	public void QueNoSePuedeAgregarDosDocenteConElMismoDNI() {
		Integer dniProfesor1 = 1234;
		Integer dniProfesor2 = 1234;
		
		Profesor profesor = new Profesor(dniProfesor1,"Andres");
		Profesor profesor2 = new Profesor(dniProfesor2,"Marcos");
		
		//La universidad verifica que los profes no tengan el mismo dni 
		//Y en la clase Comision verifica que se asignen la cantidad necesarias de profesores
		Universidad universidad = new Universidad("Unlam");
		Boolean agregarProfesor1 = universidad.agregarProfesor(profesor);
		Boolean agregarProfesor2 = universidad.agregarProfesor(profesor2);
		
		assertTrue(agregarProfesor1);
		assertFalse(agregarProfesor2);
		
	}

	

}
