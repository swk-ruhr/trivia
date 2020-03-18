package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeTest {

	@Test
	void player_wins_after_6_correct_answers() {
        Game game = new Game();
        game.addPlayer("Kosta");
        assertTrue(game.wasCorrectlyAnswered());
        assertTrue(game.wasCorrectlyAnswered());
        assertTrue(game.wasCorrectlyAnswered());
        assertTrue(game.wasCorrectlyAnswered());
        assertTrue(game.wasCorrectlyAnswered());
        assertFalse(game.wasCorrectlyAnswered());
    }

    @Test
    void rolling_without_player_should_throw_IllegalStateException() {
        Game game = new Game();
        assertThrows(IllegalStateException.class, () -> game.roll(3));
    }

    @Test
    void game_is_not_playable_with_one_player() {
        Game game = new Game();
        game.addPlayer("Player 1");
        assertFalse(game.isPlayable());
    }

    @Test
    void game_is_playable_with_at_least_2_players() {
        Game game = new Game();
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        assertTrue(game.isPlayable());
    }

    @Test
    void cannot_add_same_playername_twice() {
        Game game = new Game();
        game.addPlayer("Player 1");

        assertThrows(PlayerAlreadyExistsException.class,
                () -> game.addPlayer("Player 1"));
    }

    @Test
    void cannot_add_more_than_5_players() {
        Game game = new Game();
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");
        game.addPlayer("Player 4");
        game.addPlayer("Player 5");

        assertThrows(MaximumPlayersReachedException.class,
                () -> game.addPlayer("Player 6"));
    }

    @Test
    void given_one_player_expect_playercount_1() {
        Game game = new Game();
        game.addPlayer("Player 1");
        int playerCount = game.howManyPlayers();
        assertEquals(1, playerCount);
    }

    //TODO answer wrong => penalty
    //TODO Freikaufen von der penalty
    //TODO Player-Klasse einführen
    //TODO erlaube nur 6 Spieler
}
