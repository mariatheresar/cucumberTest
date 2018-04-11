package com.example.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.json.JSONArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class PeopleDeletePhone {
	int jmlrec;
	
	@Given("^Ambil semua record saat ini$")
	public void given() throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		
		jmlrec = myArray.length();
	}

	@When("^Menghapus nomor hp pada id: (\\d+)$")
	public void when(int id) throws Throwable {
		/*{
		    "firstName": "Testing",
		    "lastName": "Lagi",
		    "age": 2,
		    "regis": {
		        "noregis": "123123"
		    },
		    "phones": [{
		        "phonenumber": "084657373123"
		    }]
		}*/
		
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("\"id\": " + id);
		
		@SuppressWarnings("unused")
		HttpResponse<JsonNode> jsonResponse = Unirest.delete("http://localhost:8080/persons/delphone/{id}")
				  .header("Content-Type", "application/json")
				  .header("Accept", "application/json")
				  .body(jsonStr.toString())
				  .asJson();
	}
	
	//@When("^Update ")

	@Then("^Total dari data terakhir adalah record awal \\- (\\d+)$")
	public void then(int rec) throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		assertThat(jmlrec+rec, equalTo(myArray.length()));
	}

}

