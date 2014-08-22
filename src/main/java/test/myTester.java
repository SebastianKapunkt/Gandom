package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;

import com.github.gandom.manager.GameIdentifier;
import com.github.gandom.manager.GenerateUser;
import com.github.gandom.manager.UserOperations;
import com.github.gandom.steam.game.Data;
import com.github.gandom.data.Game;
import com.github.gandom.data.User;

public class myTester {
	public static void main(String[] args) {
		long start = System.nanoTime();

		// 3k games: 76561197987370777
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468
		// Daniel: 76561198141599131

		String steamId = "76561198034249290";
		System.out.println("\n--##-- Generating UserOne --##--");
		
		User userOne = GenerateUser.User(steamId);

		System.out.println("\n--##-- Generating UserTwo --##--");
		steamId = "76561198034249290";
		User userTwo = GenerateUser.User(steamId);

		System.out.println("\n--##-- Comparing User´s gamelist --##--");
		Set<Game> same = new HashSet<Game>();
		Set<Game> diff = new HashSet<Game>();

		same.addAll(UserOperations.equalCompareGameList(userOne, userTwo));
		diff.addAll(UserOperations.unequalComparedGameList(userOne, userTwo));

		System.out.println("\nSame: " + same.size());
		for (Game game : same) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nDiff: " + diff.size() + " "
				+ (userTwo.getGames().size() - same.size()));
		for (Game game : diff) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nUserOne´s games");
		for (Game game : userOne.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nUserTwo´s games");
		for (Game game : userTwo.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}
		
		System.out.println("\n");
		System.out.println("--##-- resolve all "+userOne.getGames().size()+" games from UserOne--##--");
		GameIdentifier idf = new GameIdentifier();

		Set<Data> bla = new HashSet<Data>();
		try {
			bla = idf.resolveGames(userOne.getGames());
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		
		System.out.println("\n--##-- Listing resolved Games --##--");
		for (Data data : bla) {
			i++;
			if(i%5 == 0){
				System.out.println(" ");
			}
			System.out.print(data.getName() + " ### ");
		}

		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("\n"+(double) elapsedTime / 1000000000.0+"sec");
	}
}
