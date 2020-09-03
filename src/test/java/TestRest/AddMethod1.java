





	package TestRest;

	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
import payload.AddData;

import static io.restassured.RestAssured.*;

	//import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	import org.testng.Assert;
	import org.testng.annotations.Test;


public class AddMethod1
{

		
	@Test
		  public void addAccount()
		  {
			  
			RestAssured.baseURI="http://216.10.245.166";
		
		//POST METHOD
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(AddData.addMethod())
		
				.when().post("maps/api/place/add/json")
		           .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).body(containsString("status"))
		          .extract().response().asString();
		//String newAddress="29, side layout, cohen 09";
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String s=js.get("place_id")	;
		
		  System.out.println(s);
		  
		  
		  
		  
		       //PUT METHOD
		   
		  given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json")
		  
		    .body(AddData.putMethod(s))
		  .when().put("maps/api/place/update/json")
		  .then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		  String newAddress="70 Summer walk, USA";
		  
		             //GET OPERATION
		   
		String resp=given().log().all().queryParam("key","qaclick123").queryParam("place_id",s)
		 
		  
		 . when().get("maps/api/place/get/json")
		 .then().log().all().statusCode(200).extract().response().asString();
		  
		  
		  JsonPath jpath=new JsonPath(resp);
		 String actualadd= jpath.get("address");
		  
		  System.out.println(actualadd);
		  
		  
		  Assert.assertEquals(actualadd,newAddress); 
		  
		  
		  
		  //DELETE METHOD
		  
		  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		  .body(AddData.delete(s))
		  .when().delete("maps/api/place/delete/json")
		  .then().assertThat().statusCode(200).body("status", equalTo("OK"));
		
		    
		
		        // CALLING GET2
		




	given().log().all().queryParam("key","qaclick123").queryParam("place_id",s)
				 
				  
				 . when().get("maps/api/place/get/json")
				 .then().log().all().statusCode(404);
				  
				  
				  /*JsonPath jpath=new JsonPath(re);
				 String actualid= jpath.get("");

	*/



		  
		 }







	}














