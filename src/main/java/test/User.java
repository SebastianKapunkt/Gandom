package test;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

public class User {

	private static String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?";
	private Player player;

	// private Set<Game> games;
	// private Set<friend> friends;

	public void generate(String steamIds) {
		// get API key
		SteamApiKey key = new SteamApiKey();

		playerSummaries(key.getSteamApiKey(), steamIds);
		userGames(key.getSteamApiKey(), steamIds);
	}

	private void userGames(String steamApiKey, String steamIds) {

	}

	private void playerSummaries(String key, String steamIds) {
		// build request URL
		String url = User.url + "key=" + key + "&steamids=" + steamIds;

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
		System.out.println(player.getAvatarfull());
	}
}
