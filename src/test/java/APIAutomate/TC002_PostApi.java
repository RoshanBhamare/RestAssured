package APIAutomate;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PostApi
{
	@SuppressWarnings("unchecked")
	@Test
	void getApiAutomate()
	{
		//Base Uri
		RestAssured.baseURI = "http://193.93.248.235:5001";
		// Request Object
		RequestSpecification Request = RestAssured.given();
		
		JSONObject Params= new JSONObject();
		Params.put("username", "voereir-test0712");
		Params.put("email", "roshantest@gmail.com");
		Params.put("password", "test123");
		
		Request.header("Content-Type","application/json");
		Request.body(Params.toJSONString());

		//Response Object
		Response response= Request.request(Method.POST, "/user/signup");
		
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is "+ResponseBody);
		
		//Validating 
		
	String SuccessStatus=response.jsonPath().get("username");
	Assert.assertEquals(SuccessStatus,"voereir-test0712");

	}

}
