package com.bechir.games.restcontrollers;

import com.bechir.games.entities.Game;
import com.bechir.games.services.GameService;
import com.bechir.games.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GameRestController {

  @Autowired
  GameService produitService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Game> getAllProduits() {
    return produitService.getAllgames();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Game getProduitById(@PathVariable("id") Long id) {
    return produitService.getgame(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Game createProduit(@RequestBody Game produit) {
    return produitService.savegame(produit);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public Game updateProduit(@RequestBody Game produit) {
    return produitService.updategame(produit);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteProduit(@PathVariable("id") Long id) {
    produitService.deletegameById(id);
  }

  @RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
  public List<Game> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
    return produitService.findByCategorieIdCat(idCat);
  }
}
