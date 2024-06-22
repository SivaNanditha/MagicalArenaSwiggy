package com.magicalarena;

import java.util.Random;

/**
 * The Player class models a player with health, strength, and attack attributes.
 * Each player can roll a dice and take damage.
 */
public class Player {
    private int health;
    private int strength;
    private int attack;
    private String name;
    private Random random;

    public Player(int health, int strength, int attack, String name) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.name = name;
        this.random = new Random();
    }

    public Player(int health, int strength, int attack) {
        this(health, strength, attack, "Player");
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }
}
