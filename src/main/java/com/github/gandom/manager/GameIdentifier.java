package com.github.gandom.manager;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.gandom.data.Game;
import com.github.gandom.json.JsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.steam.game.Data;

public class GameIdentifier {

	private static String url = "http://store.steampowered.com/api/appdetails?appids=";

	public static Set<Data> resolveGames(Set<Game> games) throws JSONException,
			IOException {
		Set<Data> resolvedGames = new HashSet<Data>();
		Set<Game> split = new HashSet<Game>();
		int i = 0;

		for (Game game : games) {
			split.add(game);
			i++;
			if (i % 30 == 0) {
				resolvedGames.addAll(convertToPojo(sendRequest(split)));
				split.clear();
			}
		}

		resolvedGames.addAll(convertToPojo(sendRequest(split)));

		return resolvedGames;
	}

	private static Collection<Data> convertToPojo(JSONObject storeobject)
			throws JsonParseException, JsonMappingException, IOException {
		Set<Data> bundle = new HashSet<Data>();
		JSONObject zw = new JSONObject();

		for (Object object : storeobject.keySet()) {
			zw = (JSONObject) storeobject.get(object.toString());
			if (zw.get("success").toString() == "true") {
				bundle.add((Data) JsonToPojo.mapOnPojo((JSONObject) zw.get("data"), new Data()));
			}
		}

		return bundle;
	}

	private static JSONObject sendRequest(Set<Game> games) throws JSONException,
			IOException {
		StringBuilder appIds = new StringBuilder().append(url);

		for (Game game : games) {
			appIds.append(game.getAppid() + ",");
		}

		System.out.println(appIds);

		return JsonReader.readJsonFromUrl(appIds.toString());
	}
}
