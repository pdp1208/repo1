package RestAssured;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.DataDriven;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RestAssured.reusableMethods;
import googleApis.payLoad;
import googleApis.resources;


public class ExcelDriven {

	DataDriven dataDriven = new DataDriven();
	
@Test(dataProvider="BooksData", priority =1)
public void addBookData(String isbn, String aisle) throws IOException {
		// TODO Auto-generated method stub
	
	ArrayList data=dataDriven.getData("addBookData");
	
	HashMap<String, Object> map = new HashMap<String, Object>();
	
	map.put("name", data.get(1));
	map.put("isbn", data.get(2));
	map.put("aisle", data.get(3));
	map.put("author", data.get(4));
	
		//Base URL or Host
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=given().
		header("Content-Type","application/json").
				body(map).
				when().
				post(resources.addBook()).
				then().log().body().
				assertThat().
				statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();

		
		JsonPath js=reusableMethods.rawToJson(res);
		String s= js.get("ID");
		System.out.println(s);
	}

@Test(dataProvider="BookID", priority =2)
public void deleteBookData(String id) throws IOException {
		// TODO Auto-generated method stub
	ArrayList data=dataDriven.getData("deleteBookData");

	HashMap<String, Object> map = new HashMap<String, Object>();
	
	map.put("ID", data.get(1));
	
		//Base URL or Host
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=given().
		header("Content-Type","application/json").
				body(map).
				when().
				post(resources.deleteBook()).
				then().log().body()
				.assertThat().
				statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		JsonPath js=reusableMethods.rawToJson(res);
		String s= js.get("msg");
		System.out.println(s);
	}

@DataProvider(name="BooksData")
public Object[][] getData()
{
	return new Object[][]{{"12","21"},{"24","42"},{"34","43"}};
	
}

@DataProvider(name="BookID")
public Object[][] getBookID()
{
	return new Object[][]{{"1221"},{"2442"},{"3443"}};
	
}

}
