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

	private static String Summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=";
	private static String OwnedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=";
	private static String Friendlist = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=";
	private static SteamApiKey apiKey = new SteamApiKey();

	public User User(String steamid) {
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

	private Player providePlayer(String steamid) throws JsonParseException,
			JsonMappingException, JSONException, IOException {

		StringBuilder Summaries = new StringBuilder().append(GenerateUser.Summaries).append(apiKey.getSteamApiKey()).append("&steamids=")
				.append(steamid);

		System.out.println(Summaries);
		
		ResponseFromPlayer response = new ResponseFromPlayer();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(requestConverter(Summaries.toString())),
				ResponseFromPlayer.class);
		return response.getResponse().getPlayers().iterator().next();
	}

	private Set<Game> provideGameList(String steamid)
			throws JsonParseException, JsonMappingException, JSONException,
			IOException {

		StringBuilder OwnedGames = new StringBuilder().append(GenerateUser.OwnedGames).append(apiKey.getSteamApiKey()).append("&steamid=")
				.append(steamid);

		System.out.println(OwnedGames);
		
		ResponseFromGame response = new ResponseFromGame();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(requestConverter(OwnedGames.toString())),
				ResponseFromGame.class);
		return response.getResponse().getGames();
	}

	private Set<Friend> provideFriendlist(String steamid)
			throws JsonParseException, JsonMappingException, IOException {

		StringBuilder Friendlist = new StringBuilder().append(GenerateUser.Friendlist).append(apiKey.getSteamApiKey()).append("&steamid=")
				.append(steamid);

		System.out.println(Friendlist);
		
		ResponseFromFriendlist response = new ResponseFromFriendlist();
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.readValue(
				new TreeTraversingParser(requestConverter(Friendlist.toString())),
				ResponseFromFriendlist.class);
		return response.getFriendslist().getFriends();
	}

	private JsonNode requestConverter(String url) throws JSONException, IOException {
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();
		storeObject = JsonReader.readJsonFromUrl(url);
		return converter.convertJsonFormat(storeObject);
	}
}
