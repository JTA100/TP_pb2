package facultadGestion;

public class Aula {
	private static  Integer id = 0;
	private Integer capacidadDeLugares;

		public Aula( Integer capacidadDeLugares) {
			incrementador();
			this.capacidadDeLugares = capacidadDeLugares;
		}

		private static void incrementador(){
			id++;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer ID) {
			id = ID;
		}

		@Override
		public String toString() {
			return "Aula [id=" + id + ", capacidadDeAlumno=" + capacidadDeLugares + "]";
		}

		

		public void setCapacidadDeAlumno(Integer capacidadDeAlumno) {
			this.capacidadDeLugares = capacidadDeAlumno;
		}

		public Integer getCapacidadDeLugares() {
			return capacidadDeLugares;
		}


}
