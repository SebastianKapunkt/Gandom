package test;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.github.gandom.json.JsonReader;

public class myOtherTester {

	public static void main(String[] args) {
		JSONObject storeobject = new JSONObject();
		try {
			storeobject = JsonReader.readJsonFromUrl("http://store.steampowered.com/api/appdetails?appids=57690,400");
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(storeobject.toString());
		
	}
}
