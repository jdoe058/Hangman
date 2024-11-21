package view;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameView {
    final private Scanner scanner;
    final private Lang lang;
    final private String title;
    final private HangmanField hangmanField;
    final private SecretWord secretWord;
    final private ProcessInput processInput;

    public GameView(Scanner scanner, Lang lang, String title, HangmanField hangmanField,
                    SecretWord secretWord, ProcessInput processInput) {
        this.scanner = scanner;
        this.lang = lang;
        this.title = title;
        this.hangmanField = hangmanField;
        this.secretWord = secretWord;
        this.processInput = processInput;
    }

    public void run() {
        render(false, "");
        String line = scanner.nextLine().trim().toUpperCase();
        while (!processInput.accept(line)) {
            render(false, lang.rb.getString("INPUT") + " " + line);
            line = scanner.nextLine().trim().toUpperCase();
        }
        render(true, lang.rb.getString(hangmanField.isHanged() ? "LOSE" : "WIN"));

    }

    public interface ProcessInput {
        boolean accept(String line);
    }

    private void render(boolean isOver, String message) {
        List<String> list = new ArrayList<>();
        List<String> hangmanFieldPrepared = getHangmanFieldPrepared();
        List<String> secretWordPrepared = getSecretWordPrepared(isOver);

        int i = 0;
        int j = 0;
        list.add(hangmanFieldPrepared.get(i++) + title);
        list.add(hangmanFieldPrepared.get(i++));
        list.add(hangmanFieldPrepared.get(i++) + secretWordPrepared.get(j++));
        list.add(hangmanFieldPrepared.get(i++) + secretWordPrepared.get(j++));
        list.add(hangmanFieldPrepared.get(i++) + secretWordPrepared.get(j));
        list.add(hangmanFieldPrepared.get(i) + message);
        list.add("");

        System.out.println(String.join("\n", list));
    }

    public List<String> getSecretWordPrepared(boolean isGameOver) {
        List<String> list = new ArrayList<>();
        list.add(lang.rb.getString("WORD") + " " + secretWord.getMaskedWord(isGameOver, "*", "_"));
        list.add(lang.rb.getString("HITS") + " (%d) %s".formatted(
                secretWord.guessedLetters.size(), secretWord.guessedLetters));
        list.add(lang.rb.getString("MISS") + " (%d) %s".formatted(
                secretWord.wrongLetters.size(), secretWord.wrongLetters));
        return list;
    }

    //TODO GallowsField decorate
    public List<String> getHangmanFieldPrepared() {
        List<String> list = new ArrayList<>();
        list.add("   +---+\t");
        for (int i = 0; i < Hangman.HEIGHT; i++) {
            StringBuilder s = new StringBuilder(" ");
            for (int j = 1 - Hangman.HALF_WIDTH; j < Hangman.HALF_WIDTH; j++) {
                s.append(hangmanField.getSprite(new Cell(i, j)));
            }
            list.add(s.append(" |\t").toString());
        }
        list.add("+======+\t");
        return list;
    }

}
