import java.util.Scanner;
public class inventory {

	public inventory() {
		// TODO Auto-generated constructor stub
	}

	private static int numberOfSold;
	private double totalSales;
	private double totalDiscounts;
	private double costPerItem;  //the original cost per item
	private double finalCostPerItem;  //the final cost per item
	private int bulkQuantity;
	private double bulkDiscountPercentage;
	public void readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the original cost per item:");
		costPerItem = keyboard.nextDouble();
		System.out.println("Enter the number of sold items:");
		numberOfSold = keyboard.nextInt();
		System.out.println("Enter the number of bulk quantity:");
		bulkQuantity = keyboard.nextInt();
		System.out.println("Enter the bulk discount percentage: ?%");
		bulkDiscountPercentage = keyboard.nextDouble();
		if (costPerItem<0 || numberOfSold<0 || bulkQuantity<0 || bulkDiscountPercentage<0)
		{
			System.out.println("Error: using one or more negative numbers.");
			System.exit(0);
		}
		
		keyboard.close();
	}
	
	public void registerSale(int n)
	{
		if (n>bulkQuantity)
			finalCostPerItem = costPerItem * (1- bulkDiscountPercentage/100);
		else
			finalCostPerItem = costPerItem;
	}
	
	public void displaySales()
	{
		System.out.println("The number of sold items = " + numberOfSold);
		totalSales = finalCostPerItem * numberOfSold;
		System.out.println("The total sales = " + totalSales);
		totalDiscounts = costPerItem * numberOfSold - totalSales;
		System.out.println("The total discounts = " + totalDiscounts);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inventory oneItem = new inventory();
		oneItem.readInput();
		oneItem.registerSale(numberOfSold);
		oneItem.displaySales();
		
	}

}
