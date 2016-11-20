import java.util.Scanner;
public class Person {

	public Person() {
		// TODO Auto-generated constructor stub
	}

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String telephone;
	Scanner keyboard = new Scanner(System.in);
	
	public void readInput()
	{
		System.out.println("Enter the person's first name:");
		firstName = keyboard.nextLine();
		System.out.println("Enter the person's last name:");
		lastName = keyboard.nextLine();
		System.out.println("Enter the person's email address:");
		emailAddress = keyboard.nextLine();
		System.out.println("Enter the person's telephone number:");
		telephone = keyboard.nextLine();
		
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
	
	public void setEmailAddress(String newEmailAddress)
	{
		emailAddress = newEmailAddress;
	}
	
	public void setTelephone(String newTelephone)
	{
		telephone = newTelephone;
	}
	
	public static boolean equalName(String oneFirstName, String oneLastName, String anotherFirstName, String anotherLastName)
	{
		boolean equalFirstName = anotherFirstName.equals(oneFirstName);
		boolean equalLastName = anotherLastName.equals(oneLastName);
		return (equalFirstName && equalLastName);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter information of the first person:");
		Person firstPerson = new Person();
		firstPerson.readInput();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Want to change his/her email address? Please enter:");
		String changeEmail = keyboard.nextLine();
		firstPerson.setEmailAddress(changeEmail);
		System.out.println("The email address has been changed into " + firstPerson.getEmailAddress());
		
		System.out.println("Enter information of the second person:");
		Person secondPerson = new Person();
		secondPerson.readInput();
		System.out.println("Want to change his/her telephone number? Please enter:");
		String changeTelephone = keyboard.nextLine();
		secondPerson.setTelephone(changeTelephone);
		System.out.println("The telephone number has been changed into " + secondPerson.getTelephone());
		
		System.out.println("Test whether the two persons are equal based solely on name:");
		boolean areEqual = equalName(firstPerson.getFirstName(), firstPerson.getLastName(), secondPerson.getFirstName(), secondPerson.getLastName());
		System.out.println("The result is " + areEqual);
		
		keyboard.close();
	}

}
