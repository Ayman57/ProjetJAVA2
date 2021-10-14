package testunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import normalisation.NormalisationNomVille;

public class NormNomVilleTest {
	@Test
	public void tiret() {
		assertEquals("Montigny-lès-Metz", NormalisationNomVille.modVille("Montigny les Metz"));
	}
	
	@Test
	public void accent() {
		assertEquals("Montigny-lès-Metz", NormalisationNomVille.modVille("Montigny-lès Metz"));
	}
	

}
