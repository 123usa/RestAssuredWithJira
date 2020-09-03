package TestRest;



	
	
	
	
		import static io.restassured.RestAssured.given;



		import java.io.IOException;

		import java.nio.file.Files;

		import java.nio.file.Paths;



		import org.testng.annotations.Test;



		//import files.ReusableMethods;

		//import files.payLoad;

		import io.restassured.RestAssured;

		import io.restassured.path.json.JsonPath;

		import io.restassured.response.Response;


		public class AddinBookCopy {
		//public class StaticJson {

		@Test

		public void addBook() throws IOException



		{



		RestAssured.baseURI="http://216.10.245.166";

		Response resp=given().

		header("Content-Type","application/json").

		body(GenerateStringFromResource("C:\\neeru\\workspace\\TryRestAssured\\Addingbook.json")).

		when().

		post("/Library/Addbook.php").

		then().assertThat().statusCode(200).

		extract().response();
      String s=resp.asString();
		
JsonPath js=new JsonPath(s);


      //JsonPath js= ReusableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);
   String msg=js.get("Msg");
	System.out.println(msg);	   

		   //deleteBOok

		}

		public static String GenerateStringFromResource(String path) throws IOException {



		    return new String(Files.readAllBytes(Paths.get(path)));



		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

















