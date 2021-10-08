package normalisation;

public class NormalisationPostal {

	
	public static  String  modPostal(String codPost) {
		codPost=codPost.trim();
		int nbCodePost = codPost.length();	
		if (nbCodePost == 4) {
			return "0" + codPost;
		}
		else if (nbCodePost>5) {
			for (int i=0;i<2;i++) {
				codPost.substring(1);
			}
			return codPost;
		}
		else return codPost;
	}
	
	
}
