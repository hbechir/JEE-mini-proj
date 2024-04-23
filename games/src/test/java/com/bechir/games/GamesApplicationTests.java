package com.bechir.games;

import com.bechir.games.entities.Game;
import com.bechir.games.repos.GameRepository;
import com.bechir.games.services.GameService;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;

@SpringBootTest
class GamesApplicationTests {

  
  @Autowired
  GameService GameService;
  
  @Autowired
  private GameRepository gameRepository;

  @Test
  public void testCreateGame() {
    Game game = new Game();
    game.setGameName("pro 2019");
    game.setGamePrice(50.0);
    gameRepository.save(game);
    System.out.println(
      "Game created---------------------------------------------"
    );
  }

  @Test
  public void testFindGame() {
    Game g = gameRepository.findById(1L).get();
    System.out.println(g);
  }

  @Test
  public void testUpdateGame() {
    Game g = gameRepository.findById(1L).get();
    g.setGamePrice(10000.0);
    gameRepository.save(g);
  }

  @Test
  public void testDeleteGame() {
    gameRepository.deleteById(1L);
  }

  @Test
  public void testListerTousGames() {
    List<Game> games = gameRepository.findAll();
    for (Game g : games) {
      System.out.println(g);
    }
    System.out.println(
      "Game listed---------------------------------------------"
    );
  }

  @Test
  public void testFindByNomProduitContains() {
    Page<Game> prods = GameService.getAllGamesParPage(0, 2);
    
    System.out.println(prods.getSize());
    System.out.println(prods.getTotalElements());
    System.out.println(prods.getTotalPages());
    prods
      .getContent()
      .forEach(p -> {
        System.out.println(p.toString());
      });
    /*ou bien
for (Produit p : prods)
{
System.out.println(p);
} */
  }
}
