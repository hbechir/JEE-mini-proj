package com.bechir.games.services;

import com.bechir.games.entities.Categorie;
import com.bechir.games.entities.Game;
import com.bechir.games.repos.CategorieRepository;
import com.bechir.games.repos.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

  @Override
  public List<Game> findByGameName(String nom) {
    return GameRepository.findByGameName(nom);
  }

  @Override
  public List<Game> findByGameNameContains(String nom) {
    return GameRepository.findByGameNameContains(nom);
  }

  @Override
  public List<Game> findByNomPrix(String nom, Double prix) {
    return GameRepository.findByNomPrix(nom, prix);
  }

  @Override
  public List<Game> findByCategorie(Categorie categorie) {
    return GameRepository.findByCategorie(categorie);
  }

  @Override
  public List<Game> findByCategorieIdCat(Long id) {
    return GameRepository.findByCategorieIdCat(id);
  }

  @Override
  public List<Game> findByOrderByGameNameAsc() {
    return GameRepository.findByOrderByGameNameAsc();
  }

  @Override
  public List<Game> trierGamesNamesPrix() {
    return GameRepository.trierGamesNamesPrix();
  }

  @Autowired
  CategorieRepository categorieRepository;

  @Override
  public List<Categorie> getAllCategories() {
    return categorieRepository.findAll();
  }
}
