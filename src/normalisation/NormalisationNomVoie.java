package normalisation;

public class NormalisationNomVoie {
public static String modNomVoie(String NomVoie) {
	String s1= "Boulevard";
	String s2="Avenue";
	String s3= "Place";
	String s4= "Faubourg";
	
	NomVoie=NomVoie.trim();
	
	if (NomVoie.equalsIgnoreCase("boul") || NomVoie.equalsIgnoreCase("boul.") || NomVoie.equalsIgnoreCase("bd")) {
		return s1;
	}
	else if (NomVoie.equalsIgnoreCase("av.")) {
		return s2;
	}
	else if (NomVoie.equalsIgnoreCase("faub.") || NomVoie.equalsIgnoreCase("fg")) {
		return s4;
	}
	else if (NomVoie.equalsIgnoreCase("pl.")) {
		return s3;
	}
	else return NomVoie;
}
}
