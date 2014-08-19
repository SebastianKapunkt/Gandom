package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.github.gandom.json.JsonConverter;
import com.github.gandom.json.JsonReader;
import com.github.gandom.steam.game.Data;

public class myOtherTester {

	public static void main(String[] args) {
		JSONObject storeobject = new JSONObject();
		try {
			storeobject = JsonReader.readJsonFromUrl("http://store.steampowered.com/api/appdetails?appids=440");
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set keyset = new HashSet();
		keyset = storeobject.keySet();
		
		for (Object object : keyset) {
			storeobject = (JSONObject) storeobject.get(object.toString());
			JsonConverter converter = new JsonConverter();
			JsonNode jsonNode = converter.convertJsonFormat((JSONObject) storeobject.get("data"));
			ObjectMapper mapper = new ObjectMapper();
			try {
				Data data = mapper.readValue(new TreeTraversingParser(jsonNode), Data.class);
				System.out.println(object+" "+data.getHeader_image());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
