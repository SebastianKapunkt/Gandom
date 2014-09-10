package com.github.gandom.json;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

public class JsonToPojo {
	public static Object mapOnPojo(JSONObject json, Object o)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper
				.readValue(
						new TreeTraversingParser(JsonConverter
								.convertJsonFormat(json)), o.getClass());
	}
}
