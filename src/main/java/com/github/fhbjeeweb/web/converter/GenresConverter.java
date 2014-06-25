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
public class GenresConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Set<Genre> genres = new HashSet<>();

        if (s != null && !s.isEmpty()) {
            String[] genreNames = s.split("\\p{javaWhitespace}");
            for (String name : genreNames) {
                genres.add(new Genre(name));
            }
        }
        return genres;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Set<Genre> genres;

        try {
            genres = (Set<Genre>)o;
        } catch (ClassCastException cce) {
            throw new ConverterException(
                    "Not a list of Genres. Could not convert to a String");
        }

        // Convert Set to TreeSet so that genres are sorted alphabetically
        genres = new TreeSet<>(genres);
        StringBuilder genresStringBuilder = new StringBuilder();

        for (Genre genre : genres) {
            genresStringBuilder.append(genre.getName()).append(" ");
        }

        // Remove trailing whitespace of last append with trim()
        return genresStringBuilder.toString().trim();
    }
}
