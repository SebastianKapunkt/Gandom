package com.github.gandom.json;

import java.util.concurrent.Callable;

import org.json.JSONObject;

public class CallableJsonReader implements Callable<JSONObject>{

	private String url;

	@Override
	public JSONObject call() throws Exception {
		System.out.println(url);
		return JsonReader.readJsonFromUrl(url);
	}

	public CallableJsonReader() {
		url = null;
	}
	
	public CallableJsonReader(String url){
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
