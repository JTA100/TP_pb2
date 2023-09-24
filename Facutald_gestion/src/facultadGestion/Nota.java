package facultadGestion;

public class Nota {
private Double valor;


	public Nota (Double valor) {
	this.setValor(valor);
	
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Nota [valor=" + valor + "]";
	}
	
}
