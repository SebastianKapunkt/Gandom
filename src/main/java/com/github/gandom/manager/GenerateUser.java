package com.github.gandom.manager;

import java.io.IOException;

import org.json.JSONException;

import com.github.gandom.json.JsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.webapi.SteamApiKey;
import com.github.gandom.user.data.FriendsList;
import com.github.gandom.user.data.Games;
import com.github.gandom.user.data.UserList;

public class GenerateUser {

	private static String summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamids=";
	private static String ownedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";
	private static String friendList = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";

	public static UserList providePlayer(String steamId) throws JSONException, IOException {

		String url = summaries + steamId;

		System.out.println(url);

		return (UserList) JsonToPojo.mapOnPojo(JsonReader.readJsonFromUrl(url).getJSONObject("response"),
				new UserList());
	}

	public static Games provideGameList(String steamId) throws JSONException, IOException {

		String url = ownedGames + steamId;

		System.out.println(url);
		
		Games games = (Games) JsonToPojo.mapOnPojo(JsonReader.readJsonFromUrl(url).getJSONObject("response"),
				new Games());
		games.setSteamid(steamId);
		
		return games;
	}

	public static FriendsList provideFriendList(String steamId)
			throws JSONException, IOException {

		String url = friendList + steamId;

		System.out.println(url);
		
		FriendsList fl = (FriendsList) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(url).getJSONObject("friends-list"), new FriendsList());
		fl.setSteamid(steamId);

		return fl;
	}

}
