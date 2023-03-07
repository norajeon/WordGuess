package com.github.zipcodewilmington;
import java.util.Scanner;
//nora
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    static String[] words = {"meow", "woof", "dogs", "cats", "bark"};
    static String[] users = {"_", "_", "_", "_"};
    public static String getGuesses(String guesses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(guesses);
        String guess = scanner.nextLine();
        return guess;
    }
    public static String gameOver() {
        String gameOver = ":( You died.";
        return gameOver;
    }


    public static String randomWord() {
//        String random = "";
        // int rNum = new Random().nextInt(words.length);
        String random = words[(int) (Math.random() * words.length)];
//        for (String abc : words) {
//            random = abc;
//        }
        return random;
    }



    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.runGame();


    } // main


    public void runGame() {

//        String random = words[(int) (Math.random() * words.length)];

        int triesAllowed = words.length;
        int userTries = 0;
        boolean wantToPlay = true;
        boolean correct = false;
        char[] r = randomWord().toCharArray();
        System.out.println(r);
        while (wantToPlay) {
            while (userTries < triesAllowed && !correct) {

                System.out.println("Guess a letter :)");
                String letter = getGuesses("");
                String whatever = "";
                String yeah = "";
                for (int i = 0; i < r.length; i++) {
                    whatever = String.valueOf(r[i]);
                    yeah = String.valueOf(users[i]);
                    if (whatever.equals(letter)) {
                            yeah.equals(whatever);
                        System.out.print(letter);
                    } else {
                        System.out.println("Incorrect guess!");
                        userTries++;
                    }
                }



//        StringBuilder a = new StringBuilder();
//        for (int i = 0; i < r.length; i++) {
//            a.append(String.valueOf(r[i]));
//        }

            } // inside if; or should this be while?
//                else { gameOver();
//
//            }

            System.out.println("Do you want to play another game? :) Yes/No");
            if (getGuesses("").equals("Yes")) {
                wantToPlay = true;
            } else {
                wantToPlay = false;
            }
        } // outside while

    }


} // class