package Tests;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;


public class TestCRUD {
 String URL="https://reqres.in/api";
 @Test	
 public void getRequest() {
		Response response= RestAssured.get(URL+"/users?page=2");
		System.out.println("Response Body: "+ response.getBody().asString());
		System.out.println("Status code is: "+ response.getStatusCode());
		System.out.println("Response time is: "+response.getTime());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
 @Test
 public void postRequest() {
	 JSONObject request=new JSONObject();
	 request.put("first_name", "Khalid");
	 request.put("last_name", "kmkm");
	 
	
given().
body(request.toJSONString()).
when().post(URL+"/users").then().statusCode(201);
	

		
		
	}
 @Test
 public void putRequest() {
	 JSONObject request=new JSONObject();
	 request.put("first_name", "Khalid");
	 request.put("last_name", "kmkm");
	
	
given().
header("Content-Type", "application/json"). // Add the Json to the body of the request 
contentType(ContentType.JSON).
accept(ContentType.JSON).
body(request.toJSONString())
.when().put("https://reqres.in/api/users/2").then().statusCode(200);
	
		
		
	}
 @Test
 public void deleteRequest() {
	
when()
.delete(URL+"/api/users/2")
.then().statusCode(204);
	
		
		
	}
}
