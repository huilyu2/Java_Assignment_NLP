import java.util.Scanner;

public class Person2 {

	public Person2() {
		// TODO Auto-generated constructor stub
	}

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String telephone;
	private int age;
	
	public void readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the person's first name:");
		firstName = keyboard.nextLine();
		System.out.println("Enter the person's last name:");
		lastName = keyboard.nextLine();
		System.out.println("Enter the person's email address:");
		emailAddress = keyboard.nextLine();
		System.out.println("Enter the person's telephone number:");
		telephone = keyboard.nextLine();
		System.out.println("Enter the person's age:");
		age = keyboard.nextInt();
		
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public String getTelephone()
	{
		return telephone;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setEmailAddress(String newEmailAddress)
	{
		emailAddress = newEmailAddress;
	}
	
	public void setTelephone(String newTelephone)
	{
		telephone = newTelephone;
	}
	
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}
	
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
	public static boolean equalName(String oneFirstName, String oneLastName, String anotherFirstName, String anotherLastName)
	{
		boolean equalFirstName = anotherFirstName.equals(oneFirstName);
		boolean equalLastName = anotherLastName.equals(oneLastName);
		return (equalFirstName && equalLastName);
	}
	
	public static boolean equal(String oneFirstName, String oneLastName, String anotherFirstName, String anotherLastName, int oneAge, int anotherAge)
	{
		boolean equalAge = (oneAge == anotherAge);
		boolean equalFirstName = anotherFirstName.equals(oneFirstName);
		boolean equalLastName = anotherLastName.equals(oneLastName);
		boolean equalObject = (equalFirstName && equalLastName && equalAge);
		return equalObject;
	}
	
	public static boolean equalAge(int oneAge, int anotherAge)
	{
		boolean equalAge = (oneAge == anotherAge);
		return equalAge;
	}
	
	public static boolean isOlder(int oneAge, int anotherAge)
	{
		boolean isOlder = false;
		if (oneAge > anotherAge)
			isOlder = true;
		return isOlder;
	}
	
