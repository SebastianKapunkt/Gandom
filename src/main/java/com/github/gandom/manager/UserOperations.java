package com.github.gandom.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.List;

import com.github.gandom.data.Game;
import com.github.gandom.data.User;

public class UserOperations {

	public static Set<Game> equalCompareGameList(User userOne, User userTwo) {
		Set<Game> one = new HashSet<Game>();
		one.addAll(userOne.getGames());

		one.retainAll(userTwo.getGames());

		return one;
	}

	public static Set<Game> unequalComparedGameList(User userOne, User userTwo) {
		Set<Game> one = new HashSet<Game>();
		Set<Game> two = new HashSet<Game>();

		one.addAll(userOne.getGames());
		two.addAll(userTwo.getGames());

		two.retainAll(one);
		one.removeAll(two);

		return one;
	}
	
	public static Game selectRandomGame(Set<Game> games){
		
		List<Game> list = new ArrayList<>(games);
		int size = games.size();

		return list.get(new Random().nextInt(size));
	}
}
