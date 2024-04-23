package com.bechir.games.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long GameId;
    private String GameName;
    private Double GamePrice;
    public Game() {
        super();
    }
    public Game(String gameName, Double gamePrice) {
        super();
        GameName = gameName;
        GamePrice = gamePrice;
    }
    public Long getGameId() {
        return GameId;
    }
    public void setGameId(Long gameId) {
        GameId = gameId;
    }
    public String getGameName() {
        return GameName;
    }
    public void setGameName(String gameName) {
        GameName = gameName;
    }
    public Double getGamePrice() {
        return GamePrice;
    }
    public void setGamePrice(Double gamePrice) {
        GamePrice = gamePrice;
    }
    @Override
    public String toString() {
        return "Game [GameId=" + GameId + ", GameName=" + GameName + ", GamePrice=" + GamePrice + "]";
    }

}
