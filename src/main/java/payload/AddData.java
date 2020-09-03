package payload;

public class AddData {

   public static String addMethod()
   {
	   String s="{\r\n" + 
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
	   		"";
	   
     return s;
   
   
   
   }


  public static String putMethod(String s)
  
  {
	  
      String p="{\r\n" + 
      		"\"place_id\":\""+s+"\",\r\n" + 
      		"\"address\":\"70 Summer walk, USA\",\r\n" + 
      		"\"key\":\"qaclick123\"\r\n" + 
      		"}\r\n" + 
      		"";
     
  return p;
  
  }


  public static String delete(String s)
  {
	  
	   String p="{\r\n" + 
	   		"    \"place_id\":\""+s+""
	   				+ ""
	   				+ ""
	   				+ "\"\r\n" + 
	   		"}\r\n" + 
	   		"";
	  
	  return p;
	  
	  
  }
  
  
  public static String verifiedJson()
  {
	  String s ="{\r\n" + 
	  		"\r\n" + 
	  		"\"dashboard\": {\r\n" + 
	  		"\r\n" + 
	  		"\"purchaseAmount\": 910,\r\n" + 
	  		"\r\n" + 
	  		"\"website\": \"yaminiacademy.com\"\r\n" + 
	  		"\r\n" + 
	  		"},\r\n" + 
	  		"\r\n" + 
	  		"\"courses\": [\r\n" + 
	  		"\r\n" + 
	  		"{\r\n" + 
	  		"\r\n" + 
	  		"\"title\": \"Selenium Python\",\r\n" + 
	  		"\r\n" + 
	  		"\"price\": 50,\r\n" + 
	  		"\r\n" + 
	  		"\"copies\": 6\r\n" + 
	  		"\r\n" + 
	  		"},\r\n" + 
	  		"\r\n" + 
	  		"{\r\n" + 
	  		"\r\n" + 
	  		"\"title\": \"Cypress\",\r\n" + 
	  		"\r\n" + 
	  		"\"price\": 40,\r\n" + 
	  		"\r\n" + 
	  		"\"copies\": 4\r\n" + 
	  		"\r\n" + 
	  		"},\r\n" + 
	  		"\r\n" + 
	  		"{\r\n" + 
	  		"\r\n" + 
	  		"\"title\": \"RPA\",\r\n" + 
	  		"\r\n" + 
	  		"\"price\": 45,\r\n" + 
	  		"\r\n" + 
	  		"\"copies\": 10\r\n" + 
	  		"\r\n" + 
	  		"}\r\n" + 
	  		"\r\n" + 
	  		"]\r\n" + 
	  		"\r\n" + 
	  		"}\r\n" + 
	  		"\r\n" + 
	  		"";
	  
    return s;
    
  
  }
  
  
  
  
  

}
