package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.gandom.manager.GameIdentifier;
import com.github.gandom.manager.GenerateUser;
import com.github.gandom.manager.UserOperations;
import com.github.gandom.steam.app.Categories;
import com.github.gandom.steam.app.Data;
import com.github.gandom.steam.app.Genres;
import com.github.gandom.user.data.Friend;
import com.github.gandom.user.data.Friendslist;
import com.github.gandom.user.data.Game;
import com.github.gandom.user.data.Games;
import com.github.gandom.user.data.Userlist;

public class myTester {
	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {

		long start = System.nanoTime();
		// 3k games: 76561197987370777
		// meine: 76561198034249290
		// alex: 76561197985815246
		// Sisores: 76561197983850468
		// Daniel: 76561198141599131

		String steamId = "76561198034249290";
		System.out.println("\n--##-- Generating UserOne --##--");

		Userlist userlist = new Userlist();
		userlist = GenerateUser.providePlayer(steamId);
		Friendslist friendlist = new Friendslist();
		friendlist = GenerateUser.provideFriendlist(steamId);
		Games games = new Games();
		games = GenerateUser.provideGameList(steamId);

		System.out.println("\n--##-- Generating UserTwo --##--");
		steamId = "76561197985815246";
		Userlist userlist2 = new Userlist();
		userlist2 = GenerateUser.providePlayer(steamId);
		Friendslist friendlist2 = new Friendslist();
		friendlist2 = GenerateUser.provideFriendlist(steamId);
		Games games2 = new Games();
		games2 = GenerateUser.provideGameList(steamId);
		
		System.out.println("\n--##-- Generating UserTwo --##--");
		steamId = "76561197985815246";
		Userlist userlist3 = new Userlist();
		userlist3 = GenerateUser.providePlayer(steamId);
		Friendslist friendlist3 = new Friendslist();
		friendlist3 = GenerateUser.provideFriendlist(steamId);
		Games games3 = new Games();
		games3 = GenerateUser.provideGameList(steamId);

		System.out.println("\n"+ userlist.getPlayers().get(0).getPersonaname() +" games");
		for (Game game : games.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}
		
		System.out.println("\n"+ userlist2.getPlayers().get(0).getPersonaname() +" games");
		for (Game game : games2.getGames()) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\n--##-- Comparing User´s gamelist --##--");
		Set<Game> same = new HashSet<Game>();
		Set<Game> diff = new HashSet<Game>();

		Set<Games> usergames = new HashSet<Games>();
		usergames.add(games);
		usergames.add(games2);
		usergames.add(games3);
		
		same.addAll(UserOperations.equalCompareGameList(usergames));
		diff.addAll(UserOperations.unequalComparedGameList(usergames));

		System.out.println("\nSame: " + same.size());
		for (Game game : same) {
			System.out.print(game.getAppid().toString() + "\t");
		}

		System.out.println("\nDiff: " + diff.size() + " "
				+ ((int) games2.getGame_count() - same.size()));
		for (Game game : diff) {
			System.out.print(game.getAppid().toString() + "\t");
		}

//		System.out.println("\nFriendlist from "+ userlist.getPlayers().get(0).getPersonaname() +": ");
//		for (Friend friend : friendlist.getFriends()) {
//			System.out.print(friend.getSteamid().toString() + "\t");
//		}
//		
//		System.out.println("\nFriendlist from "+ userlist2.getPlayers().get(0).getPersonaname() +": ");
//		for (Friend friend : friendlist2.getFriends()) {
//			System.out.print(friend.getSteamid().toString() + "\t");
//		}
//		
//		System.out.println("\n");
//		System.out.println("--##-- resolve games --##--");
//
//		Set<Data> bla = new HashSet<Data>();
//		try {
//			bla = GameIdentifier.resolveGames(games.getGames());
//		} catch (JSONException | IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("\n--##-- Listing resolved Games --##--");
//		for (Data data : bla) {
//			System.out.print(data.getSteam_appid() + " # ");
//			System.out.print(data.getName() + " ### ");
//			if (data.getCategories() != null) {
//				for (Categories cat : data.getCategories()) {
//					if (!(cat.getDescription() == "")) {
//						System.out.print(cat.getDescription() + " ");
//					}
//				}
//				System.out.print(" ### ");
//				if (data.getGenres() != null) {
//					for (Genres genre : data.getGenres()) {
//						if (!(genre.getDescription() == "")) {
//							System.out.print(genre.getDescription() + " ");
//						}
//					}
//				}
//			}
//			System.out.println();
//		}

		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("\n" + (double) elapsedTime / 1000000000.0 + "sec");
	}
}
