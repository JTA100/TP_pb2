package test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Materia;
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

}
