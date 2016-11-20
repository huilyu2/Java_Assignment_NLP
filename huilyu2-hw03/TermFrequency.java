import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
public class TermFrequency {

    private static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    
	public TermFrequency() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        BufferedReader inputStream = null;
        String allText = "";
        
        try
        {
            inputStream = new BufferedReader(new FileReader(fileName));
            String line = inputStream.readLine();
            while(line!= null)
            {
            	line.toLowerCase();
            	allText = allText + line;
         	   	allText = allText + "\n";
         	   	line = inputStream.readLine();    
            }
            
            allText = allText.toLowerCase();
            String[] s = allText.split("\\s+");
            
            for(int i = 0; i < s.length; i++)
            {
            	String key = s[i].trim();
                if (key.matches("\\w+"))
                {
                	if(!hashMap.containsKey(key))
                	{
                		hashMap.put(key,1);
                	}
                	else
                	{
                		hashMap.put(key,hashMap.get(key)+1);
                	}
                }	
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Problem with input from file " + fileName);
        }
        
        
        PrintWriter outputStream = null;
        try
        {
        	outputStream = new PrintWriter(new FileWriter("each word_count.txt"));
        	Set<Map.Entry<String, Integer>> allSet = hashMap.entrySet();
    		Iterator<Map.Entry<String, Integer>> iter = allSet.iterator();
    		while (iter.hasNext())
            {
    			Map.Entry<String, Integer> result = iter.next();
                outputStream.println(result.getKey().toLowerCase() + "," + result.getValue());
            }
        	
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + 
                                fileName);
            System.exit(0);
        }
        catch(IOException e) 
        {
 			e.printStackTrace();
 		}
 		
 		outputStream.flush();
 		outputStream.close();
        
	}
	

}
