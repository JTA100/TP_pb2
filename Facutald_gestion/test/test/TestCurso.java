package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.AsignacionCursoAlumno;
import facultadGestion.Aula;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Curso;
import facultadGestion.Materia;
import facultadGestion.Nota;


public class TestCurso {

	@Test
	public void agregarUnaMateriaYAsignarUnAula() {
		// pppp
		// Se crea un alumno String nombre = "Gaston"; String apellido = "Estevez";
		String nombre = "Gaston";
		String apellido = "Estevez";
		Integer dni = 1234;
		Alumno alumno = new Alumno(dni, apellido, nombre);

		// Se crea una materia
		Integer codigo = 1234;
		String nombreMat = "Ingles";
		Materia materia = new Materia(nombreMat, codigo);

		// Se crea un aula
		Integer cantidadMaxAlumno = 100;
		Aula aula = new Aula(cantidadMaxAlumno);

		// En la clase AsignacionCurso se relaciona con el alumno y cursow
		Nota parcial1 = null;
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;

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

		AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,
				recuperatorio, finals);

		Integer cantidadDeAlumno = 100;
		Double horarioDeSalida = 7.0;
		Double horarioDeEntrada = 12.0;
		Comision comision = new Comision(cantidadDeAlumno, materia, horarioDeEntrada, horarioDeSalida, cicloElectivo);

		// Se crea un curso

		Curso curso = new Curso(comision);

		// Se le asigna un aula al curso
		boolean AsignarAula = curso.agregarAula(aula);
		assertTrue(AsignarAula);

		// Se le agrega una materia al curso
		boolean agregarMateria = curso.agregarMateria(materia);
		assertTrue(agregarMateria);

		// El asignacionCursoAlumno se le agrega un curso
		asignacionCursoAlumno.agregarCurso(curso);
	}

	@Test
	public void asignarUnAlumnoAlCurso() { // Se crea un alumno
		String nombre = "Gaston";
		String apellido = "Estevez";
		Integer dni = 1234;
		Alumno alumno = new Alumno(dni, apellido, nombre);
		// En la clase AsignacionCurso se relaciona con el alumno y cursow Integer id
		Nota parcial1 = null;
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;

		AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,
				recuperatorio, finals);

		// creamos una comision ya que un curso tiene una comision
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String diaDeCursada1 = "Lunes";
		String diaDeCursada2 = "Miercoles";
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion, diaDeCursada1, diaDeCursada2);
		// verificar que el alumno se pueda inscribir en el dia correcto
		LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
		boolean verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
		assertTrue(verificacion);

		// Si es el dia de inscripcion que se anote a una materia o mas
		// Materias
		Materia materia = new Materia("pb1", 2619);
		Integer cantidadDeAlumno = 10;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;

		Comision comision = new Comision(cantidadDeAlumno, materia, horarioDeEntrada, horarioDeSalida, cicloElectivo);
		Curso curso = new Curso(comision);
		curso.agregarAlumnoAlCurso(curso, asignacionCursoAlumno);
	}

	@Test
	public void buscarUnAlumnoEnUnCursoYAsignarUnaNota() {
		// Se crea un alumno
		String nombre = "Gaston";
		String apellido = "Estevez";
		Integer dni = 1234;
		Alumno alumno = new Alumno(dni, apellido, nombre);

		// En la clase AsignacionCurso se relaciona con el alumno y cursow
		Nota parcial1 = null;
		Nota parcial2 = null;
		Nota recuperatorio = null;
		Nota finals = null;

		AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,
				recuperatorio, finals);

		// creamos una comision ya que un curso tiene una comision
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";
		String diaDeCursada1 = "Lunes";
		String diaDeCursada2 = "Miercoles";
		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion, diaDeCursada1, diaDeCursada2);
		// Si es el dia de inscripcion que se anote a una materia o mas
		// Materias
		Materia materia = new Materia("pb1", 2619);
		Integer cantidadDeAlumno = 10;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		Comision comision = new Comision(cantidadDeAlumno, materia, horarioDeEntrada, horarioDeSalida, cicloElectivo);

		Curso curso = new Curso(comision);
		assertTrue(asignacionCursoAlumno.agregarCurso(curso));
		assertTrue(asignacionCursoAlumno.asignarCursoAlAlumno(alumno, curso));
		// BuscarAlumno con su curso
		Alumno buscar = curso.buscarAlumno(alumno, asignacionCursoAlumno, curso);
		assertNotNull(buscar);
		// Si lo ecuentra se le asigna una nota
		Double notaParcial1 = 5.0;
		Double notaParcial2 = 6.5;
		parcial1 = new Nota(notaParcial1);
		parcial2 = new Nota(notaParcial2);

		asignacionCursoAlumno.setParcial1(parcial1);
		asignacionCursoAlumno.setParcial2(parcial2);

		assertNotNull(asignacionCursoAlumno.getParcial1());
		assertNotNull(asignacionCursoAlumno.getParcial2());
	}

}
