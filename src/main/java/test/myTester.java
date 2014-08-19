package test;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.manager.GenerateUser;
import com.github.gandom.manager.UserOperations;
import com.github.gandom.data.Game;
import com.github.gandom.data.User;

public class myTester {
	public static void main(String[] args) {

		// 3k games
		// String steamId = "76561197987370777";
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468
		GenerateUser gen = new GenerateUser();

		String steamId = "76561197983850468";
		User userOne = gen.User(steamId);

		System.out.println(userOne.getGames().size());

		steamId = "76561198034249290";
		User userTwo = gen.User(steamId);

		System.out.println(userTwo.getGames().size());
		// System.out.println(user.toString());
		//
		// Set<Game> one = new HashSet<Game>();
		// Set<Game> two = new HashSet<Game>();
		//
		// one.add(new Game(1,0,0));
		// one.add(new Game(2,0,0));
		// one.add(new Game(3,0,0));
		// one.add(new Game(4,0,0));
		// one.add(new Game(5,0,0));
		//
		// two.add(new Game(1,0,0));
		// two.add(new Game(3,0,0));
		// two.add(new Game(5,0,0));
		// two.add(new Game(6,0,0));
		// two.add(new Game(7,0,0));
		//
		//
		// User userOne = new User();
		// userOne.setGames(one);
		// User userTwo = new User();
		// userTwo.setGames(two);

		UserOperations userOperations = new UserOperations();

		Set<Game> same = new HashSet<Game>();
		Set<Game> diff = new HashSet<Game>();
		long start = System.nanoTime();

//		for (int i = 0; i < 100; i++) {
			same.addAll(userOperations.equalCompareGameList(userOne, userTwo));
			diff.addAll(userOperations.unequalComparedGameList(userOne, userTwo));
//		}

		long end = System.nanoTime();

		System.out.println("Same: " + same.size());
		for (Game game : same) {
			System.out.print(game.getAppid().toString() + "\t");
		}
		
		System.out.println("\nDiff: " + diff.size() + " " + (userTwo.getGames().size()-same.size()));
		for (Game game : diff) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nOne");
		for (Game game : userOne.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nTwo");
		for (Game game : userTwo.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("");
		System.out.println("");

		long elapsedTime = end - start;
		System.out.println((double) elapsedTime / 1000000000.0);
	}
}
