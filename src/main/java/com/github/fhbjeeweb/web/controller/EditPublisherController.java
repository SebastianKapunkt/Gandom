package com.github.fhbjeeweb.web.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

import java.io.Serializable;

@Named
@ViewScoped
public class EditPublisherController implements Serializable{

    private static final long serialVersionUID = 7362744544141743585L;

    @Inject
	private GameManager manager;
	
	private long persitedPublisherId;
	private Publisher publisher;
	

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
		manager.savePublisher(publisher);
		return Pages.LIST_PUBLISHERS;
	}
	
	public String cancel(){
		return Pages.LIST_PUBLISHERS;
	}
}
