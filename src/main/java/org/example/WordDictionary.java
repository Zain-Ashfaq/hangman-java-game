package org.example;

import java.util.ArrayList;

public class WordDictionary {
    static ArrayList<String> wordList = new ArrayList<>();

    static {
        wordList.add("hello");
        wordList.add("goodbye");
        wordList.add("sauce");
        wordList.add("laptop");
        wordList.add("java");
    }

    public static ArrayList<String> getWords() {
        return wordList;
    }

    public static void setWords(ArrayList<String> words) {
        WordDictionary.wordList = words;
    }
}
