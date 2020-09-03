package TestRest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured; 
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import com.jayway.restassured.RestAssured;

public class TestSpecification {
	/*RestAssured.baseURI="https://reqres.in/api";

	  RequestSpecification httpRequest=RestAssured.given();
	  Response response=httpRequest.request(Method.GET, "/users?page=2");

	  String responseBody=response.getBody().asString();
	  System.out.println("the response body is "  + responseBody);*/
	  

//@Test
public void gettingseci()
{
	
	
	//given().
	
	
	
	
	
	RestAssured.baseURI="https://reqres.in/api";

  RequestSpecification httpRequest=RestAssured.given();
  Response response=httpRequest.request(Method.GET, "/users?page=2");

  String responseBody=response.getBody().asString();
  System.out.println("the response body is "  + responseBody);
	
	
	
	
  
  int statusCode=response.getStatusCode();
  assertEquals(statusCode,200);
}


@Test
public void gettingLine()
{
	

	RestAssured.baseURI="https://reqres.in/api";

	  RequestSpecification httpRequest=RestAssured.given();
	  Response response=httpRequest.request(Method.GET, "/users?page=2");
String statusLine=response.getStatusLine();
 System.out.println("the body is " + statusLine);
 
assertEquals(statusLine,"HTTP/1.1 200 OK");

}










}
