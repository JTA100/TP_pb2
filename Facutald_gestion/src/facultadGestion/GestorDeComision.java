package facultadGestion;

public class GestorDeComision {
	
	public  boolean verificarHorario(Comision nuevaComision, Alumno alumno) {
	    Double nuevoHorarioEntrada = nuevaComision.getHorarioDeEntrada();
	    Double nuevoHorarioSalida = nuevaComision.getHorarioDeSalida();
	    String nuevoDiaCursada1 = nuevaComision.getDiaCursada1();
	    String nuevoDiaCursada2 = nuevaComision.getDiaCursada2();

	    for(Alumno alumnos : nuevaComision.getAlumnos()) {
	    	if(alumnos.equals(alumnos)) {
	    		 for (Comision comisionExistente : nuevaComision.getUniversidad().getComisiones()) {
	    		        Double horarioEntradaExistente = comisionExistente.getHorarioDeEntrada();
	    		        Double horarioSalidaExistente = comisionExistente.getHorarioDeSalida();
	    		        String diaCursadaExistente1 = comisionExistente.getDiaCursada1();
	    		        String diaCursadaExistente2 = comisionExistente.getDiaCursada2();

	    		        if (horariosCoinciden(nuevoHorarioEntrada, nuevoHorarioSalida, horarioEntradaExistente, horarioSalidaExistente) &&
	    		            diasCursadaCoinciden(nuevoDiaCursada1, nuevoDiaCursada2, diaCursadaExistente1, diaCursadaExistente2)) {
	    		            return false;
	    		        }
	    		    }
	    	}
	    }
	    
	   	    return true;
	}

	
	  	/*public boolean verificarHorario(Comision nuevaComision, Alumno alumno) {
	    Double nuevoHorarioEntrada = nuevaComision.getHorarioDeEntrada();
	    Double nuevoHorarioSalida = nuevaComision.getHorarioDeSalida();
	    String nuevoDiaCursada1 = nuevaComision.getDiaCursada1();
	    String nuevoDiaCursada2 = nuevaComision.getDiaCursada2();

	    for (Comision comisionExistente : nuevaComision.getUniversidad().getComisiones()) {
	        // Verifica si los horarios y los días coinciden
	        if (horariosCoinciden(nuevoHorarioEntrada, nuevoHorarioSalida, 
	            comisionExistente.getHorarioDeEntrada(), comisionExistente.getHorarioDeSalida()) &&
	            diasCursadaCoinciden(nuevoDiaCursada1, nuevoDiaCursada2, 
	            comisionExistente.getDiaCursada1(), comisionExistente.getDiaCursada2())) {
	            return false;
	        }
	    }

	    return true;
	  	}*/
	  	
	 
	private static boolean horariosCoinciden(Double nuevoHorarioEntrada, Double nuevoHorarioSalida,
            Double horarioEntradaExistente, Double horarioSalidaExistente) {
return (nuevoHorarioEntrada < horarioSalidaExistente) && (nuevoHorarioSalida > horarioEntradaExistente);
}
	
	private static boolean diasCursadaCoinciden(String dia1, String dia2, String dia3, String dia4) {
	    return dia1.equals(dia3) || dia1.equals(dia4) || dia2.equals(dia3) || dia2.equals(dia4);
	}
}
