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

public class People {
	int jmlrec;
	
	@Given("^Ambil jumlah dari total record saat ini $")
	public void given() throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		
		jmlrec = myArray.length();
	}

	@When("^Ditambahkan sebuah record baru firstName:(.+), lastName:(.+), umur:(\\d+) tahun, hp: (\\d+), no ktp: (\\d*)$")
	public void when(String fn, String ln, int umur, String hp, String noktp) throws Throwable {
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
		jsonStr.append("{\"firstName\": \"" + fn + "\",").
				append("\"lastName\": \"" + ln + "\",").
				append("\"age\": " + umur + ",").
				append("\"regis\": {").
				append("\"noregis\": \"" + noktp + "\"").
				append("}, ").
				append("\"phones\": [{\"phonenumber\": \"" + hp + "\"}]").
				append("}");
		
		@SuppressWarnings("unused")
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:8080/persons/add")
				  .header("Content-Type", "application/json")
				  .header("Accept", "application/json")
				  .body(jsonStr.toString())
				  .asJson();
	}
	
	@When("^Update ")

	@Then("^Total data terakhir yaitu record awal \\+ (\\d+)$")
	public void then(int rec) throws Throwable {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:8080/persons/all")
				.header("Accept", "application/json")
				.asJson();
		JSONArray myArray = jsonResponse.getBody().getArray();
		assertThat(jmlrec+rec, equalTo(myArray.length()));
	}

}

