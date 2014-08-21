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

		// 3k games: 76561197987370777;
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468
		// Daniel: 76561198141599131

		String steamId = "76561197985815246";
		System.out.println("--##-- Generating User --##--");
		
		User userOne = GenerateUser.User(steamId);


//		steamId = "76561198034249290";
//		User userTwo = GenerateUser.User(steamId);
//
//		System.out.println(userTwo.getGames().size());
//
//		Set<Game> same = new HashSet<Game>();
//		Set<Game> diff = new HashSet<Game>();
//
//		same.addAll(UserOperations.equalCompareGameList(userOne, userTwo));
//		diff.addAll(UserOperations.unequalComparedGameList(userOne, userTwo));
//
//		System.out.println("Same: " + same.size());
//		for (Game game : same) {
//			System.out.print(game.getAppid().toString() + "\t");
//		}
//
//		System.out.println("\nDiff: " + diff.size() + " "
//				+ (userTwo.getGames().size() - same.size()));
//		for (Game game : diff) {
//			System.out.print(game.getAppid().toString() + "\t");
//		}
//
//		System.out.println("\nOne");
//		for (Game game : userOne.getGames()) {
//			System.out.print(game.getAppid().toString() + "\t");
//		}
//
//		System.out.println("\nTwo");
//		for (Game game : userTwo.getGames()) {
//			System.out.print(game.getAppid().toString() + "\t");
//		}
		
		System.out.println("--##-- resolve all "+userOne.getGames().size()+" games --##--");
		GameIdentifier idf = new GameIdentifier();

		Set<Data> bla = new HashSet<Data>();
		try {
			bla = idf.resolveGames(userOne.getGames());
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		
		for (Data data : bla) {
			i++;
			if(i%3 == 0){
				System.out.println("");
			}
			System.out.print(data.getName()+"\t\t\t ");
		}

		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println((double) elapsedTime / 1000000000.0);
	}
}
