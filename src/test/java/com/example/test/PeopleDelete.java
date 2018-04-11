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

public class PeopleDelete {
	int jmlrec;
	
	@Given("^Ambil jumlah total record saat ini$")
	public void given() throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		
		jmlrec = myArray.length();
	}

	@When("^Delete id: (\\d+)$")
	public void when(int id) throws Throwable {
		/*if (!isDeleted) {
		return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("\"id\": " + id);
		
		@SuppressWarnings("unused")
		HttpResponse<JsonNode> jsonResponse = Unirest.delete("http://localhost:8080/persons/delete/"+id)
				  .header("Content-Type", "application/json")
				  .header("Accept", "application/json")
				  .body(jsonStr.toString())
				  .asJson();
	}
	
	//@When("^Update ")

	@Then("^total data terakhir adalah record awal \\- (\\d+)$")
	public void then(int rec) throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		assertThat(jmlrec-rec, equalTo(myArray.length()));
	}

}
