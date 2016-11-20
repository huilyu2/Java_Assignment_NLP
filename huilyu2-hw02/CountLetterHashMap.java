import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountLetterHashMap {

	public CountLetterHashMap() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a line of text that ends with a period.");
		String text = keyboard.nextLine();
		
		HashMap<Character,Integer> letterHashMap = new HashMap<Character,Integer>();
		for (int i = 0; i < text.length(); i++)
		{
			String lowerCaseText = text.toLowerCase();
			char character = lowerCaseText.charAt(i);
			if (Character.isLetter(character))
			{
				if (!letterHashMap.containsKey(character))
					letterHashMap.put(character,1);
				else
					letterHashMap.put(character,letterHashMap.get(character) + 1);
			}
		}
		
		TreeMap<Character, Integer> alphabeticalLetterMap = new TreeMap<Character, Integer>(letterHashMap);
        printMap(alphabeticalLetterMap);
		
	}
	
		public static void printMap(TreeMap<Character, Integer> treemap) 
		{
			Set<Map.Entry<Character, Integer>> allSet = treemap.entrySet();
			Iterator<Map.Entry<Character, Integer>> iter = allSet.iterator();
			while (iter.hasNext())
	        {
				Map.Entry<Character, Integer> result = iter.next();
	            System.out.println("letter: " + result.getKey() + " occurs " + result.getValue() + " time(s)");
	        }
	    }

}
