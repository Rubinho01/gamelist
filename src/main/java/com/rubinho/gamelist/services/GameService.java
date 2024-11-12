package com.rubinho.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubinho.gamelist.dto.GameDTO;
import com.rubinho.gamelist.dto.GameMinDTO;
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
		var result = gameRepository.findById(id);
		if(result.isPresent()) {
			return new GameDTO(result.get());
		}else {
			throw new Exception("Jogo não encontrado para o ID" + id);
		}
	}
}
