package test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Materia;
import facultadGestion.Profesor;
import facultadGestion.Universidad;

public class TestAsignacionCursoProfesor {

	@Test
	public void agregarProfesorAUnaConmision() {

		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String dia1 = "Lunes";
		String dia2 = "Martes";

		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion, dia1, dia2);

		Integer dniProfesor = 1234;
		Integer dniProfesor2 = 123499;
		Profesor profesor = new Profesor(dniProfesor, "Gonzales", "Andres");
		Profesor profesor2 = new Profesor(dniProfesor2, "Gonzales", "Marcos");

		Integer cantidadDeAlumno = 40;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;

		Materia pb2 = new Materia("pb2", 2623);
		Alumno alumno = new Alumno(123, "Cardelli", "Agustin");
		Comision comision = new Comision(cantidadDeAlumno, pb2, horarioDeEntrada, horarioDeSalida, cicloElectivo);
		comision.agregarAlumno(alumno);
		// La universidad verifica que exista la comision y el profe
		Universidad universidad = new Universidad("Unlam");
		universidad.agregarComision(comision);
		universidad.agregarProfesor(profesor);
		universidad.agregarProfesor(profesor2);

		// La comision llama a la uni para ver si existe
		comision.setUniversidad(universidad);
		// Y aca la comision verifica si existe el profe
		comision.agregarProfesor(profesor);
		comision.agregarProfesor(profesor2);

		assertTrue(comision.verificarCantidadP());

	}
}
