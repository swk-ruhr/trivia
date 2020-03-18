package com.adaptionsoft.games.trivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void instantiate_Player() {
        Player player = new Player("Player 1");
        assertEquals("Player 1", player.getName());
    }
}
