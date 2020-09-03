

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GettinRest {
	//Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
	 @Test
	 public void gettingRest()
	 
	 {
		 Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
		 int code=resp.getStatusCode();
		 System.out.println("status code:" + code);
		 Assert.assertEquals(code,200);
	 
   	 }
	
 @Test
 
  public void gettingBody()
  {
	 Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
	 
	 String str=resp.asString();
	  System.out.println("The data is" + str);
	  System.out.println("Response time is " + resp.getTime());
	 
	 
	 
	 
	 
  }





}
