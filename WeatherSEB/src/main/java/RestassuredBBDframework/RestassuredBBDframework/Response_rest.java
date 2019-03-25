package RestassuredBBDframework.RestassuredBBDframework;

import static io.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Response_rest {
	
public static Object sunrise;
private Long sunriselong;

	@Test
   void sunrise_time() throws InterruptedException{
    	
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		RestAssured.basePath ="/weather";
		Response response =  (Response) given().contentType(ContentType.JSON).log().all()
		.get ("?q=London&appid=a3e839d1de928ac5b907a92add45b513");
		response.prettyPrint();
		//Extract sunrise from Response
		JsonPath extractor = response.jsonPath();
		sunrise = extractor.get("sys.sunrise");
		
		//Need to convert object to long
		sunriselong = CastObjectToLong.castLongObject(sunrise);
		//Calculate Java time stamp
		long unixTimestamp = sunriselong;
		long javaTimestamp = unixTimestamp * 1000L;
		Date date = new Date(javaTimestamp);
		
		//Readable date format for sunrise
		String sunrisedatetime = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(date);
		System.out.println(sunrisedatetime);
		
		//Assertion that date is correct matching current date
		Assert.assertEquals(sunrisedatetime.substring(0, sunrisedatetime.length() - 6),LocalDate.now().toString());
	}

}