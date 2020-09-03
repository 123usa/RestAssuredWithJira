package TestRest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;
//import java.nio.file.Files;
import java.nio.file.Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.nio.file.Paths;
//import com.jayway.restassured.RestAssured;

public class AddingBook {

@Test
public void testingBook()
{
	
   RestAssured.baseURI="http://216.10.245.166";
   String res;
try {
	res = given().header("Content-Type","application/json").body(GenerateStringFromResource("C:\\neeru\\workspace\\TryRestAssured\\Addingbook.json"))
	
	        . when().post("Library/AddBbook.php").then().assertThat().statusCode(200).extract().response().asString();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();


	
	JsonPath js=new JsonPath(res);
	
	
}


public static String GenerateStringFromResource(String path) throws IOException



{
	return new String(Files.readAllBytes(paths).get(path));
}












}
