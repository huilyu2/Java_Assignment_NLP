import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

	    URL website = new URL("http://www.lis.illinois.edu/people/directory");
	    Scanner inputStream = new Scanner(
			new InputStreamReader(website.openStream()));

	    Pattern patName = Pattern.compile("(\\<span class=\"nobr netid-.+?\\>|\\<a href=\"/people/faculty/.+?\"\\>)(.+?)(\\</span\\>|\\</a\\>)") ; 
		Matcher matName;
		Pattern patEmail = Pattern.compile("\\<span class=\"spamspan\"\\>\\<span class=\"u\"\\>(.+?)\\</span\\> \\[at\\] \\<span class=\"d\"\\>(.+?)\\</span\\>\\</span\\>") ;
		Matcher matEmail;
		Pattern patPhone = Pattern.compile("\\<span class=\"nobr\"\\>(.*?)\\</span\\>");
		Matcher matPhone;
		String name = "";
	    String fullName = "" ;
	    String phone = "";
	    String emailAddress = "" ;
	    String s = "" ;
	    
	    name = args[0] ;
	    
	    while (inputStream.hasNextLine())
	    {
		    s = inputStream.nextLine();
		    	
		    	if (s.toLowerCase().contains(name.toLowerCase())) 
		    	{
		    		matName = patName.matcher(s) ;
		    		if (matName.find()) 
		    		{
		    			fullName = matName.group(2) ;
		    			System.out.println("Fullname: " + fullName) ;
		    			
			    		while (inputStream.hasNextLine() && !s.contains("</tr>")) 
			    		{
			    		    s = inputStream.nextLine();

			    		        matPhone = patPhone.matcher(s) ;
			    		        if (matPhone.find())
			    		        {
			    		        	phone = matPhone.group(1);
			    		        	System.out.println("Phone Number: " + phone);
			    		        }
			    		    	matEmail = patEmail.matcher(s) ;
			    		    	if (matEmail.find()) 
			    		    	{
			    		    		emailAddress = matEmail.group(1) + "@" + matEmail.group(2) ;
			    		    		System.out.println("Email: " + emailAddress) ;
			    		    	}
			    		}
			    		
			    		System.out.println();
		    		}

		    	}
		    	
	    }
    
	    inputStream.close();
	  
	}

}
