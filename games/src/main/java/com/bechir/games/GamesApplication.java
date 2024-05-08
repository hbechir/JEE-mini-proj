package com.bechir.games;

// import com.bechir.games.entities.Game;
import com.bechir.games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.bechir.games.entities.Game;


// to add some games to the database on startup : we implement CommandLineRunner ⬇️⬇️⬇️⬇️
@SpringBootApplication
public class GamesApplication  implements CommandLineRunner{

  @Autowired
  GameService GameService;

  @Autowired
  private RepositoryRestConfiguration repositoryRestConfiguration;

  public static void main(String[] args) { 
    SpringApplication.run(GamesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repositoryRestConfiguration.exposeIdsFor(Game.class);
  }
  // adding some games to the database on startup

  // @Override
  // public void run(String... args) throws Exception {
  // 	GameService.savegame(new Game("GTA V", 70.0));
  // 			GameService.savegame(new Game("Assassin's Creed Valhalla", 60.0));
  // 			GameService.savegame(new Game("The Witcher 3: Wild Hunt", 40.0));
  // 			GameService.savegame(new Game("Red Dead Redemption 2", 50.0));
  // 			GameService.savegame(new Game("Minecraft", 30.0));
  // 			GameService.savegame(new Game("Call of Duty: Modern Warfare", 60.0));
  // 			GameService.savegame(new Game("FIFA 21", 60.0));
  // 			GameService.savegame(new Game("Cyberpunk 2077", 60.0));
  // 			GameService.savegame(new Game("The Legend of Zelda: Breath of the Wild", 60.0));
  // 			GameService.savegame(new Game("Super Mario Odyssey", 60.0));
  // 			GameService.savegame(new Game("Grand Theft Auto IV", 20.0));
  // 			GameService.savegame(new Game("Fallout 4", 30.0));
  // 			GameService.savegame(new Game("Battlefield 1", 40.0));
  // 			GameService.savegame(new Game("Overwatch", 40.0));
  // 			GameService.savegame(new Game("Destiny 2", 40.0));
  // 			GameService.savegame(new Game("Borderlands 3", 60.0));
  // 			GameService.savegame(new Game("Assassin's Creed Odyssey", 40.0));
  // 			GameService.savegame(new Game("The Elder Scrolls V: Skyrim", 40.0));
  // 			GameService.savegame(new Game("God of War", 40.0));
  // 			GameService.savegame(new Game("Uncharted 4: A Thief's End", 40.0));
  // 			GameService.savegame(new Game("Horizon Zero Dawn", 40.0));
  // 			GameService.savegame(new Game("Resident Evil 2", 40.0));
  // 			GameService.savegame(new Game("Final Fantasy VII Remake", 60.0));
  // 			GameService.savegame(new Game("The Last of Us Part II", 60.0));
  // 			GameService.savegame(new Game("Marvel's Spider-Man", 40.0));
  // 			GameService.savegame(new Game("Doom Eternal", 60.0));
  // 			GameService.savegame(new Game("Sekiro: Shadows Die Twice", 60.0));
  // 			GameService.savegame(new Game("Monster Hunter: World", 40.0));
  // 			GameService.savegame(new Game("Tom Clancy's Rainbow Six Siege", 40.0));
  // 			GameService.savegame(new Game("Apex Legends", 0.0));
  // 			GameService.savegame(new Game("Fortnite", 0.0));

  // }

}
