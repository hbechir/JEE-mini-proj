package com.bechir.games.controllers;

import com.bechir.games.entities.Game;
import com.bechir.games.services.GameService;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

  @Autowired
  GameService GameService;

  @RequestMapping("/ListeGames")
  public String listeProduits(
    ModelMap modelMap,
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size
  ) {
    Page<Game> prods = GameService.getAllGamesParPage(page, size);
    modelMap.addAttribute("games", prods);
    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    return "listeGames";
  }

  @RequestMapping("/showCreate")
  public String showCreate() {
    return "createGame";
  }

  @RequestMapping("/saveGame")
  public String saveGame(
    @ModelAttribute("Game") Game Game,
    @RequestParam("price") Double price,
    ModelMap modelMap
  ) throws ParseException {
    //conversion de la date

    Game.setGamePrice(price);

    Game saveGame = GameService.savegame(Game);
    String msg = "Game enregistré avec Id " + saveGame.getGameId();
    modelMap.addAttribute("msg", msg);
    return "createGame";
  }

  @RequestMapping("/supprimerGame")
  public String supprimerProduit(
    @RequestParam("id") Long id,
    ModelMap modelMap,
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size
  ) {
    GameService.deletegameById(id);
    Page<Game> prods =GameService.getAllGamesParPage(page, size);
    modelMap.addAttribute("games", prods);
    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    modelMap.addAttribute("size", size);
    return "listeGames";
  }

  @RequestMapping("/modifierGame")
  public String editerGame(@RequestParam("id") Long id, ModelMap modelMap) {
    Game p = GameService.getgame(id);
    modelMap.addAttribute("Game", p);
    return "editerGame";
  }

  @RequestMapping("/updateGame")
  public String updateGame(
    @ModelAttribute("Game") Game Game,
    @RequestParam("price") Double price,
    ModelMap modelMap
  ) throws ParseException {
    Game.setGamePrice(price);

    GameService.updategame(Game);
    List<Game> prods = GameService.getAllgames();
    modelMap.addAttribute("Games", prods);
    return "listeGames";
  }
}
