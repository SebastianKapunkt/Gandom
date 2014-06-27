package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.TreeSet;

@Named
@RequestScoped
public class ListPublisherController {

    @Inject
    private GameManager manager;

    public TreeSet<Publisher> getPublishers() {
        // Convert List to TreeSet so that publishers are sorted alphabetically
        return new TreeSet<Publisher>(manager.readPublishers());
    }

    public String editPublisher() {
        return Pages.EDIT_PUBLISHER;
    }
}