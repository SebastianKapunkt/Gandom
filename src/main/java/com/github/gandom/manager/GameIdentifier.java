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

import com.github.gandom.json.CallableJsonReader;
import com.github.gandom.json.JsonToPojo;
import com.github.gandom.steam.app.Data;
import com.github.gandom.user.data.Game;

public class GameIdentifier {

	private static String url = "http://store.steampowered.com/api/appdetails?appids=";

	public static Set<Data> resolveGames(Set<Game> games)
			throws InterruptedException, IOException, ExecutionException {
		Set<Data> resolvedGames = new HashSet<>();
		Set<String> holder = new HashSet<>();

		// for (Game game : games) {
		// holder.add(url + game.getAppid());
		// }

		Set<Game> split = new HashSet<Game>();
		StringBuilder appIds = new StringBuilder();
		int i = 0, end = 1, amountOfIds = 5;

		for (Game game : games) {
			split.add(game);
			i++;

			if (end++ == games.size() || i % amountOfIds == 0) {
				appIds.append(game.getAppid());
			} else {
				appIds.append(game.getAppid() + ",");
			}
			
			if (i % amountOfIds == 0) {
				holder.add(url + appIds.toString());
				appIds.setLength(0);
			}
		}

		if (appIds.length() != 0) {
			holder.add(url + appIds.toString());
		}

		int threadNumber = 10;

		ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
		List<Future<JSONObject>> list = new ArrayList<>();

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
			throws IOException {
		Set<Data> bundle = new HashSet<>();
		JSONObject zw;

		for (Object object : storeobject.keySet()) {
			zw = (JSONObject) storeobject.get(object.toString());
			if (zw.get("success").toString().equals("true")) {
				bundle.add((Data) JsonToPojo.mapOnPojo(
						(JSONObject) zw.get("data"), new Data()));
			}else{
				System.out.println("No Success "+object.toString());
			}
		}

		return bundle;
	}
}
