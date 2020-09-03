package TestRest;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class PostUsingMap {

@Test

public void postUsing()
{

RestAssured.baseURI="http://216.10.245.166";

//HashMap<String,Integer> map=new HashMap<String,Integer>();
HashMap<String,String> req=new HashMap<String,String>();

  req.put("name","Learn Automation with MOobile");

   req.put("isbn","bbccc");


   req.put("aisle","21011");
   req.put("author","bcan");


  String sp=given().

             header("Content-Type","application/json").

           body(req).

           when().

            post("/Library/Addbook.php").

           then().log().all().assertThat().statusCode(200).

           extract().response().asString();

}



}
