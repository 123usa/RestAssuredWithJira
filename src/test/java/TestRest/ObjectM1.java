package TestRest;






	import org.testng.Assert;
import org.testng.annotations.Test;

	//import com.jayway.restassured.parsing.Parser;

	import io.restassured.RestAssured;
	import static io.restassured.RestAssured.*;

import java.util.List;

import pojo.Data;
import pojo.Data1;
//import pojo.Data;
//import pojo.Root;
import pojo.Root1;

	public class ObjectM1 {



	@Test
	public void obMapp()
	{
		
		  RestAssured.baseURI="https://reqres.in";
		 // RestAssured.defaultParser=Parser.JSON;
		  
		  Root1 rt1=given().expect()

				  .when().get("/api/users").as(Root1.class);
		
		
		  
		  
		  
		  String s=rt1.toString();
		System.out.println(s);

	System.out.println(rt1.getData().get(1).getEmail());
		
	System.out.println(rt1.getData().get(2).getFirst_name());
	 System.out.println(rt1.getData().get(3).getId()) ;
	 System.out.println(rt1.getAd().getCompany());


	Assert.assertEquals(rt1.getPage(),1);
	Assert.assertEquals(rt1.getData().get(1).getFirst_name(),"Janet");
	Assert.assertEquals(rt1.getData().get(3).getLast_name(),"Holt");


	
	List<Data> data=rt1.getData();
	for(int i=0;i<data.size();i++)
	{
		if(data.get(i).getFirst_name().equalsIgnoreCase("Janet"))
	
				{
			      System.out.println(data.get(i).getId());
			      System.out.println(data.get(i).getEmail());
				}
	
	
	
	
	}
	}



	}


























