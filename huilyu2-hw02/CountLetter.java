import java.util.ArrayList;
import java.util.Scanner;

public class CountLetter {

	public CountLetter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a line of text that ends with a period.");
		String text = keyboard.nextLine();

		ArrayList<Character> sortedArray = new ArrayList<Character>();
		sortedArray = getLetterOnly(text);
		int[] count = new int[26];
		count = countLetters(sortedArray);
		for (int i = 0; i < count.length; i++)
		{
			if (count[i] != 0)
			{
				System.out.println("letter: " + (char)(i+ (int)'a') + " occurs " + count[i] + " time(s)");
			}
		}
		
	}
	
	public static ArrayList<Character> getLetterOnly(String text)
	{
		String lowerCaseText = text.toLowerCase();
		String letterOnly = lowerCaseText.replaceAll("\\W","");
		ArrayList<Character> sortedArray = new ArrayList<Character>();
		for (int i = 0; i < letterOnly.length(); i++)
			sortedArray.add(letterOnly.charAt(i));
		return sortedArray;
	}
	
	public static int[] countLetters(ArrayList<Character> sortedArray)
	{
		int[] count = new int[26];
		for (int i = 0; i < 26; i++)
			count[i] = 0;
		
		for (int i = 0; i < sortedArray.size(); i++)
		{
			int index = (int)sortedArray.get(i) - (int)'a';
			count[index]++;
		}
		return count;
	}
	
	
	
	

}
