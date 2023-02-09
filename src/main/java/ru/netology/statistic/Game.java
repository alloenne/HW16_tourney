package ru.netology.statistic;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> playersList = new ArrayList<>();

    public Game(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public void register(Player player) {
        playersList.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : playersList) {
            /*if (playersList.contains(playerName)/)*/
            if (player.getName().toLowerCase().equals(playerName.toLowerCase())) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player e1 = findByName(playerName1);
        Player e2 = findByName(playerName2);
        if (e1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not register"
            );
        } else if (e2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not register"
            );
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
