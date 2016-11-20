import java.util.Scanner;

public class CharacterFrequency {

	public CharacterFrequency() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] count = new int[10];
		for (int index = 0; index < 10; index++)
			count[index]=0;
		char[] digit = {'0','1','2','3','4','5','6','7','8','9'};
		System.out.println("Enter the telephone number:");
		Scanner keyboard = new Scanner(System.in);
		String telephone = keyboard.nextLine();
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < telephone.length(); j++)
			{	
				if ((telephone.charAt(j))== digit[i])
					count[i]++;
			}
		}
		System.out.println("The appearing times of digit 0 to 9 are listed in order:");
		for (int index = 0; index < 10; index++)
			System.out.print(count[index] + "   ");
	}

}
