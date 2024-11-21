package view;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Game {
    final private Scanner scanner;
    final private Lang lang;
    final private String title;
    final private HangmanField hangmanField;
    final private SecretWordConsolePrepare secretWordView;
    final private ProcessInput processInput;

    public Game(Scanner scanner, Lang lang, String title, HangmanField hangmanField,
                SecretWord secretWord, ProcessInput processInput) {
        this.scanner = scanner;
        this.lang = lang;
        this.title = title;
        this.hangmanField = hangmanField;
        this.secretWordView = new SecretWordConsolePrepare(secretWord, lang);
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
        List<String> hf = hangmanField.get();
        List<String> swv = secretWordView.get(isOver);

        list.add(hf.get(0) + title);
        list.add(hf.get(1));
        list.add(hf.get(2) + swv.get(0));
        list.add(hf.get(3) + swv.get(1));
        list.add(hf.get(4) + swv.get(2));
        list.add(hf.get(5) + message);
        list.add("");

        System.out.println(String.join("\n", list));
    }
}
