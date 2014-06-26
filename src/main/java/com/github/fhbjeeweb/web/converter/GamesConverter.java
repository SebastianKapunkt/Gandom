package com.github.fhbjeeweb.web.converter;

import com.github.fhbjeeweb.data.Game;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "com.github.fhbjeeweb.GamesConverter")
public class GamesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String s) {
		Set<Game> games = new HashSet<>();

		if (s != null && !s.isEmpty()) {
			String[] gameNames = s.split(",");
			for (String name : gameNames) {
				games.add(new Game(name.trim()));
			}
		}
		return games;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object o) {
		Set<Game> games;

		try {
			games = (Set<Game>) o;
		} catch (ClassCastException cce) {
			throw new ConverterException(
					"Not a lost of Games, Could not convert to a String");
		}

		// Convert Set to TreeSet so that games are sorted alphabetically
		games = new TreeSet<Game>(games);
		StringBuilder gamesStringBuilder = new StringBuilder();

		for (Game game : games) {
			gamesStringBuilder.append(game.getName()).append(", ");
		}
		
		gamesStringBuilder.reverse().replace(0, 2, "").reverse();
		// Remove trailing whitespace of last append with trim()
		return gamesStringBuilder.toString();
	}
}
