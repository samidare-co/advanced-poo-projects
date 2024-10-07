package com.eidd;

public class EasyMonster extends Monster {
    private int lives = 1;
    private String name;

    public EasyMonster(String name) {
        this.name = name;
        this.lives = 1;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Le monstre facile " + name + " possede " + lives + " vies");
    }
}
