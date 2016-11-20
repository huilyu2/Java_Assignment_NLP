import java.util.ArrayList;
import java.util.Scanner;

public class NumberAboveAverageArrayList {

	public NumberAboveAverageArrayList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Double> temperature= new ArrayList<Double>();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the temperature:");
		double entity = keyboard.nextDouble();
		while (entity != -999)
		{
			temperature.add(entity);
			System.out.println("Continue enter the temperature. Enter -999 to end.");
			entity = keyboard.nextDouble();
		}
		
		double sum = 0;
		for(int i = 0; i < temperature.size(); i++)
		{
			sum = sum + temperature.get(i);
		}
		double average = sum / temperature.size();
		
		int count = 0;
		for(int i = 0; i < temperature.size(); i++)
		{
			if (temperature.get(i) > average)
				count++;
		}
		System.out.println("The average temperature is: " + average);
		System.out.println("The number of days that the temperature is above average: " + count); 
		
	
	}

}
