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

}
