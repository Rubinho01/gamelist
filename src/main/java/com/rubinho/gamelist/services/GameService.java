package com.rubinho.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubinho.gamelist.dto.GameDTO;
import com.rubinho.gamelist.dto.GameMinDTO;
import com.rubinho.gamelist.entities.Game;
import com.rubinho.gamelist.projections.GameMinProjection;
import com.rubinho.gamelist.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	public List<GameMinDTO> findAll(){
		var result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
	public GameDTO findById(Long id) throws Exception {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
}
