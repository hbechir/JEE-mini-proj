package com.bechir.games.services;

import com.bechir.games.entities.Game;
import com.bechir.games.repos.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


@Service
public class GameServiceImpl implements GameService {

  @Autowired
  GameRepository GameRepository;

  @Override
  public Game savegame(Game p) {
    return GameRepository.save(p);
  }

  @Override
  public Game updategame(Game p) {
    return GameRepository.save(p);
  }

  @Override
  public Page<Game> getAllGamesParPage(int page, int size) {
    return GameRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public void deletegame(Game p) {
    GameRepository.delete(p);
  }

  @Override
  public void deletegameById(Long id) {
    GameRepository.deleteById(id);
  }

  @Override
  public Game getgame(Long id) {
    return GameRepository.findById(id).get();
  }

  @Override
  public List<Game> getAllgames() {
    return GameRepository.findAll();
  }
}
