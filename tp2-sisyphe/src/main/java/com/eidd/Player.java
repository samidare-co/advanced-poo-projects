package com.eidd;

public class Player {
    private int lives = 10;
    private String name;
    private int score = 0;
    private int roll;

    public Player(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Player:");
        System.out.println("Le chevalier joueur " + name + " possede " + lives + " vie(s) et un score de " + score);
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int rollDice() {
        Dice.roll();
        roll = Dice.getResult();
        return roll;
    }

    public int getRoll() {
        return roll;
    }

    public void addScore(int points) {
        score += points;
    }

    public void loseLife() {
        lives--;
    }

}
