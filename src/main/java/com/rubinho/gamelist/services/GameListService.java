package com.rubinho.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubinho.gamelist.dto.GameListDTO;
import com.rubinho.gamelist.entities.GameList;
import com.rubinho.gamelist.repositories.GameListRepository;

import jakarta.transaction.Transactional;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;
	
	
	public List<GameListDTO> findAll(){
		var result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
		
	}
}
