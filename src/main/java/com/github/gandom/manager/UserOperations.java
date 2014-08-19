package com.github.gandom.manager;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.data.Game;
import com.github.gandom.data.User;

public class UserOperations {

	public Set<Game> equalCompareGameList(User userOne, User userTwo) {
		Set<Game> one = new HashSet<Game>();
		one.addAll(userOne.getGames());

		one.retainAll(userTwo.getGames());

		return one;
	}

	public Set<Game> unequalComparedGameList(User userOne, User userTwo) {
		Set<Game> one = new HashSet<Game>();
		Set<Game> two = new HashSet<Game>();

		one.addAll(userOne.getGames());
		two.addAll(userTwo.getGames());

		two.retainAll(one);
		one.removeAll(two);

		return one;
	}
}
