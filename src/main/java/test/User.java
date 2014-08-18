package test;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.github.gandom.data.SteamApiKey;
import com.github.gandom.json.JsonConverter;
import com.github.gandom.json.JsonReader;

public class User {

	private static String Summaries = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?";
	private static String OwnedGames = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?";
	private static String Friendlist = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?";
	private Player player;
	private Games games;
	private Friends friends;

	// private Set<friend> friends;

	public void generate(String steamId) {
		// get API key
		SteamApiKey key = new SteamApiKey();

		playerSummaries(key.getSteamApiKey(), steamId);
		userGames(key.getSteamApiKey(), steamId);
		userFriends(key.getSteamApiKey(), steamId);
	}

	private void userFriends(String key, String steamId) {
		String url = User.Friendlist + "key=" + key + "&steamid=" + steamId
				+ "&relationship=friend";

		// prepare Object for request Object
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();

		// Sending Request
		try {
			storeObject = JsonReader.readJsonFromUrl(url);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		storeObject = storeObject.getJSONObject("friendslist");

		// Converting JsonObject to Pojo
		JsonNode jsonNode = converter.convertJsonFormat(storeObject);
		ObjectMapper mapper = new ObjectMapper();
		try {
			friends = mapper.readValue(new TreeTraversingParser(jsonNode),
					Friends.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test output
		System.out.println(url);
//		Set<Friend> friendslist = friends.getFriends();
//
//		for (Friend friend : friendslist) {
//			System.out.println("\n" + friend.getSteamid() + "\n"
//					+ friend.getFriend_since());
//		}
	}

	private void userGames(String key, String steamId) {
		// build request URL
		String url = User.OwnedGames + "key=" + key + "&steamid=" + steamId;

		// prepare Object for request Object
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();

		// Sending Request
		try {
			storeObject = JsonReader.readJsonFromUrl(url);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		storeObject = storeObject.getJSONObject("response");

		// Converting JsonObject to Pojo
		JsonNode jsonNode = converter.convertJsonFormat(storeObject);
		ObjectMapper mapper = new ObjectMapper();
		try {
			games = mapper.readValue(new TreeTraversingParser(jsonNode),
					Games.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test output
		Set<Game> gamelist = games.getGames();

		System.out.println(url);
//		for (Game game : gamelist) {
//			System.out.println("\n" + game.getAppid() + "\n"
//					+ game.getPlaytime_forever());
//		}
	}

	private void playerSummaries(String key, String steamId) {
		// build request URL
		String url = User.Summaries + "key=" + key + "&steamids=" + steamId;

		// prepare Object for request Object
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();

		// Sending Request
		try {
			storeObject = JsonReader.readJsonFromUrl(url);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		// Get the Object that is importent
		storeObject = (JSONObject) storeObject.getJSONObject("response")
				.getJSONArray("players").get(0);

		// Converting JsonObject to Pojo
		JsonNode jsonNode = converter.convertJsonFormat(storeObject);
		ObjectMapper mapper = new ObjectMapper();
		try {
			player = mapper.readValue(new TreeTraversingParser(jsonNode),
					Player.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test output
		System.out.println(url);
//		System.out.println(player.toString());
	}
}
