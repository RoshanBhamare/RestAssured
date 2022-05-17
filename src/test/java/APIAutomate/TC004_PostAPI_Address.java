package APIAutomate;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PostAPI_Address
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
		Params.put("address", "Noida, India");

		
		Request.header("Content-Type","application/json");
		Request.header("Authorization","Bearer"+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJp\r\nZCI6IjYyMjg3NGNiYzVkMDY4ZDBhMzVhOW\r\nJlOSIsImlhdCI6MTY0NjgxODc0MH0.D3fehZF\r\nfC1QvciKBqLvh1KVndm6NE1KvACe9eIFQHx\r\nc ");
		
		Request.body(Params.toJSONString());

		//Response Object
		Response response= Request.request(Method.POST, "/addresses");
		
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is "+ResponseBody);
		
		//Validating Api
		
	String SuccessStatus=response.jsonPath().get("x.success");
	Assert.assertEquals(SuccessStatus,"true");


}
}