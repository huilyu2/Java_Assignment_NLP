import java.util.Scanner;
public class stats {

	public stats() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter non negative integers.");
		System.out.println("Place a negative integer at the end to serve as an end marker.");
		int count = 0;
		boolean areMore = true;
		int sum = 0;
		Scanner keyboard = new Scanner(System.in);
		int next = keyboard.nextInt();
		int smallest = next;
		int largest = next;
		while (areMore)
		{
			
			if (next < 0)           //Assume the first integer is not negative.
				areMore = false;
			else
			{
				count++;
				sum = sum + next;
				if (next > largest)
					largest = next;
				if (next < smallest)
					smallest = next;
				next = keyboard.nextInt();	
			}
		}
		double average = (double)sum / count;
		System.out.println("The largest integer is " + largest);
		System.out.println("The smallest integer is " + smallest);
		System.out.println("The average of all the integers is " + average);
		
		keyboard.close();
	}

}
