package com.bechir.games.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bechir.games.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
