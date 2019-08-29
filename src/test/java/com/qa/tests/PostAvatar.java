package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;

public class PostAvatar {
	
	
	String URL ="https://reqres.in/api/users";
	
	public CloseableHttpResponse PostRest(String url,String entitystring) throws ClientProtocolException, IOException {
		
		
			CloseableHttpClient Httpclient = HttpClients.createDefault();
			
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(new StringEntity(entitystring));
		
		CloseableHttpResponse closableHttpResponse = Httpclient.execute(httppost);
		return closableHttpResponse;

	}
	
	
	
	@Test
	public void execution() throws ClientProtocolException, IOException {
		
		PostAvatar PA = new PostAvatar();
		
		ObjectMapper mapper = new ObjectMapper();
		avatar av = new avatar("Sindhusha","Pericharla");
		
			mapper.writeValue(new File("C:\\Users\\Sindhusha_Pericharla\\eclipse-workspace\\restapi\\src\\test\\java\\com\\qa\\tests\\AvatarJson.json"), av);
			String responseString = mapper.writeValueAsString(av);
			
			System.out.println(responseString);
		

			CloseableHttpResponse closableHttpResponse= PA.PostRest(URL, responseString);
			
			//Status
			
			int statuscode = closableHttpResponse.getStatusLine().getStatusCode();
			System.out.println(statuscode);
			
			//Jsonstring
			
			
			String stringjson = EntityUtils.toString(closableHttpResponse.getEntity(),"UTF-8");
			System.out.println(stringjson);
			JSONObject JsonObject = new JSONObject(stringjson);	
			System.out.println(JsonObject);
			
		
		
	}
	

}
