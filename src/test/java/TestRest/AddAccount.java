package TestRest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.AddData;

import static io.restassured.RestAssured.*;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAccount {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
@Test
	  public void addAcc()
	  {
		  
		RestAssured.baseURI="http://216.10.245.166";
	
	//POST METHOD
	String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Frontline house\",\r\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
			"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"shoe park\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"http://google.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"")
			
			
			.when().post("maps/api/place/add/json")
	           .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).body(containsString("status"))
	          .extract().response().asString();
	//String newAddress="29, side layout, cohen 09";
	System.out.println(response);
	
	JsonPath js=new JsonPath(response);
	String s=js.get("place_id")	;
	
	  System.out.println(s);
	  
	  
	  
	  
	       //PUT METHOD
	   
	  given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json").
	  
	    body("{\r\n" + 
	    		"\"place_id\":\""+s+"\",\r\n" + 
	    		"\"address\":\"70 Summer walk, USA\",\r\n" + 
	    		"\"key\":\"qaclick123\"\r\n" + 
	    		"}\r\n" + 
	    		"")
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
	  .body("{\r\n" + 
	  		"    \"place_id\":\""+s+"\"\r\n" + 
	  		"}\r\n" + 
	  		"")
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
