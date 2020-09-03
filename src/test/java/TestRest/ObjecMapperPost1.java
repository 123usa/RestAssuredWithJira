package TestRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Location;
import pojo.RootPost;

public class ObjecMapperPost1 {

	
	
	  
		@Test
		 public void obbMapp()
		{
		
		
		
		
		
		
		RestAssured.baseURI = "http://216.10.245.166";

	     RootPost r=new RootPost();
	     r.setAccuracy(50);
	     r.setName("Neeraja");
	     r.setPhone_number("510 345 678");
	     r.setAddress("3444 Cydonia");
	     r.setWebsite(" http://google.com");
	     r.setLanguage("French-IN");
	     List<String> myList=new ArrayList<String>();
	     myList.add("mall");
	     myList.add("market");
	     r.setTypes(myList);
	     Location l=new Location();
	     l.setLat(5678);
	     l.setLng(33.427362);
	     r.setLocation(l);
	     

	String s=given().log().all().queryParam("key" , "qaclick123"   ).header("Content-Type","application/json").body(r)
	         .when().post("maps/api/place/add/json").then().statusCode(200).body(containsString("scope"))
	         .extract().response().asString();
		
		//Assert.assertEquals("scope",equals("APP"));
		


	System.out.println(s);
		


		
		
		
		
		
		


	}

	
	
	
	
	
	
	
	
	
	
	


}
