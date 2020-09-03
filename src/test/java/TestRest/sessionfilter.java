package TestRest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class sessionfilter {

@Test
public void sessionRecooding()
{
  RestAssured.baseURI=("http://localhost:8085");
  
   SessionFilter session=new SessionFilter();
  
 String s= given().header("Content-Type","application/json").body("{ \r\n" + 
   		"    \r\n" + 
   		" \"username\": \"kallamreetu214\", \r\n" + 
   		"\"password\": \"reetu214\" \r\n" + 
   		"}").log().all().
       filter(session).when().post("rest/auth/1/session").
       then().log().all().assertThat().statusCode(200).extract().response().asString();

 System.out.println(s);



  String spost=   given().header("Content-Type","application/json").body("{\r\n" + 
     		"  \"fields\":{\r\n" + 
     		"    \"project\" : \r\n" + 
     		"    {\r\n" + 
     		"       \"key\" :\"NEERU123\"\r\n" + 
     		"    },\r\n" + 
     		"    \"summary\" : \"This is the new REST API issue creating 2nd time\",\r\n" + 
     		"    \"description\":\"This is the problem when we are hitting with server.so,we are creating bug\",\r\n" + 
     		"    \"issuetype\" :{\r\n" + 
     		"      \"name\" :\"Bug\"\r\n" + 
     		"    }\r\n" + 
     		"\r\n" + 
     		"    \r\n" + 
     		"    \r\n" + 
     		"  }\r\n" + 
     		"}").
     
     
        
     log().all().filter(session).

    when().post("rest/api/2/issue").
    then().log().all().statusCode(201).extract().response().asString();
  

  System.out.println("spost");
JsonPath js=new JsonPath(spost);
 String sid=js.getString("id");
   String expectedmesg="hi,this is new comment we are adding it here";
 
 String comm=given().pathParam("key",sid).header("Content-Type","application/json").
  body("{\r\n" + 
  		"    \"body\": \""+expectedmesg+"\",\r\n" + 
  		"    \"visibility\": {\r\n" + 
  		"        \"type\": \"role\",\r\n" + 
  		"        \"value\": \"Administrators\"\r\n" + 
  		"    }\r\n" + 
  		"}").
    log().all().filter(session).when().post("rest/api/2/issue/{key}/comment").then().log().all().
    statusCode(201).extract().response().asString();

  System.out.println(comm);
     JsonPath js1=new JsonPath(comm);
   String commentId=  js1.getString("id");

     
   
   //Add Attachment


   given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", sid)

.header("Content-Type","multipart/form-data")

.multiPart("file",new File("jira.txt")).when().

post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);

  //Get Issue

String issueDetails=given().filter(session).pathParam("key", sid)

.queryParam("fields", "comment")

.log().all().when().get("/rest/api/2/issue/{key}").then()


.log().all().extract().response().asString();

System.out.println(issueDetails);

/*sonPath js2 =new JsonPath(issueDetails);

int commentsCount=js2.getInt("fields.comment.comments.size()");

for(int i=0;i<commentsCount;i++)

{

String commentIdIssue =js1.get("fields.comment.comments["+i+"].id").toString();

if (commentIdIssue.equalsIgnoreCase(commentId))

{

String message= js1.get("fields.comment.comments["+i+"].body").toString();

System.out.println(message);

Assert.assertEquals(message, expectedmesg);*/

}













}
