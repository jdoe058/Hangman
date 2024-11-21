import model.HangmanField;
import model.Lang;
import model.Level;
import model.SecretWord;
import view.GameView;
import view.Menu;

import java.util.*;

public class Main {
    final private Scanner scanner = new Scanner(System.in);
    private Lang lang = Lang.LANG_EN;
    final private Menu menu = new Menu(scanner, lang);
    final private Random random = new Random();

    private Level level = Level.LEVEL_MEDIUM;

    boolean isRunning;

    private void scrollLang() {
        lang = switch (lang) {
            case LANG_EN -> Lang.LANG_RU;
            case LANG_RU -> Lang.LANG_EN;
        };
        menu.setLang(lang);
        menu.setTitle(getTitle());
    }

    private void scrollLevel() {
        level = switch (level) {
            case LEVEL_HIGH -> Level.LEVEL_MEDIUM;
            case LEVEL_MEDIUM -> Level.LEVEL_EASY;
            case LEVEL_EASY -> Level.LEVEL_HIGH;
        };
        menu.setTitle(getTitle());
    }

    private String getTitle() {
        return "%s, %s".formatted(lang.rb.getString("GAME"), lang.rb.getString(level.name()));
    }

    private void startGame() {
        scanner.nextLine();
        String[] dict = lang.rb.getString("DICT").split(" ");
        SecretWord secretWord = new SecretWord(dict[random.nextInt(dict.length)]);
        for (int i = level.startOpenLetters; i > 0; i--) {
            secretWord.openRandomLetter();
        }
        HangmanField hangmanField = new HangmanField();
        GameController controller = new GameController(lang, hangmanField, secretWord);
        GameView gameView = new GameView(scanner, lang,  getTitle(), hangmanField, secretWord, controller::process);
        gameView.run();
    }

    void init() {
        scrollLang();
        menu.add("MENU_START", this::startGame);
        menu.add("MENU_LANG", this::scrollLang);
        menu.add("MENU_LEVEL", this::scrollLevel);
        menu.add("MENU_EXIT", () -> isRunning = false);
        isRunning = true;
    }

    void run() {
        while (isRunning) {
            menu.show();
            menu.select();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.run();
    }
}
