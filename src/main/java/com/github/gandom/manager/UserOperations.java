package com.github.gandom.manager;

import java.util.HashSet;
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
}
