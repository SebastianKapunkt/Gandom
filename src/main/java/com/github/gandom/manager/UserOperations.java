package com.github.gandom.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.Games;

public class UserOperations {

	public static Set<Game> equalCompareGameList(Set<Games> userGames) {
		Set<Game> same = new HashSet<>();
		same.addAll(userGames.iterator().next().getGames());
		
		for (Games games : userGames) {
			same.retainAll(games.getGames());
		}

		return same;
	}

	public static Set<Game> unequalComparedGameList(Set<Games> userGames) {
		Set<Game> same = new HashSet<>();
		Set<Game> unequal = new HashSet<>();
		same.addAll(equalCompareGameList(userGames));
		
		for (Games games : userGames) {
			unequal.addAll(games.getGames());
		}
		
		unequal.removeAll(same);
		
		return unequal;
	}
	
	public static Game selectRandomGame(Set<Game> games){
		
		List<Game> list = new ArrayList<>(games);
		int size = games.size();

		return list.get(new Random().nextInt(size));
	}
}
