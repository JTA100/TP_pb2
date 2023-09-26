package facultadGestion;

import java.time.LocalDate;

public class CicloElectivo {

	private LocalDate fechaInicioCicloElectivo;
	private LocalDate fechaDeFinalizacionCicloElectivo;
	private LocalDate inscripcionDeMateriasInicio;
	private LocalDate inscripcionDeMateriasFinalizacion;
	private String diaDeCursada1;
	private String diaDeCursada2;
	

	public CicloElectivo(LocalDate fechaInicioCicloElectivo, LocalDate fechaFinalizacionCicloElectivo,
			LocalDate inscripcionDeMateriasInicio, LocalDate inscripcionDeMateriasFinalizacion,String diaDeCursada1,String diaDeCursada2) {
		this.fechaInicioCicloElectivo = fechaInicioCicloElectivo;
		this.fechaDeFinalizacionCicloElectivo = fechaFinalizacionCicloElectivo;
		this.inscripcionDeMateriasInicio = inscripcionDeMateriasInicio;
		this.inscripcionDeMateriasFinalizacion = inscripcionDeMateriasFinalizacion;
		this.diaDeCursada1 = diaDeCursada1;
		this.diaDeCursada2 = diaDeCursada2;
		
	}

	public String getDiaDeCursada1() {
		return diaDeCursada1;
	}

	public void setDiaDeCursada1(String diaDeCursada1) {
		this.diaDeCursada1 = diaDeCursada1;
	}

	public String getDiaDeCursada2() {
		return diaDeCursada2;
	}

	public void setDiaDeCursada2(String diaDeCursada2) {
		this.diaDeCursada2 = diaDeCursada2;
	}

	public LocalDate getFechaInicioCicloElectivo() {
		return fechaInicioCicloElectivo;
	}

	public void setFechaInicioCicloElectivo(LocalDate fechaInicioCicloElectivo) {
		this.fechaInicioCicloElectivo = fechaInicioCicloElectivo;
	}

	public LocalDate getFechaDeFinalizacionCicloElectivo() {
		return fechaDeFinalizacionCicloElectivo;
	}

	public void setFechaDeFinalizacionCicloElectivo(LocalDate fechaDeFinalizacionCicloElectivo) {
		this.fechaDeFinalizacionCicloElectivo = fechaDeFinalizacionCicloElectivo;
	}

	public LocalDate getInscripcionDeMateriasInicio() {
		return inscripcionDeMateriasInicio;
	}

	public void setInscripcionDeMateriasInicio(LocalDate inscripcionDeMateriasInicio) {
		this.inscripcionDeMateriasInicio = inscripcionDeMateriasInicio;
	}

	public LocalDate getInscripcionDeMateriasFinalizacion() {
		return inscripcionDeMateriasFinalizacion;
	}

	public void setInscripcionDeMateriasFinalizacion(LocalDate inscripcionDeMateriasFinalizacion) {
		this.inscripcionDeMateriasFinalizacion = inscripcionDeMateriasFinalizacion;
	}

	public boolean verificarDiaDeInscripcion(LocalDate diaQueSeQuiereInscribir) {
		if (this.fechaInicioCicloElectivo.getMonthValue() == diaQueSeQuiereInscribir.getMonthValue()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(fechaInicioCicloElectivo, fechaDeFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
	}

	// Equals y hashCode basados en las fechas para comparación
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;
		CicloElectivo that = (CicloElectivo) o;
		return fechaInicioCicloElectivo.equals(that.fechaInicioCicloElectivo)
				&& fechaDeFinalizacionCicloElectivo.equals(that.fechaDeFinalizacionCicloElectivo)
				&& inscripcionDeMateriasInicio.equals(that.inscripcionDeMateriasInicio)
				&& inscripcionDeMateriasFinalizacion.equals(that.inscripcionDeMateriasFinalizacion);
	}

	@Override
	public String toString() {
		return "CicloElectivo [fechaInicioCicloElectivo=" + fechaInicioCicloElectivo
				+ ", fechaDeFinalizacionCicloElectivo=" + fechaDeFinalizacionCicloElectivo
				+ ", inscripcionDeMateriasInicio=" + inscripcionDeMateriasInicio
				+ ", inscripcionDeMateriasFinalizacion=" + inscripcionDeMateriasFinalizacion + ", diaDeCursada1="
				+ diaDeCursada1 + ", diaDeCursada2=" + diaDeCursada2 + "]";
	}
}