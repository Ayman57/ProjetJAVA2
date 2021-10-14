package testunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import normalisation.NormalisationNumVoie;

public class NormNumVoieTest {
	@Test
	public void testNormalisationNomVoieBoulevard1() {
		assertEquals("3, rue des alouettes", NormalisationNumVoie.modNumVoie("3","rue des alouettes"));
	}

}
