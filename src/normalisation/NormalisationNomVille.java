package normalisation;

public class NormalisationNomVille {

		public static String modVille(String Nomville) {

        Nomville=Nomville.replaceAll("-l�s ","-l�s-");      
        Nomville=Nomville.replaceAll(" l�s-", "-l�s-");    
        Nomville=Nomville.replaceAll(" l�s ","-l�s-");    

        Nomville=Nomville.replaceAll(" le ","-le-");
        Nomville=Nomville.replaceAll("-le ", "-le-");
        Nomville=Nomville.replaceAll(" le-", "le");



        Nomville=Nomville.replaceAll("-les ","-l�s-");       
        Nomville=Nomville.replaceAll(" les-", "-l�s-");   
        Nomville=Nomville.replaceAll(" les ","-l�s-");   

        Nomville=Nomville.replaceAll(" � ","-�-");
        Nomville=Nomville.replaceAll("-� ","-�-");
        Nomville=Nomville.replaceAll(" �-","-�-");
        
        Nomville=Nomville.replaceAll(" a ","-�-");     
        Nomville=Nomville.replaceAll(" a-","-�-");         
        Nomville=Nomville.replaceAll("-a ","-�-");  
        
        Nomville=Nomville.replaceAll("-aux ", "-aux-");
        Nomville=Nomville.replaceAll(" aux ", "-aux-");
        Nomville=Nomville.replaceAll(" aux-", "-aux-");


        Nomville=Nomville.replaceAll("-sous ","-sous-");   
        Nomville=Nomville.replaceAll(" sous ", "-sous-");    
        Nomville=Nomville.replaceAll(" sous-", "-sous-");    

        Nomville=Nomville.replaceAll("-sur","-sur-");
        Nomville=Nomville.replaceAll(" sur ", "-sur-");
        Nomville=Nomville.replaceAll("sur-", "-sur-");
        
        
        return Nomville;
		}
}
