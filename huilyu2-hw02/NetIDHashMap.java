import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class NetIDHashMap {

	public NetIDHashMap() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter the NetID and course number:");
		System.out.println("Use a space to split them. Enter -1 to stop.");
		Scanner keyboard = new Scanner(System.in);
		String allInfo = keyboard.nextLine();
		ArrayList<String> allInfoList = new ArrayList<String>();
		while(!allInfo.equals("-1"))
		{
			allInfoList.add(allInfo);
			System.out.println("Please enter the NetID and course number:");
			allInfo = keyboard.nextLine();	
		}
		TreeMap<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>(infoHashMap(allInfoList));
        printMap(treeMap);
		
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
	

	public static void printMap(TreeMap<String, ArrayList<String>> treeMap) 
	{
		Set<Map.Entry<String, ArrayList<String>>> allSet = treeMap.entrySet();
		Iterator<Map.Entry<String, ArrayList<String>>> iter = allSet.iterator();
		while (iter.hasNext())
        {
			Map.Entry<String, ArrayList<String>> result = iter.next();
            System.out.println("NetID: " + result.getKey() + "  Courses: " + result.getValue());
        }
    }

}
