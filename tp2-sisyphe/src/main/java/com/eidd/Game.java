package com.eidd;

public class Game {
    private Player p;
    private String difficulty;
    private Monster m;
    private int step;

    public Game(String playerName, String monsterName, String difficulty) {
        p = new Player(playerName);
        this.difficulty = difficulty;
        step = 1;
        if (difficulty.equals("easy")) {
            m = new EasyMonster(monsterName);
        } else if (difficulty.equals("difficult")) {
            m = new DifficultMonster(monsterName);
        }

    }

    public void start() {
        System.out.println("+---------------------------------+");
        System.out.println("| SISYPHE GAME (BACK TO THE 1970's) |");
        System.out.println("+---------------------------------+");
        p.printInfo();
        m.printInfo();

        System.out.println("Game started!");

        while (p.getLives() > 0) {
            System.out.println("Step #" + step);
            int playerRoll = p.rollDice();
            int monsterRoll = m.rollDice();

            System.out.println("Player rolled " + playerRoll);
            System.out.println("Monster rolled " + monsterRoll);
            if (playerRoll >= monsterRoll) {
                System.out.println("L'attaque est remportee par le chevalier");
                p.addScore(1);
                if (difficulty.equals("easy")) {
                    m.loseLife();
                } else if (difficulty.equals("difficult")) {
                    int mSecondRoll = m.rollDice();
                    if (mSecondRoll != 6) {

                        m.loseLife();
                    }
                }
            } else if (monsterRoll > playerRoll) {
                System.out.println("L'attaque est remportee par le monstre");
                p.loseLife();
            }
            step++;

        }
        System.out.println("Mort heroique et tragique du chevalier " + p.getScore());
        System.out.println("Score : " + p.getScore());
    }

}
