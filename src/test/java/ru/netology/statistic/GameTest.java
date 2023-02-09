package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    ArrayList<Player> playersList = new ArrayList<>();
    Game game1 = new Game(playersList);
    Player p1 = new Player(1, "Petya", 7);
    Player p2 = new Player(2, "Vasya", 2);
    Player p3 = new Player(3, "Olya", 9);
    Player p4 = new Player(4, "Katya", 7);
    Player p5 = new Player(5, "Petr", 5);

    @BeforeEach
    public void setup() {
        game1.register(p1);
        game1.register(p2);
        game1.register(p3);
        game1.register(p4);
    }

    @Test
    public void shouldRegister() {
        game1.register(p5);
        Player[] exp = {p1, p2, p3, p4, p5};
        Player[] act = playersList.toArray(new Player[0]);
        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldFindByName() {
        Player exp = p1;
        Player act = game1.findByName("Petya");
        Assertions.assertEquals(exp, act);

    }

    @Test
    public void shouldNotFindByName() {
        Player exp = null;
        Player act = game1.findByName("Tanya");
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldFirstNotRegistred() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game1.round("Tanya", "Olya");
        });
    }

    @Test
    public void shouldSecondNotRegistred() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game1.round("Olya", "Tanya");
        });
    }

    @Test
    public void shouldBothNotRegistred() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game1.round("Sonya", "Tanya");
        });
    }
    @Test
    public void shouldFirstWin() {
        int exp = 1;
        int act = game1.round("Olya", "Vasya");
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldSecondWin() {
        int exp = 2;
        int act = game1.round("Petya", "Olya");
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldBothEquals() {
        int exp = 0;
        int act = game1.round("Petya", "Katya");
        Assertions.assertEquals(exp, act);
    }




}
