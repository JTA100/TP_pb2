package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.Aula;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Materia;
import facultadGestion.Profesor;
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
			String dia1 = "Lunes";
			String dia2 = "Martes";
			
			LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
			LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo1 = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			// verificar que el alumno se pueda inscribir en el dia correcto
			LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
			boolean verificacion = cicloElectivo1.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
			assertTrue(verificacion);

			Materia materia = new Materia("pb1", 2619);
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");

			Integer cantidadDeAlumno = 60;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			
			Comision comision1 = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo1);
			comision1.agregarAlumno(alumno);
			
			//Se crea una comision y agregarlo a la universidad
			 inicio = "2023-09-14";
			 finalizacion = "2023-12-31";
			 inscripcionInicio = "2023-09-13";
			 inscripcionFinalizacion = "2023-09-14";

			 fechaInicioCicloElectivo = LocalDate.parse(inicio);
			 fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
			 inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
			 inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

			CicloElectivo cicloElectivo2 = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			// verificar que el alumno se pueda inscribir en el dia correcto
			 diaQueSeQuiereInscribir = LocalDate.parse(inicio);
			 verificacion = cicloElectivo1.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
			assertTrue(verificacion);

			// materia = new Materia("pb2",2623);
			 materia = new Materia("pb1", 2619);
			 alumno = new Alumno(1234, "Estevez", "Gaston");

			 cantidadDeAlumno = 60;
			 horarioDeEntrada = 8.0;
			 horarioDeSalida = 12.0;
			
			Comision comision2 = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo2);
			comision2.agregarAlumno(alumno);
			//La universidad agrega las comisiones y verifica que no la misma materia,mismo ciclo y mismo turno
			Universidad universidad = new Universidad("Unlam");
			universidad.agregarAlumno(alumno);
			
			boolean agregarComision1 = universidad.agregarComision(comision1);
			boolean agregarComision2 = universidad.agregarComision(comision2);
			
			assertTrue(agregarComision1);
		    assertFalse(agregarComision2);
		}
		
		@Test
		public void asignarUnAulaAUnaComision() {
			Universidad universidad = new Universidad("Unlam");
			//Se crea un aula y agregarlo a la universidad
			Integer cantidadMaxAlumnos = 100;
			Aula aula = new Aula(cantidadMaxAlumnos);
			universidad.agregarAula(aula);
			
			//Se crea una comision y agregarlo a la universidad
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

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			// verificar que el alumno se pueda inscribir en el dia correcto
			LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
			boolean verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
			assertTrue(verificacion);

			Materia materia = new Materia("pb1", 2619);
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");

			Integer cantidadDeAlumno = 60;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			
			Comision comision = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
			comision.setUniversidad(universidad);
			universidad.agregarComision(comision);
			universidad.agregarAlumno(alumno);
			//Se agrega los profes
			Profesor profesor1 = new Profesor(4,"Gonzales","Andres");
			Profesor profesor2 = new Profesor(3,"Gonzales","Andres");
			Profesor profesor3 = new Profesor(1,"Gonzales","Andres");
			universidad.agregarProfesor(profesor3);
			universidad.agregarProfesor(profesor2);
			universidad.agregarProfesor(profesor1);

			
			comision.agregarProfesor(profesor3);
			comision.agregarProfesor(profesor2);
			comision.agregarProfesor(profesor1);
			
			//Verificar que tenga la cantidad de profes
			boolean cantidad = comision.verificarCantidadP();
			assertTrue(cantidad);
			
			//Vericar y el docente
			boolean existeComisionYDocente = universidad.existeComisionYDocente(comision.getId());
			assertTrue(existeComisionYDocente);
			// si existe ,la universidad le asigna el aula a la comision
			boolean asignarAulaALaComision = universidad.asignarAulaAlaComision(comision.getId(),aula.getId());
			assertTrue(asignarAulaALaComision);
			assertNotNull(comision.getAula());
		}

		
}
