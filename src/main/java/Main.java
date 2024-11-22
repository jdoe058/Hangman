import controllers.GameController;
import models.*;
import services.MessageCenter;
import services.impl.LetterValidatorFactory;
import services.impl.MessageCenterFactory;
import services.impl.RuMessageCenter;
import views.*;

import java.util.*;

public class Main {
    final private GroupView<String> menuHangman = new ConsoleView(new Hangman(10, 10), "\t");
    Scanner scanner = new Scanner(System.in);
    MessageCenter mc = new RuMessageCenter();
    Menu menu;
    private boolean isMenuShow = true;
    private Level level = Level.MEDIUM;
    private Theme theme = Theme.GENERAL;
    private Language language = Language.RU;


    void startGame() {
        Language language = Language.RU;
        Hangman hangman = new Hangman();
        GameController gameController = new GameController(
                hangman,
                new ConsoleView(hangman, "\t"),
                new ConsoleInputView(scanner),
                MessageCenterFactory.get(language),
                LetterValidatorFactory.get(language),
                new SecretWord("тестирование", "_", "*"));
        gameController.run();
    }

    String menuTitle() {
        return mc.titleMessage();
    }

    void menuExit() {
        isMenuShow = false;
    }

    String menuLevelMessage() {
        return "Уровень: " + level.name();
    }

    void menuLevelSelect() {
        level = switch (level) {
            case HIGH -> Level.EASY;
            case MEDIUM -> Level.HIGH;
            case EASY -> Level.MEDIUM;
        };
    }

    String menuLanguageMessage() {
        return "Язык: " + language.name();
    }

    void menuLanguageSelect() {
        language = switch (language) {
            case RU -> Language.EN;
            case EN -> Language.RU;
        };
    }

    String menuThemeMessage() {
        return "Тема: " + theme.name();
    }

    void menuThemeSelect() {
        theme = switch (theme) {
            case RANDOM -> Theme.GENERAL;
            case GENERAL -> Theme.RANDOM;
        };
    }

    public void menuShow() {
        while (isMenuShow) {
            menu.show();
            menu.select();
        }
    }

    public void menuInit() {
        menu = new MenuGroupView(this::menuTitle, mc::menuSelectMessage, mc::menuFailMessage, menuHangman);

        menu.add(mc::menuStartMessage, this::startGame);
        menu.add(this::menuLanguageMessage, this::menuLanguageSelect);
        menu.add(this::menuThemeMessage, this::menuThemeSelect);
        menu.add(this::menuLevelMessage, this::menuLevelSelect);
        menu.add(mc::menuExitMessage, this::menuExit);
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.menuInit();
        main.menuShow();
    }
}
