package com.shang.test;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class TestCase {
	@Test
	public void test_httpc() throws ClientProtocolException, IOException{
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet("http://www.baidu.com");
	    CloseableHttpResponse response1 = httpclient.execute(httpGet);

	    StatusLine statusLine = response1.getStatusLine();
	    System.out.println(statusLine);
	}
	public static void main(String[] a) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		
		StatusLine statusLine = response1.getStatusLine();
		System.out.println(statusLine);
	}
}
