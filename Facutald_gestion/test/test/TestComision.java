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

public class TestComision {

	//No se Pueden generar 2 Comisiones para la misma materia, el mismo cicloLectivo y el mismo turno
		@Test
		public void agregarComision() {
			//Se generan 2 comisiones
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

			Materia materia = new Materia("pb1", 2619);
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");

			Integer cantidadDeAlumno = 60;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			
			Comision comision1 = new Comision(cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			
			//Se crea una comision y agregarlo a la universidad
			 inicio = "2023-09-14";
			 finalizacion = "2023-12-31";
			 inscripcionInicio = "2023-09-13";
			 inscripcionFinalizacion = "2023-09-14";

			 fechaInicioCicloElectivo = LocalDate.parse(inicio);
			 fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			 inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			 inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo1 = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
			// verificar que el alumno se pueda inscribir en el dia correcto
			 diaQueSeQuiereInscribir = LocalDate.parse(inicio);
			 verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
			assertTrue(verificacion);

			// materia = new Materia("pb2",2623);
			 materia = new Materia("pb1", 2619);
			 alumno = new Alumno(1234, "Estevez", "Gaston");

			 cantidadDeAlumno = 60;
			 horarioDeEntrada = 8.0;
			 horarioDeSalida = 12.0;
			
			Comision comision2 = new Comision(cantidadDeAlumno, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo1);
			
			//La universidad agrega las comisiones y verifica que no la misma materia,mismo ciclo y mismo turno
			Universidad universidad = new Universidad("Unlam");
			boolean agregarComision1 = universidad.agregarComision(comision1);
			boolean agregarComision2 = universidad.agregarComision(comision2);
			
			assertTrue(agregarComision1);
		    assertFalse(agregarComision2);
		}
		
}
