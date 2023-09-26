package test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import facultadGestion.Alumno;
import facultadGestion.AsignacionCursoAlumno;
import facultadGestion.CicloElectivo;
import facultadGestion.Comision;
import facultadGestion.Curso;
import facultadGestion.GestorDeComision;
import facultadGestion.Materia;
import facultadGestion.Nota;
import facultadGestion.Universidad;

	public class TestAsignacionCursoAlumno {

        @Test 
		public void queUnAlumnoSePuedaInscribirAUnaMateriaExedeCantidadDeAlumnosPermitida() { //Funciona
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

			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,diaDeCursada1,diaDeCursada2);
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
			
			Comision comision = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			Universidad universidad = new Universidad("Unlam");
			universidad.agregarComision(comision);
			//Creamos los alumnos y verificamos el limite permitido
			Alumno alumno1 = new Alumno(10,"Estevez","Gaston");
			Alumno alumno2 = new Alumno(9,"Estevez","Gaston");
			Alumno alumno3 = new Alumno(8,"Estevez","Gaston");
			Alumno alumno4 = new Alumno(7,"Estevez","Gaston");
			Alumno alumno5 = new Alumno(10,"Estevez","Gaston");
			Alumno alumno6 = new Alumno(11,"Estevez","Gaston");
			Alumno alumno7 = new Alumno(2,"Estevez","Gaston");
			Alumno alumno8 = new Alumno(3,"Estevez","Gaston");
			Alumno alumno9 = new Alumno(4,"Estevez","Gaston");
			Alumno alumno10 = new Alumno(5,"Estevez","Gaston");
			Alumno alumno11 = new Alumno(6,"Estevez","Gaston");
			
			//Para que la comision agregue a los alumnos,primero tiene que existir 
			//En el array de la universidad 
			universidad.agregarAlumno(alumno1);
			universidad.agregarAlumno(alumno2);
			universidad.agregarAlumno(alumno3);
			universidad.agregarAlumno(alumno4);
			universidad.agregarAlumno(alumno5);
			universidad.agregarAlumno(alumno6);
			universidad.agregarAlumno(alumno7);
			universidad.agregarAlumno(alumno8);
			universidad.agregarAlumno(alumno9);
			universidad.agregarAlumno(alumno10);
			universidad.agregarAlumno(alumno11);
			//Despues lo agregamos en la comsion dependiendo la cantidad maxima 
		    comision.agregarAlumno(alumno1);
		    comision.agregarAlumno(alumno2);
		    comision.agregarAlumno(alumno3);
		    comision.agregarAlumno(alumno4);
		    comision.agregarAlumno(alumno5);
		    comision.agregarAlumno(alumno6);
		    comision.agregarAlumno(alumno7);
		    comision.agregarAlumno(alumno8);
		    comision.agregarAlumno(alumno9);
		    comision.agregarAlumno(alumno10);
		    comision.agregarAlumno(alumno11);
		    
		    // Para verificar,llamamos el array de la comision para saber si contiene o no el alumno
		   Boolean contieneAlumno1 = comision.getAlumnos().contains(alumno1);
		   Boolean contieneAlumno2 = comision.getAlumnos().contains(alumno2);
		   Boolean contieneAlumno3 = comision.getAlumnos().contains(alumno3);
		   Boolean contieneAlumno4 = comision.getAlumnos().contains(alumno4);
		   Boolean contieneAlumno5 = comision.getAlumnos().contains(alumno5);
		   Boolean contieneAlumno6 = comision.getAlumnos().contains(alumno6);
		   Boolean contieneAlumno7 = comision.getAlumnos().contains(alumno7);
		   Boolean contieneAlumno8 = comision.getAlumnos().contains(alumno8);
		   Boolean contieneAlumno9 = comision.getAlumnos().contains(alumno9);
		   Boolean contieneAlumno10 = comision.getAlumnos().contains(alumno10);
		   Boolean contieneAlumno11 = comision.getAlumnos().contains(alumno11);
		   
		   //Como la cantidad de alumnos es 10 el alumno 11 no se puede agregar 
			assertTrue(contieneAlumno1);
			assertTrue(contieneAlumno2);
			assertTrue(contieneAlumno3);
			assertTrue(contieneAlumno4);
			assertTrue(contieneAlumno5);
			assertTrue(contieneAlumno6);
			assertTrue(contieneAlumno7);
			assertTrue(contieneAlumno8);
			assertTrue(contieneAlumno9);
			assertTrue(contieneAlumno10);
			assertFalse(contieneAlumno11);
		}
		
		@Test 
		public void queUnAlumnoNoSePuedaInscribirAOtraComsionQueTengaMismoDiaYTurno() { //Funciona
			Universidad universidad = new Universidad("Unlam");
			
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

			    Alumno alumno = new Alumno(10, "Estevez", "Gaston");
			    
			    GestorDeComision gestorDeComisiones = new GestorDeComision();
			  		    
			    Comision nuevaComision = new Comision(10, null, 8.0, 12.0, cicloElectivo); // Crea una nueva comisión
			
			  // cicloElectivo.setDiaDeCursada1("Martes");
			  // cicloElectivo.setDiaDeCursada2("Jueves");
			 		
			    Comision nuevaComision2 = new Comision(10, null, 8.0, 12.0, cicloElectivo); // Crea una nueva comisión
			   
			    nuevaComision2.setUniversidad(universidad);
			    nuevaComision2.agregarAlumno(alumno);
			    
			    nuevaComision.setUniversidad(universidad);
			    nuevaComision.agregarAlumno(alumno);
			    
			    universidad.agregarComision(nuevaComision2);
			    boolean puedeInscribirse = gestorDeComisiones.verificarHorario(nuevaComision, alumno);
			    boolean puedeInscribirseEnOtraComisionConOtroHorarioYDiaIgual = gestorDeComisiones.verificarHorario(nuevaComision2, alumno);

			    assertTrue(puedeInscribirse);
			    assertFalse(puedeInscribirseEnOtraComisionConOtroHorarioYDiaIgual);

		}
		
		@Test //No se puede inscribir a una materia que haya aprobado previamente
		public void queUnAlumnoNoSePuedaInscribirAUnaMateriaQueTengaAprobadoYQueLaInscripcionSeaEnElHorarioIndicado() {//Funciona 
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
			String dia1 = "Lunes";
			String dia2 = "Miercoles";
			
			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
	        universidad.agregarAlumno(alumno);
	        universidad.agregarTodasLasMaterias();
			comision.setUniversidad(universidad);
	        //Guarda la materia si promociono
	        boolean guardarMateriaAprobada = universidad.guardarMateriaAprobada(materia.getCodigoMat(),alumno.getDni(),comision.getId());
	        assertTrue(guardarMateriaAprobada);	
	        
	        //Una vez que aprobo una materia cuando se inscriba que no le aparezcan 
	        //Segundo cuatrimestre 
	        // Segundo cuatrimestre 
	        String Sinicio = "2023-08-02"; // Cambiado a 2 de agosto
	        String Sfinalizacion = "2023-12-08"; // Cambiado a una fecha válida
	        String SinscripcionInicio = "2023-08-01"; // Cambiado a 1 de agosto
	        String SinscripcionFinalizacion = "2023-09-14";
	        String Sdia1 = "Lunes";
	        String Sdia2 = "Martes";

	        LocalDate SfechaInicioCicloElectivo = LocalDate.parse(Sinicio);
	        LocalDate SfechaFinalizacionCicloElectivo = LocalDate.parse(Sfinalizacion);
	        LocalDate SinscripcionDeMateriasInicio = LocalDate.parse(SinscripcionInicio);
	        LocalDate SinscripcionDeMateriasFinalizacion = LocalDate.parse(SinscripcionFinalizacion);

	        CicloElectivo cicloLectivoSegundoCuatrimestre = new CicloElectivo(SfechaInicioCicloElectivo, SfechaFinalizacionCicloElectivo,
	                SinscripcionDeMateriasInicio, SinscripcionDeMateriasFinalizacion, Sdia1, Sdia2);

	        boolean validarQueSeaElDiaDeLaInscripcion = universidad.validarDiaDeInscripcion(cicloLectivoSegundoCuatrimestre, SinscripcionDeMateriasInicio);
	        assertTrue(validarQueSeaElDiaDeLaInscripcion);
	        assertNotNull(universidad.mostrarMateriaQueNoAprobo(alumno));
	        //Suponiendo que no se el dia de la incripsion 
	         SinscripcionInicio = "2023-09-01"; // Cambiado a 1 de agosto
		     SinscripcionDeMateriasInicio = LocalDate.parse(SinscripcionInicio);
		     boolean validarQueNoSeaElDiaDeLaInscripcion = universidad.validarDiaDeInscripcion(cicloLectivoSegundoCuatrimestre, SinscripcionDeMateriasInicio);
	        assertFalse(validarQueNoSeaElDiaDeLaInscripcion);
		}	
		
		@Test //No se puede inscribir a una materia que haya aprobado previamente
		public void calcularPromedio() {//Funciona 
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
			
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
		    Double notaParcial2 = 9.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
		    Double obternerPromedio = asignacionCursoAlumno.obtenerPromedio(alumno.getDni());
		    //Para verificar el promedio la AsignacionCursoAlumnoTieneUnaVariableQueEsIgualAlValorDeseado
		    boolean verificarPromedio = asignacionCursoAlumno.verificarPromedio(obternerPromedio);
		    assertTrue(verificarPromedio);
			
		}
		
		@Test public void queNoSePuedanDosAlumnosConElmismoDniAInscribirAUnaMateria() {// FUNCIONA
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

			// Si es el dia de inscripcion que se anote a una materia o mas
			// Materias

			Universidad universidad = new Universidad("Unlam");
			universidad.agregarTodasLasMaterias();

			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Alumno alumno2 = new Alumno(1234, "Lorenzo", "Noceda");
			Alumno alumno3 = new Alumno(1235, "Cardelli", "Agustin");
			
			boolean seAgregoAlumno1 = universidad.agregarAlumno(alumno);
			boolean seAgregoAlumno2 = universidad.agregarAlumno(alumno2);
			boolean seAgregoAlumno3 = universidad.agregarAlumno(alumno3);

			assertTrue(seAgregoAlumno1);
			assertFalse(seAgregoAlumno2);
			assertTrue(seAgregoAlumno3);
		}
	
		@Test public void obtenerMateriasQueFaltanCursarParaUnAlumno() {// FUNCIONA
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

			// Si es el dia de inscripcion que se anote a una materia o mas
			// Materias
			Materia pb1 = new Materia("pb1", 2619);
			Materia informaticaGeneral = new Materia("InformaticaGeneral",2620);
			Materia baseDeDatos = new Materia("baseDeDatos",2625);

			Universidad universidad = new Universidad("Unlam");
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			universidad.agregarAlumno(alumno);
			universidad.agregarTodasLasMaterias();

			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			

			Comision comision1 = new Comision(cantidadDeAlumno, pb1,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			Comision comision2 = new Comision(cantidadDeAlumno, informaticaGeneral,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			Comision comision3 = new Comision(cantidadDeAlumno, baseDeDatos,horarioDeEntrada,horarioDeSalida, cicloElectivo);

			comision1.agregarAlumno(alumno);
			comision2.agregarAlumno(alumno);
			comision3.agregarAlumno(alumno);
			
			universidad.agregarComision(comision3);
			universidad.agregarComision(comision2);
			universidad.agregarComision(comision1);

			Boolean guardarPb1 = universidad.guardarMateriaAprobada(pb1.getCodigoMat(), alumno.getDni(), comision1.getId());
			Boolean guardarInFo = universidad.guardarMateriaAprobada(informaticaGeneral.getCodigoMat(), alumno.getDni(), comision2.getId());
			Boolean guardarBDD = universidad.guardarMateriaAprobada(baseDeDatos.getCodigoMat(), alumno.getDni(), comision3.getId());
			assertTrue(guardarPb1);
			assertTrue(guardarInFo);
			assertTrue(guardarBDD);

			ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno = universidad.obtenerMateriasQueFaltanCursarParaUnAlumno(alumno.getDni());
			//System.out.println(obtenerMateriasQueFaltanCursarParaUnAlumno);//Muestra las materias que faltan por aprobar 
			assertNotNull(obtenerMateriasQueFaltanCursarParaUnAlumno);
		}
		    
        @Test public void obtenerMateriasAprobadasParaUnAlumno() {// FUNCIONA
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

	// Si es el dia de inscripcion que se anote a una materia o mas
	// Materias
	Materia pb1 = new Materia("pb1", 2619);
	Materia informaticaGeneral = new Materia("InformaticaGeneral",2620);
	Materia baseDeDatos = new Materia("baseDeDatos",2625);

	Universidad universidad = new Universidad("Unlam");
	Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
	universidad.agregarAlumno(alumno);
	universidad.agregarTodasLasMaterias();

	Integer cantidadDeAlumno = 100;
	Double horarioDeEntrada = 8.0;
	Double horarioDeSalida = 12.0;
	

	Comision comision1 = new Comision(cantidadDeAlumno, pb1,horarioDeEntrada,horarioDeSalida, cicloElectivo);
	Comision comision2 = new Comision(cantidadDeAlumno,  informaticaGeneral,horarioDeEntrada,horarioDeSalida, cicloElectivo);
	Comision comision3 = new Comision(cantidadDeAlumno, baseDeDatos,horarioDeEntrada,horarioDeSalida, cicloElectivo);

	comision1.agregarAlumno(alumno);
	comision2.agregarAlumno(alumno);
	comision3.agregarAlumno(alumno);
	
	universidad.agregarComision(comision3);
	universidad.agregarComision(comision2);
	universidad.agregarComision(comision1);

	Boolean guardarPb1 = universidad.guardarMateriaAprobada(pb1.getCodigoMat(), alumno.getDni(), comision1.getId());
	Boolean guardarInFo = universidad.guardarMateriaAprobada(informaticaGeneral.getCodigoMat(), alumno.getDni(), comision2.getId());
	Boolean guardarBDD = universidad.guardarMateriaAprobada(baseDeDatos.getCodigoMat(), alumno.getDni(), comision3.getId());
	assertTrue(guardarPb1);
	assertTrue(guardarInFo);
	assertTrue(guardarBDD);

	ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno = universidad.obtenerMateriasAprobadasParaUnAlumno(alumno.getDni());
	assertNotNull(obtenerMateriasAprobadasParaUnAlumno);
}
   		
		@Test public void asignarLas2NotasSiRecursa() { // FUNCIONA
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
			
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
		
		@Test public void asignarLas2NotasSiPromociona() { // FUNCIONA
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
		
		
		@Test public void asignarLas2NotasSiVaAFinal() {  // FUNCIONA
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
		
		@Test public void asignarLas2NotasSiRecupera() {  // FUNCIONA
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
			String dia1 = "Lunes";
			String dia2 = "Martes";
			
			CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
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
			
		
		@Test public void guardarMateriasAprobadasSiPromociono() { //Funciona
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
			comision.setUniversidad(universidad);

	        //Guarda la materia si promociono
	        boolean guardarMateriaAprobada = universidad.guardarMateriaAprobada(materia.getCodigoMat(),alumno.getDni(),comision.getId());
	        assertFalse(guardarMateriaAprobada);
	       
		}
			
		@Test public void guardarMateriasAprobadaConRecuperatorio() { //fUNCIONA
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
	        universidad.agregarAlumno(alumno);
	        universidad.agregarTodasLasMaterias();
			comision.setUniversidad(universidad);

	      	boolean validarSiConElRecuperatorioEstaEnCondicionDePromociona =  asignacionCursoAlumno.notaRecuperatorioEstaEnCondicionDePromocionar(recuperatorio,parcial2,alumno,curso); 
		    assertTrue(validarSiConElRecuperatorioEstaEnCondicionDePromociona);
		    //Si es en condicion de promocionar se guarda la materia como aprobada		    
	        boolean guardarMateriaAprobadaConRecuperatorio = universidad.guardarMateriaAprobada(materia.getCodigoMat(),alumno.getDni(),comision.getId());
	        assertTrue(guardarMateriaAprobadaConRecuperatorio);
		}
		
		@Test public void guardarMateriasAprobadasConFinal() { //Funciona
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
					inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion,dia1,dia2);
			
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision(cantidadDeAlumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			comision.agregarAlumno(alumno);
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
	        universidad.agregarAlumno(alumno);
	        universidad.agregarTodasLasMaterias();
			comision.setUniversidad(universidad);
			
	      	boolean validarSiElFinalEstaAprobado =  asignacionCursoAlumno.notaFinalSiAprobo(finals,alumno,curso); 
		    assertTrue(validarSiElFinalEstaAprobado);
		    //Si es en condicion de promocionar se guarda la materia como aprobada		    
		    materia.getCodigoMat();
	        boolean guardarMateriaAprobadaConRecuperatorio = universidad.guardarMateriaAprobada(materia.getCodigoMat(),alumno.getDni(),comision.getId());
	        assertTrue(guardarMateriaAprobadaConRecuperatorio);
		}
	}
	
	
	
	        


		
		
		      
          
	
	
	



			
