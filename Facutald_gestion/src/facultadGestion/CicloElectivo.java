package facultadGestion;

import java.time.LocalDate;

public class CicloElectivo {

	private LocalDate fechaInicioCicloElectivo;
	private LocalDate fechaDeFinalizacionCicloElectivo;
	private LocalDate inscripcionDeMateriasInicio;
	private LocalDate inscripcionDeMateriasFinalizacion;


    public CicloElectivo(LocalDate fechaInicioCicloElectivo, LocalDate fechaFinalizacionCicloElectivo,
            LocalDate inscripcionDeMateriasInicio, LocalDate inscripcionDeMateriasFinalizacion) {
        this.fechaInicioCicloElectivo = fechaInicioCicloElectivo; 
        this.fechaDeFinalizacionCicloElectivo = fechaFinalizacionCicloElectivo;
        this.inscripcionDeMateriasInicio = inscripcionDeMateriasInicio;
        this.inscripcionDeMateriasFinalizacion = inscripcionDeMateriasFinalizacion;
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
		if(this.fechaInicioCicloElectivo.getMonthValue() == diaQueSeQuiereInscribir.getMonthValue()) {
			return true;
		}
		return false;
	}
	
        @Override
        public String toString() {
	return "CicloElectivo [fechaInicioCicloElectivo=" + fechaInicioCicloElectivo + ", fechaDeFinalizacionCicloElectivo="
			+ fechaDeFinalizacionCicloElectivo + ", inscripcionDeMateriasInicio=" + inscripcionDeMateriasInicio
			+ ", inscripcionDeMateriasFinalizacion=" + inscripcionDeMateriasFinalizacion + "]";
}