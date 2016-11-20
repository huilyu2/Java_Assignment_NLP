import java.util.Scanner;
public class grades {

	public grades() {
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
		while (areMore)
		{
			int next = keyboard.nextInt();
			if (next < 0)           //Assume the first integer is not negative.
				areMore = false;
			else
			{
				count++;
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
			}
		}
		System.out.println("Total number of grades = " + count);
		System.out.println("Number of A's = " + countA);
		System.out.println("Number of B's = " + countB);
		System.out.println("Number of C's = " + countC);
		System.out.println("Number of D's = " + countD);
		System.out.println("Number of F's = " + countF);
		
		keyboard.close();

	}

}
