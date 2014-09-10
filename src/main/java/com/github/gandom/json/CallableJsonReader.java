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
	
	public CallableJsonReader(String url){
		this.url = url;
	}
	
}
