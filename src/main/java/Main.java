import controllers.GameController;
import models.*;
import services.*;
import models.Dictionary;
import services.impl.LetterValidatorFactory;
import services.impl.MessageCenterFactory;
import views.*;

import java.util.*;

public class Main {
    private final static GroupView<String> menuHangman = new ConsoleView(new Hangman(10, 10), "\t");
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final InputView inputView = new ConsoleInputView(scanner);

    private Menu menu;

    private boolean isMenuShow = true;
    private Level level = Level.MEDIUM;
    private Theme theme = Theme.GENERAL;
    private Language language = Language.RU;
    MessageCenter mc = MessageCenterFactory.get(language);


    void startGame() {
        Hangman hangman = switch (level) {
            case EASY -> new Hangman();
            case MEDIUM -> new Hangman(3, Hangman.MAX_STAGE_OF_HANGING);
            case HIGH -> new Hangman(5, Hangman.MAX_STAGE_OF_HANGING - 2);
        };

        List<String> dict;
        try {
            dict = Dictionary.INSTANCE.get(theme, language);
        } catch (DictionaryNotFountException e) {
            inputView.getInput(mc.dictionaryNotFoundMessage(theme, language));
            return;
        }

        String word = dict.get(random.nextInt(dict.size()));

        GameController gameController = new GameController(
                hangman,
                new ConsoleView(hangman, "\t"),
                inputView,
                mc,
                LetterValidatorFactory.get(language),
                new SecretWord(word, "_", "*"));
        gameController.run();
    }

    String menuStartMessage() {
        return mc.menuStartMessage();
    }

    String menuExitMessage() {
        return mc.menuExitMessage();
    }

    String menuTitleMessage() {
        return mc.titleMessage();
    }

    void menuExit() {
        isMenuShow = false;
    }

    public void menuShow() {
        while (isMenuShow) {
            menu.show();
            menu.select();
        }
    }

    String menuLevelMessage() {
        return mc.menuLevelMessage() + mc.enumValueMessage(level);
    }

    void menuLevelSelect() {
        level = switch (level) {
            case HIGH -> Level.EASY;
            case MEDIUM -> Level.HIGH;
            case EASY -> Level.MEDIUM;
        };
    }

    String menuLanguageMessage() {
        return mc.menuLanguageMessage() + mc.enumValueMessage(language);
    }

    void menuLanguageSelect() {
        language = switch (language) {
            case RU -> Language.EN;
            case EN -> Language.RU;
        };
        mc = MessageCenterFactory.get(language);
    }

    String menuThemeMessage() {
        return mc.menuThemeMessage() + mc.enumValueMessage(theme);
    }

    void menuThemeSelect() {
        theme = switch (theme) {
            case RANDOM -> Theme.GENERAL;
            case GENERAL -> Theme.RANDOM;
        };
    }

    String menuSelectMessage() {
        return mc.menuSelectMessage();
    }

    String menuFailMessage() {
        return mc.menuFailMessage();
    }

    public void menuInit() {
        menu = new MenuGroupView(this::menuTitleMessage, this::menuSelectMessage, this::menuFailMessage,
                menuHangman, inputView);

        menu.add(this::menuStartMessage, this::startGame);
        menu.add(this::menuLanguageMessage, this::menuLanguageSelect);
        menu.add(this::menuThemeMessage, this::menuThemeSelect);
        menu.add(this::menuLevelMessage, this::menuLevelSelect);
        menu.add(this::menuExitMessage, this::menuExit);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menuInit();
        main.menuShow();
    }
}
