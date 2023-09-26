package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import facultadGestion.Materia;


public class TestMateria {

	@Test
	public void CrearUnaMateria() {
		Integer codigo = 123;
		String nombre = "Ingles";
		
		Materia materia = new Materia(nombre,codigo);
		assertNotNull(materia);
	}
}
