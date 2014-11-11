package com.github.gandom.webapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SteamApiKey {
	private static String steamApiKey;
	private static String OS = null;
	private static String path;

	@SuppressWarnings("resource")
	public static String getSteamApiKey() {

		if (isWindows()) {
			path = "C:/Users/Visores/Google Drive/Privat/mySteamAPIKey.txt";
		} else {
			path = "/Users/TheDeveloper/Development/mySteamAPIKey.txt";
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			steamApiKey = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return steamApiKey;
	}

	public static String getOsName() {
		if (OS == null) {
			OS = System.getProperty("os.name");
		}
		return OS;
	}

	public static boolean isWindows() {
		return getOsName().startsWith("Windows");
	}
	
}