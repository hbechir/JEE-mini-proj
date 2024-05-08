package com.bechir.games.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCat;

  private String nomCat;
  private String descriptionCat;

  @JsonIgnore
  @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
  private List<Game> games;


  public Categorie(String nomCat, String descriptionCat) {
    this.nomCat = nomCat;
    this.descriptionCat = descriptionCat;
  }

  // getters and setters


  public Long getIdCat() {
    return this.idCat;
  }

  public void setIdCat(Long idCat) {
    this.idCat = idCat;
  }

  public String getNomCat() {
    return this.nomCat;
  }

  public void setNomCat(String nomCat) {
    this.nomCat = nomCat;
  }

  public String getDescriptionCat() {
    return this.descriptionCat;
  }

  public void setDescriptionCat(String descriptionCat) {
    this.descriptionCat = descriptionCat;
  }

  public List<Game> getGames() {
    return this.games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }







}
