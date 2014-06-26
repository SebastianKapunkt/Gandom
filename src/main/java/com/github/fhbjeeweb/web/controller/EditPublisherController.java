package com.github.fhbjeeweb.web.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@RequestScoped
public class EditPublisherController {

	@Inject
	private GameManager manager;
	
	private long persitedPublisherId;
	private Publisher publisher;
	
	@PostConstruct
	private void initPublisher(){
		publisher = new Publisher();
	}

	public long getPersitedPublisherId() {
		return persitedPublisherId;
	}

	public void setPersitedPublisherId(long persitedPublisherId) {
		this.persitedPublisherId = persitedPublisherId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public void loadPublisher() {
		publisher = manager.getPublisherById(persitedPublisherId);
	}
	
	public String save(){
		publisher.setId(persitedPublisherId);
		manager.savePublisher(publisher);
		return Pages.LIST_PUBLISHERS;
	}
	
	public String cancel(){
		return Pages.LIST_PUBLISHERS;
	}
}
