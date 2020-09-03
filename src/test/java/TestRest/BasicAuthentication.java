package TestRest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class BasicAuthentication {

 
	@Test
	public void basicAuthen()
	{
		
		RestAssured.baseURI="http://localhost:8080";
		given().auth().preemptive().basic("neeru123","neeru123").
        queryParam("from","%2F").
        when().get("/login").
        then().statusCode(200);
	
	
	}
	
	
	
	



}
