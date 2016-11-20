import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherReader
{
	private static String appid = "dj0yJmk9ZTR0TmFSTUl2TGJUJmQ9WVdrOWVHWlhkR1JTTm0wbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD0yOQ--" ;
	private static String strWOEIDpt1 = "http://where.yahooapis.com/v1/places.q(" ;  
	private static String strWOEIDpt2 = ")?appid=" ;


	public static String getAppid() {
		return appid;
	}

	public static String getStrWOEIDpt1() {
		return strWOEIDpt1;
	}

	public static String getStrWOEIDpt2() {
		return strWOEIDpt2;
	}

	private static String getWOEID(String location) {
		// TODO Auto-generated method stub
		String urlWOEID = getStrWOEIDpt1()+location+getStrWOEIDpt2()+getAppid() ;
		URL website = null;
		Pattern patWOEID = Pattern.compile("\\<woeid\\>([0-9]+)\\</woeid\\>") ; // eg <woeid>12521721</woeid>
		Matcher matWOEID ;
		String strWOEID = "" ;

		try {
			website = new URL(urlWOEID);
			Scanner inputStream = new Scanner(
					new InputStreamReader(website.openStream()));

			while (inputStream.hasNextLine())
			{
				String line = inputStream.nextLine();
				matWOEID = patWOEID.matcher(line) ;
				if (matWOEID.find()) {
					strWOEID = matWOEID.group(1) ; // Return the part of the pattern enclosed in first group of ()
					break ;
				}
			}
			inputStream.close();		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strWOEID;
	}

	private static void showWeather(String WOEID) {
		// TODO Auto-generated method stub
		// Go to https://developer.yahoo.com/weather/documentation.html
		//
		// Using the information on this page, show the current weather, and 5 day forecast
		// getWOEID() above has examples of everything you will need to do this 

		Pattern patCity = Pattern.compile("\\<yweather:location city=\"(.+?)\"") ; 
		Matcher matCity ;
		String city = "";
		
		Pattern patRegion = Pattern.compile("region=\"(.+?)\"") ; 
		Matcher matRegion ;
		String region = "";
		
		Pattern patDate = Pattern.compile("\\<pubDate\\>(.+?)\\</pubDate\\>") ; 
		Matcher matDate ;
		String date = "";
		
		Pattern patCondition = Pattern.compile("\\<yweather:condition  text=\"(.+?)\"") ; 
		Matcher matCondition ;
		String condition = "";
		
		Pattern patTemp = Pattern.compile("temp=\"([0-9]+)\"") ; 
		Matcher matTemp ;
		String temp = "";
		
		Pattern patWind = Pattern.compile("\\<yweather:wind chill=\"([0-9]+)\"") ; 
		Matcher matWind ;
		String wind = "";
		
		Pattern patForecast = Pattern.compile("\\<yweather:forecast.*?text=\"(.+?)\"") ; 
		Matcher matForecast ;
		String forecast = "";
		
		Pattern patMin = Pattern.compile("\\<yweather:forecast.+?low=\"([0-9]+)\"") ; 
		Matcher matMin ;
		String min = "";
		
		Pattern patMax = Pattern.compile("\\<yweather:forecast.+?high=\"([0-9]+)\"") ; 
		Matcher matMax ;
		String max = "";
		
		Pattern patDay = Pattern.compile("\\<yweather:forecast day=\"([a-zA-Z]+)\"") ; 
		Matcher matDay ;
		
		String line = "";
		int day = 0;
		
		try 
		{
			URL website = new URL("http://weather.yahooapis.com/forecastrss?w=" + WOEID);
			Scanner inputStream = new Scanner(
					new InputStreamReader(website.openStream()));

			while (inputStream.hasNextLine())
			{
				line = inputStream.nextLine();
				matCity = patCity.matcher(line) ;
				if (matCity.find()) 
				{
					city = matCity.group(1) ; 
				}
				matRegion = patRegion.matcher(line) ;
				if (matRegion.find()) 
				{
					region = matRegion.group(1) ; 
				}
				matDate = patDate.matcher(line) ;
				if (matDate.find()) 
				{
					date = matDate.group(1) ; 
				}
				matCondition = patCondition.matcher(line) ;
				if (matCondition.find()) 
				{
					condition = matCondition.group(1) ; 
				}
				matTemp = patTemp.matcher(line) ;
				if (matTemp.find()) 
				{
					temp = matTemp.group(1) ; 
				}
				matWind = patWind.matcher(line) ;
				if (matWind.find()) 
				{
					wind = matWind.group(1) ; 
				}

		        matDay = patDay.matcher(line) ;
		        if (matDay.find()) 
				{
					day++;
				}

		        matForecast = patForecast.matcher(line);
				if (matForecast.find() && day == 2) //to show tomorrow's weather
				{              
					forecast = matForecast.group(1) ; 
					matMin = patMin.matcher(line) ;
					if (matMin.find()) 
						min = matMin.group(1) ; 
					matMax = patMax.matcher(line) ;
					if (matMax.find())
						max = matMax.group(1) ; 
				}
				
			}
			inputStream.close();
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		PrintWriter outputStream = null;
	       try
	       {
	           outputStream = new PrintWriter(new FileWriter("WeatherReport.txt"));
	           outputStream.println("Weather Report for " + city + ", " + region + " as of " + date); 
	           outputStream.println("Current Conditions: " + condition); 
	           outputStream.println("Current Temp: " + temp + "F" + "\tWind Chill: " + wind + "F"); 
	           outputStream.println("===="); 
	           outputStream.println("Tomorrow's Weather"); 
	           outputStream.println(forecast + ", Expected Min/Max: " + min + "F" + " / " + max + "F"); 

	           
		   } 
	       catch(FileNotFoundException e)
	       {
	           System.out.println("Error opening the file.");
	           System.exit(0);
	       }
	       catch (IOException e) 
	       {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   }
	       
		   outputStream.flush();
		   outputStream.close();
		
	}

	public static void main(String[] args) throws Exception {

		String location = "" ;
		String WOEID = "" ;
		Scanner kbd = new Scanner(System.in) ;

		System.out.print("Enter the location to search for (Zipcode or City,State) > ") ;
		location = kbd.nextLine();

		WOEID = getWOEID(location) ;
		showWeather(WOEID) ;
	}
}
