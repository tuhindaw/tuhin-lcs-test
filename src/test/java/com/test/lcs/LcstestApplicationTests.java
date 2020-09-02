package com.test.lcs;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

/**
 * Comcast coding assignment
 * Created by Tuhin Kumar Daw (tuhin.daw@gmail.com) on 09/01/2020
 */
@SpringBootTest
class LcstestApplicationTests {

	@Test
	void contextLoads() {
	}

	private static final String URL = "http://localhost:8080/api/substring/lcs";

	@Test
	public void whenSendPostRequestWithUniqueSetOfStrings_thenReturnOk()
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(URL);

		String json = "{\"setOfStrings\":[{\"value\":\"comcast\"},{\"value\":\"comcastica\"},{\"value\":\"broadcaster\"}]}";
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);

		Assertions.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

		client.close();
	}

	@Test
	public void whenSendPostRequestWithDuplicateStrings_thenReturnBadRequest()
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(URL);

		String json = "{\"setOfStrings\":[{\"value\":\"comcast\"},{\"value\":\"comcast\"},{\"value\":\"broadcaster\"}]}";
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);

		Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusLine().getStatusCode());

		client.close();
	}

	@Test
	public void whenSendPostRequestWithoutInputString_thenReturnBadRequest()
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(URL);

		String json = "{\"setOfStrings\":[]}";
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);

		Assertions.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusLine().getStatusCode());

		client.close();
	}

}
