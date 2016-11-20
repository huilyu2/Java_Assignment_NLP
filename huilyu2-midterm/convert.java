import java.util.Scanner;
public class convert {

	public convert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("The program can convert a temperature given in degrees from either Celsius to Fahrenheit or Fahrenheit to Celsius.");
		System.out.println("The original temperature is Celsius or Fahrenheit? Please enter 'c' or 'C' for Celsius, 'f' or 'F' for Fahrenheit.");
		String unit = keyboard.nextLine();
		if (!(unit.equalsIgnoreCase("c") || unit.equalsIgnoreCase("f")))
			{
				System.out.println("Error: invalid character.");
				System.exit(0);
			}
		else
			System.out.println("Please enter the temperature in degrees. Just a figure please.");
		
		if (unit.equalsIgnoreCase("c"))
		{
			double degreesOfCelsius = keyboard.nextDouble();
			double resultInFahrenheit = (double)(9*degreesOfCelsius/5 + 32);
			System.out.println("The result in Fahrenheit is " + resultInFahrenheit + " F.");
		}
		else 
		{
			double degreesOfFahrenheit = keyboard.nextDouble();
			double resultInCelsius = (double)((degreesOfFahrenheit-32)*5/9);
			System.out.println("The result in Celsius is " + resultInCelsius + " C.");
		}
		
		keyboard.close();

	}

}
