import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MedianAndMean {

	public MedianAndMean() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Double> temperature= new ArrayList<Double>();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the temperature:");
		double entity = keyboard.nextDouble();
		double sum = 0;
		while (entity != -999)
		{
			sum = sum + entity;
			temperature.add(entity);
			System.out.println("Continue enter the temperature. Enter -999 to end.");
			entity = keyboard.nextDouble();
		}
		double average = sum / temperature.size();
		double median = 0;
		Collections.sort(temperature);
		
		if(temperature.size()%2 != 0)
		{
			median = temperature.get(temperature.size()/2);
		}
		else
		{
			median = (temperature.get(temperature.size()/2 - 1) + temperature.get(temperature.size() / 2)) / 2;
		}
		System.out.println("The average temperature is: " + average);
		System.out.println("The median temperature is: " + median);
		
		
	}

}
