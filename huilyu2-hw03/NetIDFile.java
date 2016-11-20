import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class NetIDFile {

	public NetIDFile() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        BufferedReader inputStream = null;
        String allText = "";
        ArrayList<String> allInfoList = new ArrayList<String>();
        try
        {
            inputStream = new BufferedReader(new FileReader(fileName));
            String line = inputStream.readLine();
            while (line != null) 
            {
               allInfoList.add(line);
         	   line = inputStream.readLine();
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
        TreeMap<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>(infoHashMap(allInfoList));
      
        
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileWriter("NetID_HashMap.txt"));
            
            String NetID = "" ;
    		ArrayList<String> ClassList = null ;
    		
            Set<Map.Entry<String, ArrayList<String>>> allSet = treeMap.entrySet();
    		Iterator<Map.Entry<String, ArrayList<String>>> iter = allSet.iterator();
    		while (iter.hasNext())
            {
    			Map.Entry<String, ArrayList<String>> result = iter.next();
    			NetID = (String) result.getKey();
    	        ClassList = (ArrayList<String>) result.getValue();
    	        outputStream.print(NetID + "|");
    	        for (int i = 0 ; i < ClassList.size(); i++) 
    	        {
    	        		outputStream.print(ClassList.get(i)) ;
    	        		if (i < ClassList.size() - 1)
    	        			outputStream.print(",") ;
    	        }
    	        outputStream.println("") ;
    	        
            }
            
 	    } 
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + 
                                fileName);
            System.exit(0);
        }
        catch (IOException e) 
        {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        
 		outputStream.flush();
 		outputStream.close();
		
	}
	
	public static HashMap<String,ArrayList<String>> infoHashMap(ArrayList<String> allInfoList)
	{
		HashMap<String,ArrayList<String>> infoHashMap = new HashMap<String,ArrayList<String>>();
		for (int i = 0; i < allInfoList.size(); i++)
		{
			String netID = (allInfoList.get(i)).split(" ")[0];
			String courseID = (allInfoList.get(i)).split(" ")[1];
			if(!infoHashMap.containsKey(netID))
			{
				ArrayList<String> courses = new ArrayList<String>();
				infoHashMap.put(netID, courses);
			}
			infoHashMap.get(netID).add(courseID);
		}
		return infoHashMap;
	}
	

}
