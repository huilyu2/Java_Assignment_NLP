import java.util.Scanner;

public class FlowerCounter {

	public FlowerCounter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] flowerName = {"petunia","pansy","rose","violet","carnation"};
		double[] flowerCost = {0.50,0.75,1.50,0.50,0.80};
		
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the flower name:");
        String name = keyboard.nextLine();
        System.out.println("Enter its quantity:");
        int quantity = keyboard.nextInt();
        int rightIndex = 0;
        boolean haveRecord = false;
        for (int index = 0; index < 5; index++)
        {
			if (flowerName[index].equalsIgnoreCase(name))
			{
				rightIndex = index;
				haveRecord = true;
			}
        }
        
        if (haveRecord)
		{
        	double totalCost = quantity * flowerCost[rightIndex];
        	System.out.println("The total cost is: $" + totalCost);
		}
        else
        	System.out.println("No record.");
	}

}
