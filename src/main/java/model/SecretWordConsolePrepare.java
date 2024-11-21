package model;

import java.util.ArrayList;
import java.util.List;

public class SecretWordConsolePrepare {
    final private SecretWord swc;
    final private Lang lang;

    public SecretWordConsolePrepare(SecretWord swc, Lang lang) {
        this.swc = swc;
        this.lang = lang;
    }

    public List<String> get(boolean isGameOver) {
        List<String> list = new ArrayList<>();
        list.add(lang.rb.getString("WORD") + " " + swc.getMaskedWord(isGameOver, "*", "_"));
        list.add(lang.rb.getString("HITS") + " (%d) %s".formatted(
                swc.guessedLetters.size(), swc.guessedLetters));
        list.add(lang.rb.getString("MISS") + " (%d) %s".formatted(
                swc.wrongLetters.size(), swc.wrongLetters));
        return list;
    }
}
