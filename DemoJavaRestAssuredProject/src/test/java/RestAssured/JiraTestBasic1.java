package RestAssured;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RestAssured.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jiraApis.payLoad;
import jiraApis.resources;

public class JiraTestBasic1 {

	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException {

		//System.getProperty("user.dir")=C://Work//DemoJavaRestAssuredProject//src//main//java//resources
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		prop.load(fis);
	}

	
	@Test
	public void createAnIssueInJira() {

		RestAssured.baseURI = prop.getProperty("JIRAHOME");

		Response res = given()
				.header("Content-Type", "Application/json")
				.header("Cookie", "JSESSIONID=" + reusableMethods.getJiraSessionKey())
				.body(payLoad.addBugBody())
				.when()
				.post(resources.addBugResource())
				.then()
				.assertThat()
				.statusCode(201)
				.and()
				.contentType(ContentType.JSON)
				.extract()
				.response();

		JsonPath js = reusableMethods.rawToJson(res);
		String id = js.get("id");
		System.out.println(id);
	}

	@Test
	public void addCommentForIssueInJira() {

		RestAssured.baseURI = prop.getProperty("JIRAHOME");

		Response res = given()
				.header("Content-Type", "Application/json")
				.header("Cookie", "JSESSIONID=" + reusableMethods.getJiraSessionKey())
				.body(payLoad.addCommentForBugBody())
				.when()
				.post("rest/api/2/issue/" + reusableMethods.GetBugId() + "/comment")
				.then()
				.assertThat()
				.statusCode(201)
				.and()
				.contentType(ContentType.JSON)
				.extract()
				.response();

		JsonPath js = reusableMethods.rawToJson(res);
		String id = js.get("id");
		System.out.println(id);
	}

	@Test
	public void updateCommentForIssueInJira() {

		String budId = reusableMethods.GetBugId();
		RestAssured.baseURI = prop.getProperty("JIRAHOME");

		Response res = given()
				.header("Content-Type", "Application/json")
				.header("Cookie", "JSESSIONID=" + reusableMethods.getJiraSessionKey())
				.body(payLoad.updateCommentInBugPayload())
				.when()
				.put("rest/api/2/issue/" + budId + "/comment/" + reusableMethods.getCommentId(budId))
				.then()
				.log()
				.body()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		
		
		JsonPath js = reusableMethods.rawToJson(res);
		String id = js.get("id");
		System.out.println(id);
	
	}
}
