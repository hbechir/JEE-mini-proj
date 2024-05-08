package com.bechir.games.controllers;

import com.bechir.games.entities.Categorie;
import com.bechir.games.entities.Game;
import com.bechir.games.services.GameService;
import jakarta.validation.Valid;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

  @Autowired
  GameService GameService;

  @RequestMapping("/ListeGames")
  public String listeGames(
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
  public String showCreate(ModelMap modelMap) {
    List<Categorie> cats = GameService.getAllCategories();

    modelMap.addAttribute("game", new Game());
    modelMap.addAttribute("mode", "new");
    modelMap.addAttribute("categories", cats);
    return "formGame";
  }

  @RequestMapping("/saveGame")
  public String saveProduit(
    @Valid Game produit,
    BindingResult bindingResult,
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size
  ) {
    int currentPage;
    boolean isNew = false;
    if (bindingResult.hasErrors()) return "formGame";
    if (produit.getGameId() == null) isNew = true; //ajout
    GameService.savegame(produit);
    if (isNew) { //ajout
      Page<Game> prods = GameService.getAllGamesParPage(page, size);
      currentPage = prods.getTotalPages() - 1;
    } else currentPage = page; //modif
    return ("redirect:/ListeGames?page=" + currentPage + "&size=" + size);
  }

  @RequestMapping("/supprimerGame")
  public String supprimerProduit(
    @RequestParam("id") Long id,
    ModelMap modelMap,
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size
  ) {
    GameService.deletegameById(id);
    Page<Game> prods = GameService.getAllGamesParPage(page, size);
    modelMap.addAttribute("games", prods);
    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    modelMap.addAttribute("size", size);
    return "listeGames";
  }

  @RequestMapping("/modifierGame")
  public String editerGame(
    @RequestParam("id") Long id,
    ModelMap modelMap,
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size
  ) {
    Game p = GameService.getgame(id);
    List<Categorie> cats = GameService.getAllCategories();

    modelMap.addAttribute("game", p);
    modelMap.addAttribute("mode", "edit");
    modelMap.addAttribute("categories", cats);
    modelMap.addAttribute("page", page);
    modelMap.addAttribute("size", size);

    return "formGame";
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

  @GetMapping(value = "/")
  public String welcome() {
    return "index";
  }
}
