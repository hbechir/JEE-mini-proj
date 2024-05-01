package com.bechir.games.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "gameName", types = { Game.class })
public interface ProduitProjection {
  public String getGameName();
}
