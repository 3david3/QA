package RestassuredBBDframework.RestassuredBBDframework;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Rectangle_Cities {
	
private int id;

	@Test
	void weather_Id() throws InterruptedException, JsonParseException, JsonMappingException, IOException{
    	
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		RestAssured.basePath ="/box";
		Response response =  (Response) given().contentType(ContentType.JSON).log().all()
		.get ("/city?bbox=16,38,17,39,10&appid=a3e839d1de928ac5b907a92add45b513");
		response.prettyPrint();
		
		//Extract weather from Response
		JsonPath extractor = response.jsonPath();
		
		List<List<Integer>> weather = extractor.getList("list.weather.id");

	    for(List<Integer> i:weather)
	    	
	    {
	    	//Print nested id values
	    	for (int x = 0; x <i.size(); x++) {
	    	id  = i.get(x).intValue();
	    	}
	        System.out.println(id);
	    }
	    // Assertion weather = 5
	    Assert.assertEquals(weather.size(),5);
	}

}
