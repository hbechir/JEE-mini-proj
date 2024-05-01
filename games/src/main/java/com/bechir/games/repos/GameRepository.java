package com.bechir.games.repos;

import com.bechir.games.entities.Categorie;
import com.bechir.games.entities.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface GameRepository extends JpaRepository<Game, Long> {
  List<Game> findByGameName(String GameName);
  List<Game> findByGameNameContains(String GameName);

  @Query("select g from Game g where g.gameName like %?1 and g.gamePrice > ?2")
  List<Game> findByNomPrix(String name, Double price);

  @Query("select g from Game g where g.categorie = ?1")
  List<Game> findByCategorie(Categorie categorie);

  List<Game> findByCategorieIdCat(Long id);

  List<Game> findByOrderByGameNameAsc();

  @Query(
    "select p from Game p order by p.gameName ASC, p.gamePrice DESC"
  )
  List<Game> trierGamesNamesPrix();
}