	public static boolean isYounger(int oneAge, int anotherAge)
	{
		boolean isYounger = false;
		if (oneAge < anotherAge)
			isYounger = true;
		return isYounger;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter information of the first person:");
		Person2 firstPerson = new Person2();
		firstPerson.readInput();
		
		System.out.println("Want to change his/her age? Please enter:");
		int changeAge = keyboard.nextInt();
		firstPerson.setAge(changeAge);
		System.out.println("The age has been changed into " + firstPerson.getAge());
		
		System.out.println("Enter information of the second person:");
		Person2 secondPerson = new Person2();
		secondPerson.readInput();
		
		System.out.println("Want to change his/her first name? Please enter:");
		keyboard = new Scanner(System.in);
		String changeFirstName = keyboard.nextLine();
		secondPerson.setFirstName(changeFirstName);
		System.out.println("The first name has been changed into " + secondPerson.getFirstName());
		System.out.println("Want to change his/her last name? Please enter:");
		String changeLastName = keyboard.nextLine();
		secondPerson.setLastName(changeLastName);
		System.out.println("The last name has been changed into " + secondPerson.getLastName());
		
		System.out.println("Following will be the test. It will be a little longer.");
		System.out.println("Are you ready? Enter any letter to go ahead.");
		String begin = keyboard.nextLine();
		
		System.out.println("This is the third person's partial information:");
		Person2 thirdPerson = new Person2();
		thirdPerson.setFirstName("Sophia");
		thirdPerson.setLastName("Blake");
		thirdPerson.setAge(23);
		System.out.println("Name is " + thirdPerson.getFirstName()+" "+ thirdPerson.getLastName());
		System.out.println("Age is " + thirdPerson.getAge());
		
		System.out.println("This is the fourth person's partial information:");
		Person2 fourthPerson = new Person2();
		fourthPerson.setFirstName("Sophia");
		fourthPerson.setLastName("Blake");
		fourthPerson.setAge(23);
		System.out.println("Name is " + fourthPerson.getFirstName()+" "+ fourthPerson.getLastName());
		System.out.println("Age is " + fourthPerson.getAge());
		
		System.out.println("This is the fifth person's partial information:");
		Person2 fifthPerson = new Person2();
		fifthPerson.setFirstName("Jenny");
		fifthPerson.setLastName("Blake");
		fifthPerson.setAge(23);
		System.out.println("Name is " + fifthPerson.getFirstName()+" "+ fifthPerson.getLastName());
		System.out.println("Age is " + fifthPerson.getAge());
		
		System.out.println("This is the sixth person's partial information:");
		Person2 sixthPerson = new Person2();
		sixthPerson.setFirstName("Sophia");
		sixthPerson.setLastName("Blake");
		sixthPerson.setAge(20);
		System.out.println("Name is " + sixthPerson.getFirstName()+" "+ sixthPerson.getLastName());
		System.out.println("Age is " + sixthPerson.getAge());
		
		
		System.out.println("Test whether two persons are equal:");
		boolean areEqual1 = equal(thirdPerson.getFirstName(), thirdPerson.getLastName(), fourthPerson.getFirstName(), fourthPerson.getLastName(), thirdPerson.getAge(), fourthPerson.getAge());
		System.out.println("The third person and the fouth person are equal? " + areEqual1);
		
		System.out.println("Test whether two persons are equal:");
		boolean areEqual2 = equal(thirdPerson.getFirstName(), thirdPerson.getLastName(), fifthPerson.getFirstName(), fifthPerson.getLastName(), thirdPerson.getAge(), fifthPerson.getAge());
		System.out.println("The third person and the fifth person are equal? " + areEqual2);
		
		System.out.println("Test whether two persons are equal based solely on name:");
		boolean areEqualName1 = equalName(thirdPerson.getFirstName(), thirdPerson.getLastName(), sixthPerson.getFirstName(), sixthPerson.getLastName());
		System.out.println("The third person and the sixth person have the same name? " + areEqualName1);
		
		System.out.println("Test whether two persons are equal based solely on name:");
		boolean areEqualName2 = equalName(thirdPerson.getFirstName(), thirdPerson.getLastName(), fifthPerson.getFirstName(), fifthPerson.getLastName());
		System.out.println("The third person and the fifth person have the same name? " + areEqualName2);
		
		System.out.println("Test whether two persons are equal based solely on age:");
		boolean areEqualAge1 = equalAge(thirdPerson.getAge(), fifthPerson.getAge());
		System.out.println("The third person and the fifth person have the same age? " + areEqualAge1);
		
		System.out.println("Test whether two persons are equal based solely on age:");
		boolean areEqualAge2 = equalAge(thirdPerson.getAge(), sixthPerson.getAge());
		System.out.println("The third person and the sixth person have the same age? " + areEqualAge2);
		
		System.out.println("Test whether one person is older than another:");
		boolean isOlder1 = isOlder(thirdPerson.getAge(), sixthPerson.getAge());
		System.out.println("The third person is older than the sixth person? " + isOlder1);
		
		System.out.println("Test whether one person is older than another:");
		boolean isOlder2 = isOlder(thirdPerson.getAge(), fifthPerson.getAge());
		System.out.println("The third person is older than the fifth person? " + isOlder2);
		
		System.out.println("Test whether one person is younger than another:");
		boolean isYounger1 = isYounger(sixthPerson.getAge(), fourthPerson.getAge());
		System.out.println("The sixth person is younger than the fourth person? " + isYounger1);
		
		System.out.println("Test whether one person is younger than another:");
		boolean isYounger2 = isYounger(thirdPerson.getAge(), fourthPerson.getAge());
		System.out.println("The third person is younger than the fourth person? " + isYounger2);
		
		//All of the test results will be shown together. So it will be a little longer.
		//Please read the results from the beginning. 
	}

}
