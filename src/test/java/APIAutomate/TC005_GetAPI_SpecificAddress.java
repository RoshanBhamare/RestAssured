package APIAutomate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GetAPI_SpecificAddress {

	@Test
	void getApiAutomate()
	{
		//Base Uri
		RestAssured.baseURI = "http://193.93.248.235:5001";
		// Request Object
		RequestSpecification Request = RestAssured.given();
		Request.header("Authorization","Bearer"+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJp\r\nZCI6IjYyMjg3NGNiYzVkMDY4ZDBhMzVhOW\r\nJlOSIsImlhdCI6MTY0NjgxODc0MH0.D3fehZF\r\nfC1QvciKBqLvh1KVndm6NE1KvACe9eIFQHx\r\nc ");

		//Response Object
		Response response= Request.request(Method.GET, "/address/62287735c5d068d0a35a9bf2");
		
		
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is "+ResponseBody);
		//validation
		String SuccessStatus=response.jsonPath().get("x.success");
		Assert.assertEquals(SuccessStatus,"true");
	}

}
