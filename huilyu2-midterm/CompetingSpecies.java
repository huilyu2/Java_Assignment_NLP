import java.util.Scanner;
public class CompetingSpecies {

	public CompetingSpecies() {
		// TODO Auto-generated constructor stub
	}

    private String name;
    private int population;
    private double growthRate;

    public void readInput( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the species' name?");
        name = keyboard.nextLine( );

        System.out.println("What is the population of the species?");
        population = keyboard.nextInt( );

        System.out.println("Enter growth rate (% increase per year):");
        growthRate = keyboard.nextDouble( );
       
    }

    public void writeOutput( )
    {
         System.out.println("Name = " + name);
         System.out.println("Population = " + population);
         System.out.println("Growth rate = " + growthRate + "%");
    }

    /**
     Precondition: years is a nonnegative number.
     Returns the projected population of the calling object
     after the specified number of years.
    */
   public int predictPopulation(int years)
   {
	   int result = 0;
       double populationAmount = population;
       int count = years;
       while ((count > 0) && (populationAmount > 0))
       {
           populationAmount = (populationAmount +
                         (growthRate / 100) * populationAmount);
           count--;
       }
       if (populationAmount > 0)
           result = (int)populationAmount;
	
       return result;
   }

   public void setSpecies(String newName,
                   int newPopulation, double newGrowthRate)
   {
       name = newName;
       if (newPopulation >= 0)
           population = newPopulation;
       else
       {
           System.out.println(
                      "ERROR: using a negative population.");
           System.exit(0);
       }
       growthRate = newGrowthRate;
   }

   public String getName( )
   {
       return name;
   }

   public int getPopulation( )
   {
       return population;
   }

   public double getGrowthRate( )
   {
       return growthRate;
   }

    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CompetingSpecies firstSpecies = new CompetingSpecies();
		System.out.println("Enter data of the first Species:");
        firstSpecies.readInput( );
        firstSpecies.writeOutput( );

        CompetingSpecies secondSpecies = new CompetingSpecies();
		System.out.println("Enter data of the second Species:");
        secondSpecies.readInput( );
        secondSpecies.writeOutput( );
        
        
        boolean firstIsSmaller = true;
        if (firstSpecies.getPopulation() > secondSpecies.getPopulation())
        	firstIsSmaller = false;
        int firstFuturePopulation = firstSpecies.getPopulation();
        int secondFuturePopulation = secondSpecies.getPopulation();
        if (firstIsSmaller)
        {
        	if (firstSpecies.getGrowthRate()<= secondSpecies.getGrowthRate())
        		System.out.println("The species " + firstSpecies.getName() + " with the smaller population will never outnumber the other species.");
        	else
        	{
        		int year = 0;
        		while (firstFuturePopulation <= secondFuturePopulation)
        		{
        			year++;
        			firstFuturePopulation = firstSpecies.predictPopulation(year);
        			secondFuturePopulation = secondSpecies.predictPopulation(year);
        		}
        		System.out.println("In "+ year + " years, the species " + firstSpecies.getName() + " that starts with the lower population");
        		System.out.println("will outnumber the species that starts with the higher population.");
        	}
        }
        else
        {
        	if (secondSpecies.getGrowthRate()<= firstSpecies.getGrowthRate())
        		System.out.println("The species " + secondSpecies.getName() + " with the smaller population will never outnumber the other species.");
        	else
        	{
        		int year = 0;
        		while (secondFuturePopulation <= firstFuturePopulation)
        		{
        			year++;
        			firstFuturePopulation = firstSpecies.predictPopulation(year);
        			secondFuturePopulation = secondSpecies.predictPopulation(year);
        		}
        		System.out.println("In "+ year + " years, the species " + secondSpecies.getName() + " that starts with the lower population");
        		System.out.println("will outnumber the species that starts with the higher population.");
        	}
        }

     
	}

}
