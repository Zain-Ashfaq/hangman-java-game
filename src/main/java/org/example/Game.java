package org.example;


import java.util.ArrayList;
import java.util.Random;

public class Game {
    static Random randInt = new Random();


    public void startGame() {
        int randWordIndex = randInt.nextInt(WordDictionary.getWords().size());
        String randWord = WordDictionary.getWords().get(randWordIndex);
        Hangman hangman = new Hangman(randWord);
        Check check = new Check(randWord, 3);
        hangman.displayChars();

        while (!check.guessCheck()) {
            Character enteredString = check.getUserInput();


            if (!check.usedLetterCheck(enteredString)) {
                ArrayList<Integer> indexOfChars = check.hasLetter(enteredString, randWord);
                if (indexOfChars.size() != 0) {
                    for (Integer indexChar : indexOfChars) {
                        hangman.updateDisplay(indexChar, enteredString);
                    }
                } else {
                    check.incrementGuess();

                    hangman.wrongCharDisplayConsole(enteredString);
                }
                hangman.displayChars();
            } else {
                hangman.displayChars();
                System.out.println("Aleady used that char. Please enter a brand new char");
            }

        }

    }
}

