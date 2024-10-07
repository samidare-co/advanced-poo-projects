package com.eidd;

public class Dice {
    private static int result;

    public static int roll() {
        result = (int) (Math.random() * 6) + 1;
        return result;
    }

    public static int getResult() {
        return result;
    }

}
