package com.github.gandom.manager;

import java.io.IOException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.gandom.json.JsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.webapi.SteamApiKey;
import com.github.gandom.user.data.Friendslist;
import com.github.gandom.user.data.Games;
import com.github.gandom.user.data.Userlist;

public class GenerateUser {

	private static String summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamids=";
	private static String ownedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";
	private static String friendlist = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";

	public static Userlist providePlayer(String steamid) throws JSONException, IOException {

		String url = summaries + steamid;

		System.out.println(url);

		return (Userlist) JsonToPojo.mapOnPojo(JsonReader.readJsonFromUrl(url).getJSONObject("response"),
				new Userlist());
	}

	public static Games provideGameList(String steamid) throws JSONException, IOException {

		String url = ownedGames + steamid;

		System.out.println(url);
		
		Games games = (Games) JsonToPojo.mapOnPojo(JsonReader.readJsonFromUrl(url).getJSONObject("response"),
				new Games());
		games.setSteamid(steamid);
		
		return games;
	}

	public static Friendslist provideFriendlist(String steamid)
			throws JSONException, IOException {

		String url = friendlist + steamid;

		System.out.println(url);
		
		Friendslist fl = (Friendslist) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(url).getJSONObject("friendslist"), new Friendslist());
		fl.setSteamid(steamid);		

		return fl;
	}

}
