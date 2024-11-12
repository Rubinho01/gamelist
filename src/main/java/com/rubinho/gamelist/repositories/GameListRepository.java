package com.rubinho.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubinho.gamelist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
