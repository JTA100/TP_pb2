package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Materia;
import facultadGestion.Universidad;

public class TestUniversidad {

	@Test
	public void QueNoSePuedeAgregarDosAlumnosConElMismoDNI() {
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String dia1 = "Lunes";
		String dia2 = "Miercoles";
		
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
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
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String dia1 = "Lunes";
		String dia2 = "Miercoles";
		
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
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
	public void QueNoSePuedeAgregarDosComisiones() {
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String dia1 = "Lunes";
		String dia2 = "Miercoles";
		
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
		// verificar que el alumno se pueda inscribir en el dia correcto
		LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
		boolean verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
		assertTrue(verificacion);

		Materia materia = new Materia("pb1", 2619);

		Integer cantidadDeAlumno = 60;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		
		Comision comision = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		
		 inicio = "2023-09-14";
		 finalizacion = "2023-12-31";
		 inscripcionInicio = "2023-09-13";
		 inscripcionFinalizacion = "2023-09-14";
		 dia1 = "Lunes";
		 dia2 = "Miercoles";
		
		 fechaInicioCicloElectivo = LocalDate.parse(inicio);
		 fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
         inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		 inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		 cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
		// verificar que el alumno se pueda inscribir en el dia correcto
		 diaQueSeQuiereInscribir = LocalDate.parse(inicio);
		 verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
		assertTrue(verificacion);

		 materia = new Materia("InformaticaGenal", 2620);

		 cantidadDeAlumno = 60;
		 horarioDeEntrada = 8.0;
		 horarioDeSalida = 12.0;
		
		Comision comision2 = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
	
		Universidad universidad = new Universidad("Unlam");
		boolean agregarComision1 = universidad.agregarComision(comision2);
		boolean agregarComision2 = universidad.agregarComision(comision);
		assertTrue(agregarComision1);
		assertTrue(agregarComision2);
	}


	

}


	


