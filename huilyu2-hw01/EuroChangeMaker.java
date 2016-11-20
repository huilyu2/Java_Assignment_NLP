import java.util.Scanner;
/**
 * Programming Homework 1
 * @author Huilyu
 */
public class EuroChangeMaker 
{
	public static void main(String[] args) 
	{
		int amount;
        int originalAmount;
        int fiftycents;
        int twentycents;
        int tencents;
        int fivecents;
        int twocents;
        int onecents;

        System.out.println("Enter a whole number from 1 to 99.");
        System.out.println("I will find a combination of coins");
        System.out.println("that equals that amount of change.");

        Scanner keyboard = new Scanner(System.in);
        amount = keyboard.nextInt( );

        originalAmount = amount;
        fiftycents = amount / 50;
        amount = amount % 50;
        twentycents = amount / 20;
        amount = amount % 20;
        tencents = amount / 10;
        amount = amount % 10;
        fivecents = amount / 5;
        amount = amount % 5;
        twocents = amount / 2;
        amount = amount % 2;
        onecents = amount;

        System.out.println(originalAmount +
                           " cents in coins can be given as:");
        System.out.println(fiftycents + " fiftycents");
        System.out.println(twentycents + " twentycents");
        System.out.println(tencents + " tencents");
        System.out.println(fivecents + " fivecents");
        System.out.println(twocents + " twocents and");
        System.out.println(onecents + " onecents");

	}

}
