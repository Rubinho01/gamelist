package com.rubinho.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubinho.gamelist.dto.GameListDTO;
import com.rubinho.gamelist.dto.GameMinDTO;
import com.rubinho.gamelist.services.GameListService;
import com.rubinho.gamelist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		var result = gameListService.findAll();
		return result;
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		var result = gameService.findByList(listId);
		return result;
	
}
}
