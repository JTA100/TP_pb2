package facultadGestion;

	import java.util.ArrayList;

import facultadGestion.Alumno;
import ar.edu.unlam.materia.Curso;
import ar.edu.unlam.materia.Nota;

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
		public Nota getRecuperatorio() {
			return recuperatorio;
		}

		public void setRecuperatorio(Nota recuperatorio) {
			this.recuperatorio = recuperatorio;
		}

		public Alumno getAlumno() {
			return alumno;
		}



		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}


		public Nota getParcial1() {
			return parcial1;
		}

		public void setParcial1(Nota parcial1) {
			this.parcial1 = parcial1;
		}

		public Nota getParcial2() {
			return parcial2;
		}

		public void setParcial2(Nota parcial2) {
			this.parcial2 = parcial2;
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
			return "AsignacionCursoAlumno [alumno=" + alumno + ", id=" + id + ", parcial1=" + parcial1
					+ ", parcial2=" + parcial2 + ", cursos=" + cursos + "]";
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

		public boolean asignarParcial1(Nota nota, Alumno buscar,Curso curso) {
			for(int i = 0; i < this.cursos.size();i++) {
				if(this.cursos.get(i).equals(curso) && this.alumno.equals(buscar) ) {
					setParcial1(nota);
					return true;
		}
	}
			return false;
		}
		
		public boolean asignarParcial2(Nota nota, Alumno buscar,Curso curso) {
			for(int i = 0; i < this.cursos.size();i++) {
				if(this.cursos.get(i).equals(curso) && this.alumno.equals(buscar)) {
					setParcial2(nota);
					return true;
		}
	}
			return false;
		}
		
		public boolean asignarRecuperatorio(Nota nota, Alumno buscar,Curso curso) {
			for(int i = 0; i < this.cursos.size();i++) {
				if(this.cursos.get(i).equals(curso) && this.alumno.equals(buscar)) {
					setRecuperatorio(nota);
					return true;
		}
	}
			return false;
		}

		public boolean asignarNotaFinal(Nota notaFinals, Alumno buscar, Curso curso) {
			for(int i = 0; i < this.cursos.size();i++) {
				if(this.cursos.get(i).equals(curso) && this.alumno.equals(buscar)) {
					setFinals(finals);
					return true;
		}
	}
			return false;
		
		}
		
		
		public Nota getFinals() {
			return finals;
		}


		public void setFinals(Nota finals) {
			this.finals = finals;
		}


		public boolean notaFinalSiVaAFinal(Nota parcial1, Nota parcial2, Alumno alumno2, Curso curso2) {
			Double nota1 = parcial1.getValor();
			Double nota2 = parcial2.getValor();
			if(this.cursos.contains(curso2) && this.alumno.equals(alumno2) &&  (nota1 >= 4 && nota1 <= 6  || nota2 >= 4 && nota2 <= 6 ) && (nota1 >= 7 && nota1 <= 10 || nota2 >= 7 && nota2 <= 10)) {
				return true;	
			}else if(nota1 >= 4 && nota1 <= 6 && nota2 >= 4 && nota2 <= 6) {
				return true;
			}		
			return false;
		}

		public boolean notaFinalSiAprobo(Nota finals, Alumno alumno2, Curso curso) {
				Double valorFinals = finals.getValor();
				if(this.cursos.contains(curso) && this.alumno.equals(alumno2) && valorFinals >= 4 && valorFinals <= 10) {
					return true;
				}
			return false;
		}
		
		
		public boolean promociona(Nota parcial1, Nota parcial2, Alumno alumno2, Curso curso2) {
			Double nota1 = parcial1.getValor();
			Double nota2 = parcial2.getValor();
			if(this.cursos.contains(curso2) && this.alumno.equals(alumno2) && nota1 >= 7 && nota1 <= 10 && nota2 >= 7 && nota2 <= 10) {
				return true;
			}
			return false;
		}


		public boolean recursa(Nota parcial1, Nota parcial2, Alumno alumno2, Curso curso2) {
			Double nota1 = parcial1.getValor();
			Double nota2 = parcial2.getValor();
			if(this.cursos.contains(curso2) && this.alumno.equals(alumno2) && nota1 >= 0 && nota1 <= 3 && nota2 >= 0 && nota2 <= 3 ) {
				return true;
			}
			return false;
		
		}


		public boolean recupera(Nota parcial1, Nota parcial2, Alumno alumno, Curso curso) {
			Double nota1 = parcial1.getValor();
			Double nota2 = parcial2.getValor();
			if(this.cursos.contains(curso) && this.alumno.equals(alumno) && nota1 >= 0 && nota1 <= 6 && nota2 >= 4 && nota2 <= 10  ||  nota2 >= 0 && nota2 <= 6 && nota1 >= 4 && nota1 <= 10 ) {
				return true;
			}
			return false;
		}


		public boolean notaRecuperatorioSiAprueba(Nota recuperatorio, Alumno alumno, Curso curso) {
			Double notaRecuperatorio = recuperatorio.getValor();
			if(this.cursos.contains(curso) && this.alumno.equals(alumno) && notaRecuperatorio >= 4 && notaRecuperatorio <= 10) {
				return true;
			}
			return false;
		}


		public boolean notaRecuperatorioEstaEnCondicionDePromocionar(Nota recuperatorio, Nota parcial1, Alumno alumno2,
				Curso curso) {
			Double nota1 = parcial1.getValor();
			Double notaRecuperatorio = recuperatorio.getValor();
			if(this.cursos.contains(curso) && this.alumno.equals(alumno) && nota1 >= 7 && notaRecuperatorio >= 7) {
				return true;
			}
			return false;
		}
		
		
}
