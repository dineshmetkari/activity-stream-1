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

public class CircleStepDefinition {
	
		HttpClient client = new DefaultHttpClient();
		static HttpResponse httpResponse = null;
		static String responseString = null;
		
		@When("^user sends a POST request to create circle with \"(.*?)\" with following JSON:$")
		public void user_sends_a_POST_request_to_create_circle_with_with_following_JSON(String url, String jsonValue) throws Throwable {
		 
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();
			  HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig);
			  
			  HttpPost request=new HttpPost(url);
			  request.addHeader("content-type", "application/json");
			  request.setEntity(new StringEntity(jsonValue));
			  
			  httpResponse = builder.build().execute(request);
			  
			  HttpEntity entity=httpResponse.getEntity();
			  responseString=EntityUtils.toString(entity);
			
		}
		
		
		@Then("^response should contain circle id \"(.*?)\"$")
		public void response_should_contain_circle_id(String arg1) throws Throwable {
		    
		}

		@Then("^response should contain circle name \"(.*?)\"$")
		public void response_should_contain_circle_name(String arg1) throws Throwable {
		    
		}

		@Then("^response should contain circle adminID \"(.*?)\"$")
		public void response_should_contain_circle_adminID(String arg1) throws Throwable {
		    
		}

	
	
}
