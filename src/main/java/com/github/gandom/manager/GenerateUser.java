package com.github.gandom.manager;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.gandom.data.Friend;
import com.github.gandom.data.Game;
import com.github.gandom.data.Player;
import com.github.gandom.data.User;
import com.github.gandom.json.JsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.steam.data.ResponseFromFriendlist;
import com.github.gandom.steam.data.ResponseFromGame;
import com.github.gandom.steam.data.ResponseFromPlayer;
import com.github.gandom.steam.data.SteamApiKey;

public class GenerateUser {

	private static String summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamids=";
	private static String ownedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";
	private static String friendlist = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";

	public static User User(String steamid) throws JsonParseException, JsonMappingException, IOException {
		User user = new User();

		user.setSteamId(steamid);

		user.setFriendlist(provideFriendlist(friendlist + steamid));
		user.setGames(provideGameList(ownedGames + steamid));
		user.setPlayer(providePlayer(summaries + steamid));

		return user;
	}

	private static Player providePlayer(String url) throws JsonParseException,
			JsonMappingException, JSONException, IOException {

		System.out.println(url);

		ResponseFromPlayer response = (ResponseFromPlayer) JsonToPojo
				.mapOnPojo(JsonReader.readJsonFromUrl(url),
						new ResponseFromPlayer());

		return response.getResponse().getPlayers().iterator().next();
	}

	private static Set<Game> provideGameList(String url)
			throws JsonParseException, JsonMappingException, JSONException,
			IOException {

		System.out.println(url);

		ResponseFromGame response = (ResponseFromGame) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(url), new ResponseFromGame());

		return response.getResponse().getGames();
	}

	private static Set<Friend> provideFriendlist(String url)
			throws JsonParseException, JsonMappingException, IOException {

		System.out.println(url);

		ResponseFromFriendlist response = (ResponseFromFriendlist) JsonToPojo
				.mapOnPojo(JsonReader.readJsonFromUrl(url),
						new ResponseFromFriendlist());

		return response.getFriendslist().getFriends();
	}

}
