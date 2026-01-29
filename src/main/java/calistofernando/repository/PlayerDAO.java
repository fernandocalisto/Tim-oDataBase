package calistofernando.repository;

import calistofernando.model.Player;

import java.util.List;

public interface PlayerDAO {
    void savePlayer (Player p) ;
    void deletePlayer (int id) ;
    Player getPlayer (int id) ;
    List<Player> getAllPlayers () ;
}
