package com.github.fhbjeeweb.web.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@RequestScoped
public class RandomGameController {

	@Inject
	private GameManager manager;

	private Game game;

	public Game getGame(){
		return this.game;
	}

	public void rangam(){
		game = manager.selectRandomGame();
	}

	public boolean isEmpty(){
		if(game == null){
			return true;
		}else{
			return false;
		}
	}

	public boolean isNotEmpty(){
		return !isEmpty();
	}
}