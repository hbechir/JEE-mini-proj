package com.bechir.games.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long GameId;

  private String gameName;
  private Double gamePrice;

  @ManyToOne
  private Categorie categorie;

  public Game(String gameName, Double gamePrice, Categorie categorie) {
    this.gameName = gameName;
    this.gamePrice = gamePrice;
    this.categorie = categorie;
  }
  
  public Long getGameId() {
    return GameId;
  }
  



 
}
