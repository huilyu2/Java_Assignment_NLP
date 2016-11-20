import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;

// count the letters ignoring their cases.

public class WordCount {

	public WordCount() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        BufferedReader inputStream = null;
        int temp = 0;
        int letterCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        String allText = "";
        
       try
       {
           inputStream = new BufferedReader(new FileReader(fileName));
           String line = inputStream.readLine();
           while (line != null) 
           {
        	   lineCount++;
        	   allText = allText + line;
        	   allText = allText + "\n";
        	   line = inputStream.readLine();    	   
           }
          

           String s[] = allText.split("\\s+");

           wordCount = s.length;
           
           File file = new File (fileName);
           FileInputStream input = new FileInputStream(file);
           temp = input.read();
           while(temp != -1)
           {
        	   if((temp>=65 && temp<=90)||(temp>=97 && temp<=122)) // count the letters ignoring their cases.
        		   letterCount++;
        	   temp = input.read();
           }
           
   		   input.close();
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
           outputStream = new PrintWriter(new FileWriter("letter_word_line_count.txt"));
           outputStream.println("Filename Read: " + fileName);
           outputStream.println("Letter count = " + letterCount + " (ignore case)");
           outputStream.println("Word count = " + wordCount);
           outputStream.println("Line count = " + lineCount + " (including blank lines between paragraphs)"); 
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

}
