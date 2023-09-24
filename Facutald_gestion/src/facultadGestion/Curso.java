package facultadGestion;

	import java.util.ArrayList;


	public class Curso {
		private ArrayList<Aula> aulas;
		private ArrayList<Alumno>alumnos;

		///popop
		public Curso() {
			this.aulas = new ArrayList<>();
			this.alumnos = new ArrayList<>();
		}
	
		public ArrayList<Alumno> getAlumnos() {
			return alumnos;
		}


		public void setAlumnos(ArrayList<Alumno> alumnos) {
			this.alumnos = alumnos;
		}

		public ArrayList<Aula> getAulas() {
			return aulas;
		}


		public void setAulas(ArrayList<Aula> aulas) {
			this.aulas = aulas;
		}


		public boolean agregarAula(Aula aula) {
			return this.aulas.add(aula);
		}

		
		public boolean agregarAlumnoAlCurso(Curso curso,AsignacionCursoAlumno asignacionCursoAlumno) {
			Alumno alumno = asignacionCursoAlumno.getAlumno() ;
				if(alumno != null && curso != null) {
					this.alumnos.add(alumno);
					asignacionCursoAlumno.agregarCurso(curso);
					return true;
			}
				return false;
		}


		public Alumno buscarAlumno(Alumno alumno, AsignacionCursoAlumno asignacionCursoAlumno,Curso curso) {
			for(int i = 0; i< this.alumnos.size();i++) {
				if(this.alumnos.get(i).equals(alumno) && asignacionCursoAlumno.getCursos().get(i).equals(curso)) {
					return this.alumnos.get(i);
					
				}
			}
			return null;
		}
}
