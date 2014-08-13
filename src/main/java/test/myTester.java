package test;

import java.io.IOException;

import org.json.JSONException;

public class myTester {
	public static void main(String[] args) throws IOException, JSONException {
		// JSONObject json =
		// readJsonFromUrl("http://store.steampowered.com/api/appdetails?appids=923,440,400&cc=en");
		// JSONObject json =
		// readJsonFromUrl("http://api.steampowered.com/ISteamApps/GetAppList/v0001/");
		// System.out.println(json.toString());
		// JSONArray jarray =
		// json.getJSONObject("applist").getJSONObject("apps").getJSONArray("app");
		// System.out.println(json.getJSONObject("applist").getJSONObject("apps").getJSONArray("app"));
		// HashMap<Integer, String> games = new HashMap();
		// System.out.println(jarray.getJSONObject(20));
		// System.out.println(json.getJSONObject(json.names().get(0).toString()).getJSONObject("data").get("steam_appid"));
		// System.out.println(json.getJSONObject(json.names().get(1).toString()).getJSONObject("data").get("steam_appid"));
		// System.out.println(json.getJSONObject(json.names().get(0).toString()).names());
		
		String steamId = "76561198034249290";

		User test = new User();
		test.generate(steamId);
	}
}
