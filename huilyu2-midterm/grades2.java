import java.util.Scanner;

public class grades2 {

	public grades2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the grades in integers of range 0 to 100.");
		System.out.println("Place a negative integer at the end to serve as an end marker.");
		int count = 0;
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int countF = 0;
		boolean areMore = true;
		Scanner keyboard = new Scanner(System.in);
		int next = keyboard.nextInt();
		int lowest = next;
		int highest = next;
		int sum = 0;
		while (areMore)
		{
			
			if (next < 0)           //Assume the first integer is not negative.
				areMore = false;
			else
			{
				count++;
				sum = sum + next;
				if (next>=90)
					countA++;
				if (next>=80 && next<90)
					countB++;
				if (next>=70 && next<80)
					countC++;
				if (next>=60 && next<70)
					countD++;
				if (next>=0 && next<60)
					countF++;
				if (next > highest)
					highest = next;
				if (next < lowest)
					lowest = next;
				next = keyboard.nextInt();
			}
		}
		double percentageA = (double)countA / count*100;
		double percentageB = (double)countB / count*100;
		double percentageC = (double)countC / count*100;
		double percentageD = (double)countD / count*100;
		double percentageF = (double)countF / count*100;
		System.out.println("Total number of grades = " + count);
		System.out.println("Number of A's = " + countA + "  Percentage of total:" + percentageA + "%");
		System.out.println("Number of B's = " + countB + "  Percentage of total:" + percentageB + "%");
		System.out.println("Number of C's = " + countC + "  Percentage of total:" + percentageC + "%");
		System.out.println("Number of D's = " + countD + "  Percentage of total:" + percentageD + "%");
		System.out.println("Number of F's = " + countF + "  Percentage of total:" + percentageF + "%");
		double average = (double)sum / count;
		System.out.println("The highest score = " + highest);
		System.out.println("The lowest score = " + lowest);
		System.out.println("The average score = " + average);
		
		keyboard.close();
	}

}
