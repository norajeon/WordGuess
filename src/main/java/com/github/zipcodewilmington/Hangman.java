package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
//nora
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    boolean wantToPlay;
    String[] words = {"meow", "woof", "dogs", "cats", "bark"};
    char[] users = {'_', '_', '_', '_'};

    char[] wrongGuesses = new char[5];

    // reads 1 char from the user input and returns it
    public char getGuess() {
        Scanner scan = new Scanner(System.in);
        char guess = scan.next().charAt(0);
        return guess;
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine();
        return guess;
    }

//    boolean newGame() {
//        System.out.println("Do you want to play another game? :) Yes/No");
//        if (getGuesses("").equals("Yes")) {
//            return true;
//
//        } else {
//            return false;
//        }
//    }


    boolean wonGame() {
        for (char a : users) {
            if (a == '_') {
                return false;

            }
        }
        return true;
    }


    public String randomWord() {
        String random = words[(int) (Math.random() * words.length)];
        return random;
    }

//    public static String userLetters() {
//        String[] usersGuesses = new String[words.length];
//        for (int i = 0; i < words.length; i++) {
//            usersGuesses[i].equals("_");
//        }
//        return usersGuesses.toString();
//    }

    // public ArrayList<String> newGuesses = new ArrayList<String>();


    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.runGame();


    } // main 🙊


    public void runGame() {

        int triesAllowed = words.length;
        int userFails = 0;
        wantToPlay = true;

        while (wantToPlay) {
            System.out.println("Welcome to Hangman :) You have " + triesAllowed + " tries!");
            System.out.println("_ _ _ _");


            char[] r = randomWord().toCharArray();
            // System.out.println(r);


            while (userFails < triesAllowed) {
                System.out.println("Guess a letter :)");
                boolean matchedAny = false; // this is already set to false before it's used, so doesn't need setting after
                char guess = getGuess();




                // scan through the correct word, and see if the letter was included
                for (int i = 0; i < r.length; i++) {
                    if (guess == r[i]) {
                        users[i] = guess;
                        matchedAny = true;
                    }
                }

                // display the current guessed letters
                for (int i = 0; i < r.length; i++) {
                    System.out.print(users[i] + " ");
                }
                System.out.println("");


                if (matchedAny) {
                    // they got one right, was it the final one they needed?
                    if (wonGame()) {
                        // it was! stop asking them to guess
                        System.out.println("Congratulations you guessed the correct word!");
                        break;
                    }
                } else {
                    int remainingTries = triesAllowed - userFails;
                    if (remainingTries > 0) {
                        System.out.println("Sorry! Please Try Again. You have " + remainingTries + " tries remaining.");
                    } else {
                        System.out.println("lmao rekt");
                    }
                    // it was wrong :(
                    userFails++;
                }

                // then see how many fails they have, and decide if it's time to DIE or try again

            }
            // inside while
            System.out.println("Do you want to play another game? :) Yes/No");
            if (getUserInput().equals("Yes")) {
                wantToPlay = true;
                userFails = 0;
                users = new char[]{'_', '_', '_', '_'};
            } else {
                wantToPlay = false;
            }// outside while

        }
    }
} // class