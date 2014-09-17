package com.github.gandom.manager;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.Games;

public class UserOperations {

	public static Set<Game> equalCompareGameList(Set<Games> usergames) {
		Set<Game> one = new HashSet<Game>();
		one.addAll(usergames.iterator().next().getGames());
		
		for (Games games : usergames) {
			one.retainAll(games.getGames());
		}

		return one;
	}

	public static Set<Game> unequalComparedGameList(Set<Games> usergames) {
		Set<Game> same = new HashSet<Game>();
		Set<Game> unequal = new HashSet<Game>();
		same.addAll(equalCompareGameList(usergames));
		
		for (Games games : usergames) {
			unequal.addAll(games.getGames());
		}
		
		unequal.removeAll(same);
		
		return unequal;
	}
}
