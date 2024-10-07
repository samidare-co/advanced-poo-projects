package com.eidd;

public class Monster {
    private int lives;
    private String name;
    private int roll;

    public void printInfo() {
        System.out.println("Monster:");
    }

    public int rollDice() {
        Dice.roll();
        roll = Dice.getResult();
        return roll;
    }

    public int getRoll() {
        return roll;
    }

    public void loseLife() {
        lives--;
    }

}
