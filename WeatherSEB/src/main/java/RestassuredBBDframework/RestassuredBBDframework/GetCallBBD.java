package RestassuredBBDframework.RestassuredBBDframework;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;


public class GetCallBBD {	
	
	private static String key = "b6907d289e10d714a6e88b30761fae22";// Correct Sample key
	private static String keyBlank = "";// Missing key
	public static String davidKey = "a3e839d1de928ac5b907a92add45b513";// David's key
	private static int i;
	private static String city;
	private static long sunrise;
	static long unixTimestamp = sunrise;
	static long javaTimestamp = unixTimestamp * 1000L;
	static Date date = new Date(javaTimestamp);
	static String sunrisestr = new SimpleDateFormat("hh:mm").format(date);
	
	//--------- Provided sample Key
	@Test
    public static void weather_successfull(){
		
       given();
       when();
       get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid="+key).
       then().
       assertThat().
       body("cod", is(200));
    }
	
	
	
	//--------------- Missing key 
	@Test
    public static void missingKeyok(){
		
       given();
       when();
       get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid="+keyBlank ).
       then().
       assertThat().
       body("cod", is(401));
    }
	
	@Test
    public static void missingKeyfail(){
		
       given();
       when();
       get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid="+keyBlank).
       then().
       assertThat().
       body("cod", is(200)); // Error expected
    }
	
	
	
	// ---------------- Switch City and verify countries
	@Test
	 public static void switchcities() throws InterruptedException{
		
		String[][] citiesArray = new String[3][2];
		citiesArray[0][0] = "Amsterdam";
		citiesArray[0][1] = "NL";
		citiesArray[1][0] = "Belfast";
		citiesArray[1][1] = "GB";
		citiesArray[2][0] = "Casablanca";
		citiesArray[2][1] = "MA";
		
	        given();
	        when();
	        
	        for (i=0;i<citiesArray.length;i++) {
	        	city = citiesArray[i][0];
	        	get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+davidKey).
	        	
	        	then().
	        	
	        	// Verification correct country code is displayed
	        	assertThat().
	        	body(containsString(citiesArray[i][1]));
	 
	        }
	    }
}
