package TestRest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payload.AddData;

public class ValidateValues {

@Test
public void validateVal()
{
	int amt=0;
  JsonPath js=new JsonPath(AddData.verifiedJson())	;
  
	  //print no. of courses
  int count=js.getInt("courses.size()");
  System.out.println(count);
  
	int price=js.getInt("dashboard.purchaseAmount");
	System.out.println(price);
	
	
	
	  //get the 1st course title
	String courtitle=js.getString("courses[0].title");
	
	System.out.println(courtitle);
  //get all the course titles and their prices
	
	for(int i=0;i<count;i++)
	{

	  String s=js.getString("courses["+i+"].title" );
	   System.out.println(s);


     int p=js.getInt("courses["+i+"].price");
	   System.out.println(p);
	   
	   int copy=js.getInt("courses["+i+"].copies");
	   System.out.println(copy);
	   
       System.out.println("\n");
	
	}
	
	
	 //PRICE FOR RPA COURSE
	
	for(int i=0;i<count;i++)
	{
       
      String str=js.getString("courses["+i+"].title");

      if(str.equalsIgnoreCase("RPA"))
      {
    	  
    	  int p=js.getInt("courses["+i+"].price");
    	 		
         System.out.println(p);

      }
	}



     //get the total amount
	for(int i=0;i<count;i++)
	{



	    int pr=js.getInt("courses["+i+"].price");
	
	   int copy=js.getInt("courses["+i+"].copies");
	    
	     int sum=pr*copy;
	     //int amt=0;
	     
	  amt=amt+sum;
	
	//System.out.println(amt);
	
	
	}
	System.out.println("\n");
	System.out.println(amt);
	
	
  Assert.assertEquals(amt, price);






}
}	
	
