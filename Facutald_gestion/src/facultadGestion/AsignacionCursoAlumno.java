package facultadGestion;

	import java.util.ArrayList;



	public class AsignacionCursoAlumno {
		private Alumno alumno;
		private Integer id;
		private Nota parcial1;
		private Nota parcial2;
		private Nota recuperatorio;
		private Nota finals;
		private ArrayList <Curso> cursos;
		

		public AsignacionCursoAlumno(Alumno alumno, Nota nota1, Nota nota2, Nota recuperatorio,Nota finals) {
			this.alumno = alumno;
			this.id = 0;
			incrementarElIdentificador();
			this.parcial1  = nota1;
			this.parcial2 = nota2;
			this.recuperatorio = recuperatorio;
			this.finals = finals;
			this.cursos = new ArrayList<>();
		}

		
		private void incrementarElIdentificador(){
			this.id++;
		}
		
		public Alumno getAlumno() {
			return alumno;
		}



		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}


		public ArrayList<Curso> getCursos() {
			return cursos;
		}

		public void setCursos(ArrayList<Curso> cursos) {
			this.cursos = cursos;
		}




		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		

		@Override
		public String toString() {
			return "AsignacionCursoAlumno [alumno=" + alumno + ", id=" + id + ", cursos=" + cursos + "]";
		}

		public boolean  agregarCurso(Curso curso) {
			if(curso != null) {
				this.cursos.add(curso);
				return true;
			}
			
			return false;
		}

		public boolean asignarCursoAlAlumno(Alumno alumno2, Curso curso2) {
			for(int i = 0; i< this.cursos.size();i++) {
				if(this.cursos.contains(curso2)) {
					ArrayList<Alumno> agregar = curso2.getAlumnos();
					agregar.add(alumno2);
					return true;
				}
			}
			return false;
		}

	
}
