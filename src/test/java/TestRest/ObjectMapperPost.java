
package TestRest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import pojo.Location;
import pojo.RootPost;


import static org.hamcrest.Matchers.*;

public class ObjectMapperPost {

	@Test
	public void objectPost()
	{
	
	
	
	
	
	
	RestAssured.baseURI = "http://216.10.245.166";

     RootPost r=new RootPost();
     r.setAccuracy(50);
     r.setName("Frontline house");
     r.setPhone_number("(+91) 983 893 3937");
     r.setAddress("29, side layout, cohen 09");
     r.setWebsite(" http://google.com");
     r.setLanguage("French-IN");
     List<String> myList=new ArrayList<String>();
     myList.add("shoe park");
     myList.add("shop");
     r.setTypes(myList);
     Location l=new Location();
     l.setLat(-38.383494);
     l.setLng(33.427362);
     r.setLocation(l);
     

String s=given().log().all().queryParam("key" , "qaclick123"   ).header("Content-Type","application/json").body(r)
         .when().post("maps/api/place/add/json").then().statusCode(200).body(containsString("scope"))
         .extract().response().asString();
	
	//Assert.assertEquals("scope",equals("APP"));
	


System.out.println(s);
	


	
	
	
	
	
	
	}

}
