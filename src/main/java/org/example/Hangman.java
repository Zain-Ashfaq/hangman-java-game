package org.example;


import java.util.ArrayList;

public class Hangman {


    protected ArrayList<Character> rightCharDisplay = new ArrayList<>();
    protected ArrayList<Character> wrongCharDisplay = new ArrayList<>();


    public Hangman(String desiredWord) {


        for (int i = 0; i < desiredWord.length(); i++) {
            rightCharDisplay.add('_');
        }
    }


    public void displayChars() {

        for (Character letterDisplay : rightCharDisplay) {
            System.out.print(letterDisplay + " ");
        }
        System.out.print("\nIncorrect letters you have entered are here: ");
        for (Character letterDisplay : wrongCharDisplay) {
            System.out.print(letterDisplay + " ");
        }
        System.out.print("\n");
    }

    public void updateDisplay(int index, Character charLetter) {
        rightCharDisplay.set(index, charLetter);
    }

    public void wrongCharDisplayConsole(Character charLetter) {
        wrongCharDisplay.add(charLetter);
    }


}

