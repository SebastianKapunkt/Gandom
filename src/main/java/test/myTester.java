package test;

import com.github.gandom.manager.GenerateUser;
import com.github.gandom.data.User;;

public class myTester {
	public static void main(String[] args){
		long start = System.nanoTime();
		
		String steamId = "76561197987370777";

		GenerateUser gen = new GenerateUser();
		
		User user = gen.User(steamId);
		System.out.println(user.getPlayer().getProfileurl());
		
		long end = System.nanoTime();
		
		long elapsedTime = end - start;
		System.out.println((double)elapsedTime / 1000000000.0);
	}
}
