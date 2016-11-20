import java.util.Scanner;

public class BubbleSort {

	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}

	public static double[] BubbleSort(double[] originalArray)
	{
		double temp = 0;
		for(int i = 0; i < originalArray.length - 1; i++)
		{
			for(int j = 0; j < originalArray.length -1; j++)
			{
				if(originalArray[j] > originalArray[j+1])
				{
					temp = originalArray[j];
					originalArray[j] = originalArray[j+1];
					originalArray[j+1] = temp;
				}
			}
		}
		return originalArray;
	}
	
	public static boolean isStrictlyIncreasing(double[] in)
	{
		boolean isIncreasing = true;
		for (int i = 0; i < in.length - 1; i++)
		{
			if (in[i] >= in[i+1])
				isIncreasing = false;
		}
				
		return isIncreasing;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] temperature = new double[10];

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
       
		double[] sortedArray = BubbleSort(temperature);
		System.out.println("The sorted array in ascending order is: ");
		for (int i = 0; i < sortedArray.length; i++)
		{
			System.out.print(sortedArray[i] + "  ");
		}
		System.out.println();
		
		if(isStrictlyIncreasing(sortedArray)==true)
		{
			System.out.println("It is strictly increasing.");
		}
		else
		{
			System.out.println("It is not strictly increasing.");
		}
	
	}
}


