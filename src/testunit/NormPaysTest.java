package testunit;
import normalisation.NormalisationPays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NormPaysTest {
	
@Test
public void testNormalisationPays () {
	assertEquals("Belgique",NormalisationPays.modPays("belgium"));
}

}
