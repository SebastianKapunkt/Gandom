package com.github.fhbjeeweb.web.converter;

import com.github.fhbjeeweb.data.Genre;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@FacesConverter(value = "com.github.fhbjeeweb.GenresConverter")
public class GenresConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext,
                              UIComponent uiComponent, String s) {
        Set<Genre> genres = new HashSet<>();

        if (s != null && !s.isEmpty()) {
            String[] genreNames = s.split(",");
            for (String name : genreNames) {
                genres.add(new Genre(name.trim()));
            }
        }
        return genres;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object o) {
        Set<Genre> genreSet = new TreeSet<>();

        try {
            genreSet.addAll((Set<Genre>) o);
        } catch (ClassCastException cce) {
            throw new ConverterException(
                    "Not a list of Genres. could not convert to a String");
        }

        StringBuilder genresStringBuilder = new StringBuilder();

        for (Genre genre : genreSet) {
            genresStringBuilder.append(genre.getName()).append(", ");
        }

        String genres = genresStringBuilder.toString();

        // Remove trailing comma + whitespace of last append operation
        if (genres.length() > 2) {
            genres = genres.substring(0, genres.length() - 2);
        }

        return genres;
    }
}