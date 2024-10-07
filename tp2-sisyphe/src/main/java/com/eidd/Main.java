package com.eidd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu de combat de monstres et de chevaliers !");
        System.out.println("Choisissez un nom pour votre chevalier :");
        Scanner scanner = new Scanner(System.in);
        String pName = scanner.nextLine();

        System.out.println("Choisissez un niveau de difficulte (facile ou difficile) :");
        System.out.println("1. Facile");
        System.out.println("2. Difficile");
        int choice;
        do {
            System.out.println("Entrez votre choix :");
            choice = scanner.nextInt();

        } while (choice != 1 && choice != 2);

        String difficulty = choice == 1 ? "easy" : "difficult";
        Game g = new Game(pName, "Lancelot", difficulty);
        g.start();

    }
}
