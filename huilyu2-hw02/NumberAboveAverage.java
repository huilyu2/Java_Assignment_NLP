import java.util.Scanner;

public class NumberAboveAverage {

	public NumberAboveAverage() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] temperature = new double[10];
		
        // Read temperatures and compute their average:
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter 10 temperatures:");
        double sum = 0;
        for (int index = 0; index < 10; index++)
        {
			temperature[index] = keyboard.nextDouble( );
            sum = sum + temperature[index];
        }
        double average = sum / 10;
        System.out.println("The average temperature is " + average);

        int count = 0;
        for (int index = 0; index < 10; index++)
        {
            if (temperature[index] > average)
            	count++;
        } 
        System.out.println("The number of days that the temperature is above average: " + count);   
             
	}

}
