package com.github.fhbjeeweb.web.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@RequestScoped
public class ListPublisherController {

	@Inject
	private GameManager manager;

	public List<Publisher> getPublishers() {
		return manager.readPublishers();
	}
	
	public String editPublisher(){
		return Pages.EDIT_PUBLISHER;
	}
}