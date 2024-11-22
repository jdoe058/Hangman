package models;

import java.util.*;

public class SecretWord {
    final private String word;
    final private Set<String> mask;
    final private String delimiter;
    final private String mark;

    public SecretWord(String word, String delimiter, String mark) {
        this.word = word.toUpperCase();
        this.delimiter = delimiter;
        this.mark = mark;
        mask = new HashSet<>();
        Collections.addAll(mask, this.word.split(""));
    }

    public String getSecret() {
        var splitWord = word.split("");
        return String.join(delimiter, splitWord);
    }

    public String getMask() {
        var splitMask = word.replaceAll(mask.toString(), mark).split("");
        return String.join(delimiter, splitMask);
    }

    public boolean isLetterInWord(String letter) {
        return word.contains(letter);
    }

    public void openLetterMask(String letter) {
        if (!mask.remove(letter)) {
            throw new ArrayStoreException("SecretWord: letter '%s' is already open");
        }
    }

    public boolean isSolved() {
        return mask.isEmpty();
    }
}
