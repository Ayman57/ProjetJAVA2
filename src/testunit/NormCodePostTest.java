package testunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import normalisation.NormalisationNomVoie;
import normalisation.NormalisationPostal;

public class NormCodePostTest {
	@Test
	public void testNormalisationPostal4Chiifre() {
		assertEquals("07354", NormalisationPostal.modPostal("7354"));
	}
	
	
	@Test
	public void testNormalisationPostalAutreChiifre() {
		assertEquals("7354", NormalisationPostal.modPostal("L-7354"));
	}
	
	@Test
	public void testNormalisationPostal5Chiifre() {
		assertEquals("57354", NormalisationPostal.modPostal("57354"));
	}
	
}
