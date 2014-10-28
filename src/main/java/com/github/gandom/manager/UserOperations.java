package com.github.gandom.manager;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.Games;

public class UserOperations {

	public static Set<Game> equalCompareGameList(Set<Games> usergames) {
		Set<Game> same = new HashSet<Game>();
		same.addAll(usergames.iterator().next().getGames());
		
		for (Games games : usergames) {
			same.retainAll(games.getGames());
		}

		return same;
//		Set<Game> same = new HashSet<Game>();
//		Set<Game> storage = new HashSet<Game>();
//		
//		for (Games games : usergames) {
//			storage.clear();
//			if(same.isEmpty()){
//				same.addAll(games.getGames());
//			}
//			storage.addAll(games.getGames());
//			same.retainAll(storage);
//		}
//		
//		return same;
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
