package com.github.gandom.manager;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.github.gandom.data.Friend;
import com.github.gandom.data.Game;
import com.github.gandom.data.Player;
import com.github.gandom.data.User;
import com.github.gandom.json.JsonConverter;
import com.github.gandom.json.JsonReader;
import com.github.gandom.steam.data.ResponseFromFriendlist;
import com.github.gandom.steam.data.ResponseFromGame;
import com.github.gandom.steam.data.ResponseFromPlayer;
import com.github.gandom.steam.data.SteamApiKey;

public class GenerateUser {

	private static StringBuilder Summaries = new StringBuilder(
			"http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=");
	private static StringBuilder OwnedGames = new StringBuilder(
			"http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=");
	private static StringBuilder Friendlist = new StringBuilder(
			"http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=");
	private static SteamApiKey apiKey = new SteamApiKey();

	private User user = new User();

	public User User(String steamid) {
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

	private Player providePlayer(String steamid) throws JsonParseException,
			JsonMappingException, JSONException, IOException {

		Summaries.append(apiKey.getSteamApiKey()).append("&steamids=")
				.append(steamid);

		System.out.println(Summaries);
		
		ResponseFromPlayer response = new ResponseFromPlayer();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(unnamed(Summaries.toString())),
				ResponseFromPlayer.class);
		return response.getResponse().getPlayers().iterator().next();
	}

	private Set<Game> provideGameList(String steamid)
			throws JsonParseException, JsonMappingException, JSONException,
			IOException {

		OwnedGames.append(apiKey.getSteamApiKey()).append("&steamid=")
				.append(steamid);

		System.out.println(OwnedGames);
		
		ResponseFromGame response = new ResponseFromGame();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(unnamed(OwnedGames.toString())),
				ResponseFromGame.class);
		return response.getResponse().getGames();
	}

	private Set<Friend> provideFriendlist(String steamid)
			throws JsonParseException, JsonMappingException, IOException {

		Friendlist.append(apiKey.getSteamApiKey()).append("&steamid=")
				.append(steamid);

		System.out.println(Friendlist);
		
		ResponseFromFriendlist response = new ResponseFromFriendlist();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(unnamed(Friendlist.toString())),
				ResponseFromFriendlist.class);
		return response.getFriendslist().getFriends();
	}

	private JsonNode unnamed(String url) throws JSONException, IOException {
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();
		storeObject = JsonReader.readJsonFromUrl(url);
		return converter.convertJsonFormat(storeObject);
	}
}
