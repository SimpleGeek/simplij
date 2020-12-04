package com.simplij.SimpliJ.rest.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient implements AutoCloseable {
	private HttpURLConnection connection;
	
	public RestClient(String url) throws IOException {
		URL u = new URL(url);
		connection = (HttpURLConnection) u.openConnection();
	}
	
	public void get() {
		
	}

	@Override
	public void close() throws Exception {
		connection.disconnect();
	}
}
