package RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleApis.payLoad;
import googleApis.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class basic2 {

	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		prop.load(fis);

	}

	@Test
	public void test() {

		RestAssured.baseURI = prop.getProperty("HOST");
		given()
		.queryParam("key", prop.getProperty("KEY")).body(payLoad.getPostData())
		.when()
		.post(resources.placePostData())
		.then()
		.assertThat().statusCode(200).and()
		.contentType(ContentType.JSON).and().body("status", equalTo("OK"));

		// Grab the place-Id and use the same in delete place API
	}
}
