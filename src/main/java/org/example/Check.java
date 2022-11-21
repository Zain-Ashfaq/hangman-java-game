package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    ArrayList<Character> letterGuessList = new ArrayList<>();
    Scanner letterIn = new Scanner(System.in);
    protected int guessesMade = 0;
    protected int maxGuesses;
    protected int lettersNum;
    protected int rightLettersNum;


    public Check(String randWord, int maxGuesses) {
        this.lettersNum = randWord.length();
        this.rightLettersNum = 0;

        this.maxGuesses = maxGuesses;
    }

    public void incrementGuess() {
        guessesMade++;
    }

    public ArrayList<Integer> hasLetter(Character charLetter, String randWord) {
        ArrayList<Integer> letterPos = new ArrayList<>();
        for (int i = 0; i < randWord.length(); i++) {
            if (randWord.charAt(i) == charLetter) {
                letterPos.add(i);
                rightLettersNum++;
            }
        }
        letterGuessList.add(charLetter);
        return letterPos;
    }

    public Boolean guessCheck() {
        Boolean hasGameEnded = false;
        if (rightLettersNum == lettersNum) {
            hasGameEnded = true;
            System.out.println("You have won");
        } else if (guessesMade == maxGuesses) {
            hasGameEnded = true;
            System.out.println("you lost");
        }
        return hasGameEnded;
    }

    public Character getUserInput() {
        String enteredString;
        Character userEnteredChar = 0;
        Boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("This letter is incorrect. Please enter a new letter.");
            enteredString = letterIn.nextLine();

            if (enteredString.length() == 1 && enteredString.matches("[a-zA-Z]")) {
                userEnteredChar = enteredString.toLowerCase().charAt(0);
                isValidInput = true;
            } else {
                System.out.println("Only single letters allowed. Please enter again");
            }
        }
        return userEnteredChar;
    }

    public Boolean usedLetterCheck(Character enteredString) {
        Boolean isGuessLetter = false;
        if (letterGuessList.contains(enteredString)) {
            isGuessLetter = true;
        }
        return isGuessLetter;
    }

}

