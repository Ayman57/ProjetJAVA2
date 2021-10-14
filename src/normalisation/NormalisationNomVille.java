package normalisation;

public class NormalisationNomVille {

		public static String modVille(String Nomville) {

        Nomville=Nomville.replaceAll("-lès ","-lès-");      
        Nomville=Nomville.replaceAll(" lès-", "-lès-");    
        Nomville=Nomville.replaceAll(" lès ","-lès-");    

        Nomville=Nomville.replaceAll(" le ","-le-");
        Nomville=Nomville.replaceAll("-le ", "-le-");
        Nomville=Nomville.replaceAll(" le-", "le");



        Nomville=Nomville.replaceAll("-les ","-lès-");       
        Nomville=Nomville.replaceAll(" les-", "-lès-");   
        Nomville=Nomville.replaceAll(" les ","-lès-");   

        Nomville=Nomville.replaceAll(" à ","-à-");
        Nomville=Nomville.replaceAll("-à ","-à-");
        Nomville=Nomville.replaceAll(" à-","-à-");
        
        Nomville=Nomville.replaceAll(" a ","-à-");     
        Nomville=Nomville.replaceAll(" a-","-à-");         
        Nomville=Nomville.replaceAll("-a ","-à-");  
        
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
