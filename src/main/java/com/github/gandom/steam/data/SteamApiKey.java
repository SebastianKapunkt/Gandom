package com.github.gandom.steam.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SteamApiKey {
	private String steamApiKey;
	
	public String getSteamApiKey() {
		return steamApiKey;
	}
	
	public SteamApiKey(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/Users/TheDeveloper/Development/mySteamAPIKey.txt"));
			steamApiKey = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
