package testunit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import normalisation.NormalisationNomVoie;
import normalisation.NormalisationPays;
public class NormNomVoieTest {
	@Test
	public void testNormalisationNomVoieBoulevard1() {
		assertEquals("Boulevard", NormalisationNomVoie.modNomVoie("boul"));
	}
	
	@Test
	public void testNormalisationNomVoieBoulevard2() {
		assertEquals("Boulevard", NormalisationNomVoie.modNomVoie("boul."));
	}
	@Test
	public void testNormalisationNomVoieBoulevard3() {
		assertEquals("Boulevard", NormalisationNomVoie.modNomVoie("bd"));
	}
	@Test
	public void testNormalisationNomVoieAvenue() {
		assertEquals("Avenue", NormalisationNomVoie.modNomVoie("av."));
	}
	@Test
	public void testNormalisationNomVoieAutre() {
		assertEquals("Rue", NormalisationPays.modPays("Rue"));
	}
	
	@Test
	public void testNormalisationNomVoieFaubourg1() {
		assertEquals("Faubourg", NormalisationNomVoie.modNomVoie("faub."));
	}
	@Test
	public void testNormalisationNomVoieFaubourg2() {
		assertEquals("Faubourg", NormalisationNomVoie.modNomVoie("fg"));
	}
	@Test
	public void testNormalisationNomVoiePlace() {
		assertEquals("Place", NormalisationNomVoie.modNomVoie("pl."));
	}

}
