package com.qa.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestAPI {

	@Test

	public void testApi() {
		Response r = RestAssured.get("http://dummy.restapiexample.com/api/v1/employee/1");

		int status = r.getStatusCode();
		System.out.println("Status Code is " + status);
		Assert.assertEquals(status, 200, "Status not matched");
	}

	@Test
	public void getApi() {

		given().get("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(200)
				.body("data.id[2]", equalTo(3)).log().all();
	}

	@Test
	public void postApi() {
		

		
		JSONObject request =new JSONObject();
		request.put("employee_name", "Tiger Nixon");
		request.put("employee_age", "61");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().body(request.toJSONString()).
		when().post("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(405);
		
		
	}

}
