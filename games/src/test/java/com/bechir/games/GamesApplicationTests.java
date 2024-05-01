package com.bechir.games;

import com.bechir.games.entities.Categorie;
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

  @Test
  public void testFindByNomProduit() {
    List<Game> games = gameRepository.findByGameName("fortnite");
    for (Game g : games) {
      System.out.println(g);
    }
  }

  @Test
  public void testFindByNomGameContains() {
    List<Game> games = gameRepository.findByGameNameContains("ort");
    for (Game g : games) {
      System.out.println(g);
    }
  }

  @Test
  public void testfindByNomPrix() {
    List<Game> games = gameRepository.findByNomPrix("GTA V", 0.0);
    for (Game g : games) {
      System.out.println(g);
    }
  }

  @Test
  public void testfindByCategorie() {
    Categorie cat = new Categorie();
    cat.setIdCat(6L);
    List<Game> games = gameRepository.findByCategorie(cat);
    for (Game g : games) {
      System.out.println(g.getGameName());
    }
  }

  @Test
  public void findByCategorieIdCat() {
    System.err.println("-----------------------------------------------------");
    List<Game> prods = gameRepository.findByCategorieIdCat(1L);
    System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    for (Game game : prods) {
      System.err.println(game.getGameId()); // replace getId() with the actual method to get the ID of the game
    }
  }

  @Test
  public void testfindByOrderByNomProduitAsc() {
    List<Game> prods = gameRepository.findByOrderByGameNameAsc();
    for (Game p : prods) {
      System.out.println(p.getGameId());
    }
  }

  @Test
  public void testTrierProduitsNomsPrix() {
    List<Game> prods = gameRepository.trierGamesNamesPrix();
    for (Game p : prods) {
      System.out.println(p.getGameName());
    }
  }
}
