package test;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

public class User{

	private String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?";

	public void generate(String steamId) {
		Player player = new Player();
		SteamApiKey key = new SteamApiKey();
		System.out.println(key.getSteamApiKey());
		String url = this.url+"key="+key.getSteamApiKey()+"&steamids="+steamId;
		JSONObject storeObject = new JSONObject();
		JsonConverter converter = new JsonConverter();
		
		try {
			storeObject = JsonReader.readJsonFromUrl(url);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		storeObject = (JSONObject) storeObject.getJSONObject("response").getJSONArray("players").get(0);
		
		JsonNode jsonNode = converter.convertJsonFormat(storeObject);
		ObjectMapper mapper = new ObjectMapper();
		try {
			player = mapper.readValue(new TreeTraversingParser(jsonNode), Player.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(player.getAvatarfull());
	}

}
