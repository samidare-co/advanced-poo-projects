package com.eidd;

public class DifficultMonster extends Monster {
    private int lives = 4;
    private String name;

    public DifficultMonster(String name) {
        this.name = name;
        this.lives = 4;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Le monstre difficile " + name + " possede " + lives + " vies");
    }

}
