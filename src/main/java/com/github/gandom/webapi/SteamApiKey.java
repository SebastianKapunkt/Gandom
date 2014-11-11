package com.github.gandom.webapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SteamApiKey {
	private static String steamApiKey;

	@SuppressWarnings("resource")
	public static String getSteamApiKey() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"/Users/TheDeveloper/Development/mySteamAPIKey.txt"));
			// Windows C:/Users/Visores/Google Drive/Privat/mySteamAPIKey.txt
			steamApiKey = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return steamApiKey;
	}
}