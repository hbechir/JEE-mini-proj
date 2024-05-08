package com.bechir.games.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

  @NotNull
  @Size(min = 4, max = 20)
  private String gameName;

  @Min(value = 0)
  @Max(value = 150)
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
