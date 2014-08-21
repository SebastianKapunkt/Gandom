package com.github.gandom.manager;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.github.gandom.data.Game;
import com.github.gandom.json.JsonConverter;
import com.github.gandom.json.JsonReader;
import com.github.gandom.steam.game.Data;

public class GameIdentifier {

	private static String url = "http://store.steampowered.com/api/appdetails?appids=";

	public Set<Data> resolveGames(Set<Game> games) throws JSONException,
			IOException {
		Set<Data> resolvedGames = new HashSet<Data>();
		JSONObject storeobject = new JSONObject();
		Set<Game> split = new HashSet<Game>();
		int i = 0;

		for (Game game : games) {
			split.add(game);
			i++;
			if (i % 20 == 0) {
				storeobject = sendRequest(split);
				resolvedGames.addAll(convert(storeobject));
				split.clear();
			}
		}

		storeobject = sendRequest(split);
		resolvedGames.addAll(convert(storeobject));

		return resolvedGames;
	}

	private Collection<Data> convert(JSONObject storeobject)
			throws JsonParseException, JsonMappingException, IOException {
		Set<Data> bundle = new HashSet<Data>();
		JsonConverter converter = new JsonConverter();
		ObjectMapper mapper = new ObjectMapper();
		JSONObject zw = new JSONObject();

		for (Object object : storeobject.keySet()) {
			zw = (JSONObject) storeobject.get(object.toString());
			if (zw.get("success").toString() == "true") {
				JsonNode node = converter.convertJsonFormat((JSONObject) zw
						.get("data"));
				bundle.add(mapper.readValue(new TreeTraversingParser(node),
						Data.class));
			}
		}

		return bundle;
	}

	private JSONObject sendRequest(Set<Game> games) throws JSONException,
			IOException {
		StringBuilder appIds = new StringBuilder().append(url);

		for (Game game : games) {
			appIds.append(game.getAppid() + ",");
		}

		System.out.println(appIds);
		
		return JsonReader.readJsonFromUrl(appIds.toString());
	}
}
