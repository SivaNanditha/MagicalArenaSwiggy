package com.magicalarena;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

/**
 * Unit tests for the Magical Arena game.
 */
public class TestMagicalArena {

    private class TestArena extends Arena {
        public TestArena(Player player1, Player player2) {
            super(player1, player2);
        }

        @Override
        protected void pause() {
            // Do nothing
        }
    }

    @Test
    public void testCalculateAttackDamage() {
        Player player = new Player(50, 5, 10);
        for (int i = 0; i < 10; i++) {
            int attackDamage = player.getAttack() * player.rollDice();
            assertTrue(attackDamage >= 10 && attackDamage <= 60);
        }
    }

    @Test
    public void testCalculateDefenseStrength() {
        Player player = new Player(50, 5, 10);
        for (int i = 0; i < 10; i++) {
            int defenseStrength = player.getStrength() * player.rollDice();
            assertTrue(defenseStrength >= 5 && defenseStrength <= 30);
        }
    }

    @Test
    public void testReduceHealth() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());
        player.reduceHealth(40);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertTrue(!player.isAlive());
    }

    @Test
    public void testFight() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        Arena arena = new TestArena(player1, player2);
        arena.fight();

        // Check that one of the players is dead after the fight
        assertTrue(!player1.isAlive() || !player2.isAlive());
    }

    @Test
    public void testPlayerOrder() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        Arena arena = new TestArena(player1, player2);

        Player firstAttacker = arena.determineFirstAttacker();
        Player expectedFirstAttacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;

        assertEquals(expectedFirstAttacker, firstAttacker);
    }

    @Test
    public void testSimultaneousZeroHealth() {
        Player player1 = new Player(10, 1, 10);
        Player player2 = new Player(10, 1, 10);

        Arena arena = new TestArena(player1, player2);

        player1.reduceHealth(10);
        player2.reduceHealth(10);

        assertTrue(!player1.isAlive() && !player2.isAlive());
    }

    private class TestPlayer extends Player {
        private int fixedRoll;

        public TestPlayer(int health, int strength, int attack, int fixedRoll) {
            super(health, strength, attack, "Test Player");
            this.fixedRoll = fixedRoll;
        }

        @Override
        public int rollDice() {
            return fixedRoll;
        }
    }

    @Test
    public void testMain() {
        String input = "5000\n5\n10\n100\n10\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});
    }

    @Test
    public void testPlayerBWin() {
        Player playerA = new Player(5, 5, 10, "Player A");
        Player playerB = new Player(100, 10, 50, "Player B");
        Arena arena = new TestArena(playerA, playerB);
        arena.fight();
        assertTrue(playerB.isAlive());
        assertTrue(!playerA.isAlive());
    }

    @Test
    public void testPlayerAWin() {
        Player playerA = new Player(5000, 5, 10, "Player A");
        Player playerB = new Player(100, 10, 50, "Player B");
        Arena arena = new TestArena(playerA, playerB);
        arena.fight();
        assertTrue(playerA.isAlive());
        assertTrue(!playerB.isAlive());
    }
}
