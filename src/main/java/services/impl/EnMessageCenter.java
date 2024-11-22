package services.impl;

import models.Language;
import models.LetterStorage;
import models.Level;
import models.Theme;
import services.MessageCenter;

public class EnMessageCenter implements MessageCenter {
    public final static String MASK = "Word: %s";
    public final static String HITS = "Hits (%d): %s";
    public final static String MISS = "Miss (%d): %s";
    public static final String INPUT_LETTER = "Input letter: ";
    public static final String INVALID_INPUT = "Invalid input!";
    public static final String INPUT = "Input: %s";
    public static final String LETTER_IN_WORD = "The letter '%s' is in the word";
    public static final String LETTER_NOT_WORD = "The letter '%s' is not in the word";
    public static final String LETTER_WAS_ALREADY = "The letter '%s' was already there";
    public static final String GAME_TITLE = "\tGame Gallows";
    public static final String TURN = "turn: %d";
    public static final String WIN = "You win!";
    public static final String LOSE = "You lost!";
    public static final String MENU_SELECT = "Select a menu item: ";
    public static final String MENU_FAIL = "Invalid input!";
    public static final String MENU_EXIT = "Exit";
    public static final String MENU_START = "Start";
    public static final String MENU_LEVEL = "Level: ";
    public static final String MENU_LANGUAGE = "Language: ";
    public static final String MENU_THEME = "Theme: ";
    public static final String LANGUAGE_ENGLISH = "English";
    public static final String LANGUAGE_RUSSIAN = "Russian";
    public static final String LEVEL_EASY = "Easy";
    public static final String LEVEL_MEDIUM = "Medium";
    public static final String LEVEL_HARD = "Hard";
    public static final String THEME_GENERAL = "General";
    public static final String THEME_RANDOM = "Random";
    public static final String PLEASE_ENTER_SOMETHING_TO_CONTINUE = "Please enter something to continue...";

    @Override
    public String maskMessage(String word) {
        return MASK.formatted(word);
    }

    @Override
    public String hitsMessage(LetterStorage letters) {
        return HITS.formatted(letters.size(), letters);
    }

    @Override
    public String missMessage(LetterStorage letters) {
        return MISS.formatted(letters.size(), letters);
    }

    @Override
    public String inputLetterMessage() {
        return INPUT_LETTER;
    }

    @Override
    public String invalidInputMessage() {
        return INVALID_INPUT;
    }

    @Override
    public String userInputMessage(String string) {
        return INPUT.formatted(string);
    }

    @Override
    public String letterInWordMessage(String string) {
        return LETTER_IN_WORD.formatted(string);
    }

    @Override
    public String letterNotWordMessage(String string) {
        return LETTER_NOT_WORD.formatted(string);
    }

    @Override
    public String letterWasAlreadyThereMessage(String string) {
        return LETTER_WAS_ALREADY.formatted(string);
    }

    @Override
    public String titleMessage() {
        return GAME_TITLE;
    }

    @Override
    public String turnMessage(int turn) {
        return TURN.formatted(turn);
    }

    @Override
    public String winMessage() {
        return WIN;
    }

    @Override
    public String loseMessage() {
        return LOSE;
    }

    @Override
    public String menuSelectMessage() {
        return MENU_SELECT;
    }

    @Override
    public String menuFailMessage() {
        return MENU_FAIL;
    }

    @Override
    public String menuExitMessage() {
        return MENU_EXIT;
    }

    @Override
    public String menuStartMessage() {
        return MENU_START;
    }

    @Override
    public String menuLevelMessage() {
        return MENU_LEVEL;
    }

    @Override
    public String menuLanguageMessage() {
        return MENU_LANGUAGE;
    }

    @Override
    public String menuThemeMessage() {
        return MENU_THEME;
    }

    @Override
    public String enumValueMessage(Language language) {
        return switch (language) {
            case EN -> LANGUAGE_ENGLISH;
            case RU -> LANGUAGE_RUSSIAN;
        };
    }

    @Override
    public String enumValueMessage(Level level) {
        return switch (level) {
            case EASY -> LEVEL_EASY;
            case MEDIUM -> LEVEL_MEDIUM;
            case HIGH -> LEVEL_HARD;
        };
    }

    @Override
    public String enumValueMessage(Theme theme) {
        return switch (theme) {
            case GENERAL -> THEME_GENERAL;
            case RANDOM -> THEME_RANDOM;
        };
    }

    @Override
    public String enterSomethingToContinue() {
        return PLEASE_ENTER_SOMETHING_TO_CONTINUE;
    }
}


