package apiTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAndPost {
	
	
	public static void increment() {
		
		int value = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader("value.txt"));
			value = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (IOException e) {
			// If file doesn't exist or can't be read, just start with 0.
		} catch (NumberFormatException e) {
			// If file contains invalid data, just start with 0.
		}

		value++;

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("value.txt"));
			writer.write(Integer.toString(value));
			writer.close();
		} catch (IOException e) {
			// If file can't be written to, just print the value to the console.
			System.out.println(value);
		}

		//System.out.println("New value is: " + value);
		
	}
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Nico");
//		map.put("job", "President");
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Nico");
		request.put("job", "xxx");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
	
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users/").
		then().
			statusCode(201).
			log().all();
		  
		
	}
	

}
