package com.github.fhbjeeweb.web.converter;

import com.github.fhbjeeweb.data.Game;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object o) {
        Set<Game> gameSet = new TreeSet<>();

        try {
            gameSet.addAll((Set<Game>) o);
        } catch (ClassCastException cce) {
            throw new ConverterException(
                    "Not a list of Games, could not convert to a String");
        }

        StringBuilder gamesStringBuilder = new StringBuilder();

        for (Game game : gameSet) {
            gamesStringBuilder.append(game.getName()).append(", ");
        }

        String games = gamesStringBuilder.toString();

        // Remove trailing comma + whitespace of last append operation
        if (games.length() > 2) {
            games = games.substring(0, games.length() - 2);
        }

        return games;
    }
}