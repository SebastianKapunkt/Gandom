package com.github.gandom.manager;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.Games;

public class UserOperations {

	public static Set<Game> equalCompareGameList(Games userOne, Games userTwo) {
		Set<Game> one = new HashSet<Game>();
		one.addAll(userOne.getGames());
		
		one.retainAll(userTwo.getGames());

		return one;
	}

	public static Set<Game> unequalComparedGameList(Games userOne, Games userTwo) {
		Set<Game> one = new HashSet<Game>();
		Set<Game> two = new HashSet<Game>();

		one.addAll(userOne.getGames());
		two.addAll(userTwo.getGames());

		two.retainAll(one);
		one.removeAll(two);

		return one;
	}
}
