package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import com.github.gandom.manager.GameIdentifier;
import com.github.gandom.manager.GenerateUser;
import com.github.gandom.manager.UserOperations;
import com.github.gandom.steam.app.Categories;
import com.github.gandom.steam.app.Data;
import com.github.gandom.steam.app.Genres;
import com.github.gandom.user.data.Friendslist;
import com.github.gandom.user.data.Games;
import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.User;

public class MyTester {
	public static void main(String[] args) throws Exception {

		long start = System.nanoTime();
		// 3k games: 76561197987370777
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468
		// Daniel: 76561198141599131
		// Per: 76561197964008163;

		String steamId = "76561197964008163";
		System.out.println("\n--##-- Generating UserOne --##--");

		User userOne = GenerateUser.providePlayer(steamId)
				.getPlayers().get(0);
		Games userOneGames = GenerateUser
				.provideGameList(steamId);
		Friendslist userOneFriends = GenerateUser
				.provideFriendlist(steamId);

		System.out.println("\n--##-- Generating UserTwo --##--");
		steamId = "76561198034249290";
		User userTwo = GenerateUser.providePlayer(steamId)
				.getPlayers().get(0);
		Games userTwoGames = GenerateUser
				.provideGameList(steamId);
		Friendslist userTwoFriends = GenerateUser
				.provideFriendlist(steamId);

		System.out.println("\n--##-- Comparing User´s gamelist --##--");
		Set<Game> same = new HashSet<Game>();
		Set<Game> diff = new HashSet<Game>();

		Set<Games> requiredGames = new HashSet<Games>();
		requiredGames.add(userOneGames);
		requiredGames.add(userTwoGames);

		same.addAll(UserOperations.equalCompareGameList(requiredGames));
		same.addAll(UserOperations.unequalComparedGameList(requiredGames));

		System.out.println("\nSame: " + same.size());
		for (Game game : same) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nDiff: " + diff.size() + " "
				+ (userTwoGames.getGames().size() - same.size()));
		for (Game game : diff) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nUserOne´s games");
		for (Game game : userOneGames.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nUserTwo´s games");
		for (Game game : userTwoGames.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

/*		System.out.println("\n");
		System.out.println("--##-- resolve games --##--");

		Set<Data> bla = new HashSet<Data>();
		try {
			bla = GameIdentifier.resolveGames(same);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("\n--##-- Listing resolved Games --##--");
		for (Data data : bla) {
			System.out.print(data.getSteam_appid() + " # ");
			System.out.print(data.getName() + " ### ");
			if (data.getCategories() != null) {
				for (Categories cat : data.getCategories()) {
					if (!(cat.getDescription() == "")) {
						System.out.print(cat.getDescription() + " ");
					}
				}
				System.out.print(" ### ");
				if (data.getGenres() != null) {
					for (Genres genre : data.getGenres()) {
						if (!(genre.getDescription() == "")) {
							System.out.print(genre.getDescription() + " ");
						}
					}
				}
			}
			System.out.println();
		}*/

		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("\n" + (double) elapsedTime / 1000000000.0 + "sec");
	}
}
