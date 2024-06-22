package com.magicalarena;

/**
 * The Arena class manages the fight between two players.
 */
public class Arena {
    private Player player1;
    private Player player2;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Determines the player with the lower health to attack first.
     */
    public Player determineFirstAttacker() {
        return player1.getHealth() <= player2.getHealth() ? player1 : player2;
    }

    /**
     * Conducts the fight between the two players until one of them is dead.
     */
    public void fight() {
        Player attacker = determineFirstAttacker();
        Player defender = attacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("Attacker: " + attacker.getName());
            System.out.println("Defender: " + defender.getName());

            int attackRoll = attacker.rollDice();
            int defenseRoll = defender.rollDice();
            System.out.println(attacker.getName() + " rolls: " + attackRoll);
            System.out.println(defender.getName() + " rolls: " + defenseRoll);

            int attackDamage = attacker.getAttack() * attackRoll;
            int defenseStrength = defender.getStrength() * defenseRoll;
            System.out.println("Attack Damage: " + attackDamage);
            System.out.println("Defense Strength: " + defenseStrength);

            int damage = Math.max(0, attackDamage - defenseStrength);
            System.out.println("Damage Dealt: " + damage);

            defender.reduceHealth(damage);
            System.out.println(defender.getName() + "'s Remaining Health: " + defender.getHealth());
            System.out.println();

            if (!defender.isAlive()) {
                break;
            }

            // Swap attacker and defender for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;

            pause();
        }

        // Announce the winner
        if (player1.isAlive()) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }

    protected void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, Failed to complete operation");
        }
    }
}
