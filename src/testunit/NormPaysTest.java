package testunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import normalisation.NormalisationPays;

public class NormPaysTest {

	@Test
	public void testNormalisationPaysBelgique() {
		assertEquals("Belgique", NormalisationPays.modPays("belgium"));
	}
	
	@Test
	public void testNormalisationPaysLuxembourg() {
		assertEquals("Luxembourg", NormalisationPays.modPays("letzebuerg"));
	}
	
	@Test
	public void testNormalisationPaysSuisse() {
		assertEquals("Suisse", NormalisationPays.modPays("Switzerland"));
	}
	
	@Test
	public void testNormalisationPaysSuisse2() {
		assertEquals("Suisse", NormalisationPays.modPays("Schweiz"));
	}
	
	@Test
	public void testNormalisationPaysAutre() {
		assertEquals("France", NormalisationPays.modPays("France"));
	}
	

}
