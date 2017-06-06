package com.stackroute.activity.test.stepdefinitions;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;

public class UserStepDefinition {
	
		HttpClient client = new DefaultHttpClient();
		static HttpResponse httpResponse = null;
		static String responseString = null;
	
	@When("^user sends a GET request with \"(.*?)\"$")
	public void user_sends_a_GET_request_with(String url) throws Throwable {
		
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();
		  HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig);
		  
		  HttpUriRequest request = new HttpGet(url);
		  httpResponse = builder.build().execute(request);
		  
		  HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);
	}
		

	@Then("^status code should be (\\d+)$")
	public void status_code_should_be(int statuscode) throws ClientProtocolException,IOException {
		assertEquals(statuscode, httpResponse.getStatusLine().getStatusCode());
	}

	@Then("^response type should be \"(.*?)\"$")
	public void response_type_should_be(String type) throws Throwable {
		String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
	    assertTrue(mimeType.contains(type));
	}

	@Then("^response should be following JSON:$")
	public void response_should_be_following_JSON(String jsonExpected) throws Throwable {
		
		  /*HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);*/
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(jsonExpected);
		  JsonElement jsonRet=parser.parse(responseString);
		  Assert.assertEquals(jsonExp,jsonRet);
	}
	
	@Then("^response should be empty$")
	  public void response_should_be_empty() throws Throwable {
		  
		  /*HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);*/
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse("[]");
		  JsonElement jsonRet=parser.parse(responseString);
		  Assert.assertEquals(jsonExp,jsonRet);
		  
	  }
	
	@Then("^response is not matching following JSON:$")
	  public void response_is_not_matching_following_JSON(String jsonExpected) throws Throwable {
		  
		  /*HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);*/
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(jsonExpected);
		  JsonElement jsonRet=parser.parse(responseString);
		  Assert.assertNotEquals(jsonExp,jsonRet);
	  }
	
	@Then("^response should be following user JSON:$")
	  public void response_should_be_following_user_JSON(String jsonExpected) throws Throwable {
	      
		  /*HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);*/
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(jsonExpected);
		  JsonElement jsonRet=parser.parse(responseString);
		  Assert.assertEquals(jsonExp,jsonRet);
	  }
	
	
	 @When("^user sends a POST request with \"(.*?)\" with following JSON:$")
	  public void user_sends_a_POST_request_with_with_following_JSON(String url, String jsonValue) throws Throwable {
		  RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();
		  HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig);
		  
		  HttpPost request=new HttpPost(url);
		  request.addHeader("content-type", "application/json");
		  request.setEntity(new StringEntity(jsonValue));
		  
		  httpResponse = builder.build().execute(request);
		  
		  HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);
	  }
	 
	 
	 @When("^user sends a PUT request with \"(.*?)\" with following JSON:$")
	  public void user_sends_a_PUT_request_with_with_following_JSON(String url, String jsonValue) throws Throwable {
		  RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();
		  HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig);
		  
		  HttpPut request=new HttpPut(url);
		  request.addHeader("content-type", "application/json");
		  request.setEntity(new StringEntity(jsonValue));
		  
		  httpResponse = builder.build().execute(request);
		  
		  HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);
	  }

	  @Then("^response is matching following JSON:$")
	  public void response_is_matching_following_JSON(String jsonExpected) throws Throwable {
		  
		  /*HttpEntity entity=httpResponse.getEntity();
		  responseString=EntityUtils.toString(entity);*/
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(jsonExpected);
		  JsonElement jsonRet=parser.parse(responseString);
		  Assert.assertEquals(jsonExp,jsonRet);
		  
	  }
	  
	  
	  @Then("^errorCode should be \"(.*?)\"$")
	  public void errorcode_should_be(String expectedErrorCode) throws Throwable {
		  //HttpEntity entity=httpResponse.getEntity();
		  //responseString=EntityUtils.toString(entity);
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(responseString);
		  JsonObject src=jsonExp.getAsJsonObject();
		  String errorCode=null;
		  try{
			  errorCode=src.get("errorCode").getAsString();
			  Assert.assertEquals(expectedErrorCode,errorCode);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
			  
		  
	  }

	  @Then("^errorMessage should be \"(.*?)\"$")
	  public void errormessage_should_be(String expectedErrorMessage) throws Throwable {
		  //HttpEntity entity=httpResponse.getEntity();
		  //String responseString=EntityUtils.toString(entity);
		  JsonParser parser=new JsonParser();
		  JsonElement jsonExp=parser.parse(responseString);
		  JsonObject src=jsonExp.getAsJsonObject();
		  String errorMessage=null;
		  try{
			  errorMessage=src.get("errorMessage").getAsString();
			  Assert.assertEquals(expectedErrorMessage,errorMessage);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
	  }

}
