package restassured;

import org.testng.Assert;

import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class restAssured {
	public void api()
	{
		RestAssured.baseURI = "https://reqres.in"; 
		RequestSpecification request =RestAssured.given();
				  
				  String getpaxrequestjson =
				  "{\r\n \"name\":\""+"Bryant"+"\",\r\n"+"\"job\":\""+"BA"+"\"\r\n}";
				  request.body(getpaxrequestjson); 
				  Response response =request.post("api/users");
				  ResponseBody body = response.getBody();
				  int statusCode = response.getStatusCode(); 
				  Assert.assertEquals(statusCode,
				  "201"); 
				  String successCode = response.jsonPath().get("SuccessCode");
				  Assert.assertEquals( "Correct Success code was returned", successCode,
				  "OPERATION_SUCCESS"); 
				  JsonObject resultjson = new JsonObject(); 
				  resultjson.get("id");
				 
				  }
				 
			
	}


