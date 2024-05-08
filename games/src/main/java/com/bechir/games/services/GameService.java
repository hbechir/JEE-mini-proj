package com.bechir.games.services;

import com.bechir.games.entities.Categorie;
import com.bechir.games.entities.Game;
import java.util.List;
import org.springframework.data.domain.Page;

public interface GameService {
  Game savegame(Game p);
  Game updategame(Game p);
  void deletegame(Game p);
  void deletegameById(Long id);
  Game getgame(Long id);
  List<Game> getAllgames();
  Page<Game> getAllGamesParPage(int page, int size);

  List<Game> findByGameName(String nom);
  List<Game> findByGameNameContains(String nom);
  List<Game> findByNomPrix(String nom, Double prix);
  List<Game> findByCategorie(Categorie categorie);
  List<Game> findByCategorieIdCat(Long id);
  List<Game> findByOrderByGameNameAsc();
  List<Game> trierGamesNamesPrix();
  List<Categorie> getAllCategories();

}
