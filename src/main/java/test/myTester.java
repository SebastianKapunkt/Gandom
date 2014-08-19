package test;

import java.util.HashSet;
import java.util.Set;

import com.github.gandom.manager.GenerateUser;
import com.github.gandom.manager.UserOperations;
import com.github.gandom.data.Game;
import com.github.gandom.data.User;

public class myTester {
	public static void main(String[] args) {

		// 3k games: 76561197987370777;
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468

		String steamId = "76561197983850468";
		User userOne = GenerateUser.User(steamId);

		System.out.println(userOne.getGames().size());

		steamId = "76561198034249290";
		User userTwo = GenerateUser.User(steamId);

		System.out.println(userTwo.getGames().size());

		Set<Game> same = new HashSet<Game>();
		Set<Game> diff = new HashSet<Game>();
		long start = System.nanoTime();

		same.addAll(UserOperations.equalCompareGameList(userOne, userTwo));
		diff.addAll(UserOperations.unequalComparedGameList(userOne, userTwo));

		long end = System.nanoTime();

		System.out.println("Same: " + same.size());
		for (Game game : same) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nDiff: " + diff.size() + " "
				+ (userTwo.getGames().size() - same.size()));
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
