package com.github.gandom.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.gandom.data.Game;
import com.github.gandom.json.CallableJsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.steam.game.Data;

public class GameIdentifier {

	private static String url = "http://store.steampowered.com/api/appdetails?appids=";

	public static Set<Data> resolveGames(Set<Game> games)
			throws InterruptedException, JsonParseException,
			JsonMappingException, IOException, ExecutionException {
		Set<Data> resolvedGames = new HashSet<Data>();
		Set<Game> split = new HashSet<Game>();
		Set<String> holder = new HashSet<String>();
		StringBuilder appIds = new StringBuilder();
		int i = 0;

		for (Game game : games) {
			split.add(game);
			i++;
			appIds.append(game.getAppid() + ",");
			if (i % 10 == 0) {
				holder.add(url + appIds.toString());
				appIds.setLength(0);
			}
		}

		holder.add(url + appIds.toString());

		int threadNumber = 50;

		ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
		List<Future<JSONObject>> list = new ArrayList<Future<JSONObject>>();

		for (String string : holder) {
			Callable<JSONObject> worker = new CallableJsonReader(string);
			Future<JSONObject> submit = executor.submit(worker);
			list.add(submit);
		}

		for (Future<JSONObject> future : list) {
			resolvedGames.addAll(convertToPojo(future.get()));
		}
		
		executor.shutdown();

		return resolvedGames;
	}

	private static Collection<Data> convertToPojo(JSONObject storeobject)
			throws JsonParseException, JsonMappingException, IOException {
		Set<Data> bundle = new HashSet<Data>();
		JSONObject zw = new JSONObject();

		for (Object object : storeobject.keySet()) {
			zw = (JSONObject) storeobject.get(object.toString());
			if (zw.get("success").toString() == "true") {
				bundle.add((Data) JsonToPojo.mapOnPojo(
						(JSONObject) zw.get("data"), new Data()));
			}
		}

		return bundle;
	}
}
