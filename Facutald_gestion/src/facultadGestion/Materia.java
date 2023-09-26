package facultadGestion;

import java.util.ArrayList;


public class Materia {
	private String nombre;
	private Integer codigoMat;
	private ArrayList<Materia>correclativas;
	private Integer horarioDeComienzo;
	private Integer horarioDeSalida;
	private Aula aula;
	
	public Materia(String nombre, Integer codigoMat) {
		this.codigoMat = codigoMat;
		this.nombre = nombre;
		this.correclativas = new ArrayList<>();
		}
	
	public ArrayList<Materia> getCorreclativas() {
		return correclativas;
	}

	public void setCorreclativas(ArrayList<Materia> correclativas) {
		this.correclativas = correclativas;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoMat() {
		return codigoMat;
	}

	public void setCodigoMat(Integer codigoMat) {
		this.codigoMat = codigoMat;
	}

	public Integer getHorarioDeComienzo() {
		return horarioDeComienzo;
	}

	public void setHorarioDeComienzo(Integer horarioDeComienzo) {
		this.horarioDeComienzo = horarioDeComienzo;
	}

	public Integer getHorarioDeSalida() {
		return horarioDeSalida;
	}

	public void setHorarioDeSalida(Integer horarioDeSalida) {
		this.horarioDeSalida = horarioDeSalida;
	}

	// Equals y hashCode basados en codigoMat para comparación
		 @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;
		        Materia materia = (Materia) o;   
		return codigoMat.equals(materia.codigoMat);
		    }
		 
		 @Override
		    public int hashCode() {
		        return codigoMat.hashCode();
		    }
		 
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", codigoMat=" + codigoMat + "]";
	}
	
}
	