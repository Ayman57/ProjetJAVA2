package normalisation;

public class NormalisationPays {

	public static String modPays(String pays){
		String s1= "Luxembourg";
		String s2="Belgique";
		String s3= "Suisse";
		pays=pays.trim();
		
	if (pays.equalsIgnoreCase("letzebuerg")) {
		return s1;
	}
	else if (pays.equalsIgnoreCase("belgium")) {
		return s2;
	}
	else if (pays.equalsIgnoreCase("Switzerland") || pays.equalsIgnoreCase("Schweiz")) {
		return s3;
	}
	else
		return pays;
	}
}
