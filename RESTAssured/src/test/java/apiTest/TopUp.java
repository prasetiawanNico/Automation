package apiTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

public class TopUp extends IncrementInteger {
	
	@Test
	public void BCA() {

		JSONObject request = new JSONObject();
		

		
		request.put("binNumber", "39993");
		request.put("vaNo", "39993081317380755");
		request.put("amount", "50000");
		request.put("currency", "IDR");
		request.put("deliveryChannelType", "102");
		request.put("traceNo", increment());
		request.put("transmissionDateTime", "0202141433");
		request.put("terminalId", "00002");
		request.put("reference", "7838820150204104854");

		baseURI = "https://psmw.gpay.digital";

		Header x = new Header("Authorization", "Bearer CA9509B682A6F3AB076955A1E1C512E5ABF6FAE04BDCC8B0");

		given(). 
			header(x).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/dev_maybank_va/payment").
		then().
			statusCode(200).
			log().all();

	}
}
