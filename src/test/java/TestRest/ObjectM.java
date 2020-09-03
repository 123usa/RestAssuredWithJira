package TestRest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.parsing.Parser;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import pojo.Root;

public class ObjectM {

@Test
public void obMapp()
{
	
	  RestAssured.baseURI="https://reqres.in";
	 // RestAssured.defaultParser=Parser.JSON;
	  
	  Root rt=given().expect()

			  .when().get("/api/users/4").as(Root.class);
	
	String s=rt.toString();
	System.out.println(s);

System.out.println(rt.getData().getEmail());
	
System.out.println(rt.getData().getFirst_name());
 System.out.println(rt.getData().getId()) ;
 System.out.println(rt.getAd().getCompany());

Assert.assertEquals(rt.getData().getId(),4);
}
}