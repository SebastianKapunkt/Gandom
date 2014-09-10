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

	private static String Summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamids=";
	private static String OwnedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";
	private static String Friendlist = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key="
			+ SteamApiKey.getSteamApiKey() + "&steamid=";

	public static User User(String steamid) {
		User user = new User();

		user.setSteamId(steamid);

		try {
			user.setFriendlist(provideFriendlist(steamid));
			user.setGames(provideGameList(steamid));
			user.setPlayer(providePlayer(steamid));
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		return user;
	}

	private static Player providePlayer(String steamid)
			throws JsonParseException, JsonMappingException, JSONException,
			IOException {

		String summaries = GenerateUser.Summaries + steamid;

		System.out.println(summaries);

		ResponseFromPlayer response = new ResponseFromPlayer();

		response = (ResponseFromPlayer) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(summaries), new ResponseFromPlayer());

		return response.getResponse().getPlayers().iterator().next();
	}

	private static Set<Game> provideGameList(String steamid)
			throws JsonParseException, JsonMappingException, JSONException,
			IOException {

		String ownedGames = GenerateUser.OwnedGames + steamid;

		System.out.println(ownedGames);

		ResponseFromGame response = new ResponseFromGame();

		response = (ResponseFromGame) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(ownedGames), new ResponseFromGame());

		return response.getResponse().getGames();
	}

	private static Set<Friend> provideFriendlist(String steamid)
			throws JsonParseException, JsonMappingException, IOException {

		String friendlist = GenerateUser.Friendlist + steamid;

		System.out.println(friendlist);

		ResponseFromFriendlist response = new ResponseFromFriendlist();

		response = (ResponseFromFriendlist) JsonToPojo.mapOnPojo(
				JsonReader.readJsonFromUrl(friendlist),
				new ResponseFromFriendlist());
		
		return response.getFriendslist().getFriends();
	}

}
