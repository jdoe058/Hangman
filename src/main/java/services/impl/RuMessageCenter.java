package services.impl;

import models.Language;
import models.LetterStorage;
import models.Level;
import models.Theme;
import services.MessageCenter;

public class RuMessageCenter implements MessageCenter {
    public final static String MASK = "Слово: %s";
    public final static String HITS = "Отгадано (%d): %s";
    public final static String MISS = "Ошибки (%d): %s";
    public static final String INPUT_LETTER = "Введите букву: ";
    public static final String INVALID_INPUT = "Ошибка ввода!";
    public static final String INPUT = "Ввод: %s";
    public static final String LETTER_IN_WORD = "Буква '%s' есть в слове";
    public static final String LETTER_NOT_WORD = "Буквы '%s' нет в слове";
    public static final String LETTER_WAS_ALREADY = "Буква '%s' уже была";
    public static final String GAME_TITLE = "\tИгра Виселица";
    public static final String TURN = "ход: %d";
    public static final String WIN = "Вы победили!";
    public static final String LOSE = "Вы проиграли!";
    public static final String MENU_SELECT = "Выберете пункт меню: ";
    public static final String MENU_FAIL = "Неверный ввод!";
    public static final String MENU_EXIT = "Выход";
    public static final String MENU_START = "Начать";
    public static final String MENU_LEVEL = "Уровень: ";
    public static final String MENU_LANGUAGE = "Язык/Language: ";
    public static final String MENU_THEME = "Тема: ";
    public static final String LANGUAGE_ENGLISH = "Английский";
    public static final String LANGUAGE_RUSSIAN = "Русский";
    public static final String LEVEL_EASY = "Простой";
    public static final String LEVEL_MEDIUM = "Нормальный";
    public static final String LEVEL_HARD = "Сложный";
    public static final String THEME_GENERAL = "Общая";
    public static final String THEME_RANDOM = "Случайная";
    public static final String PLEASE_ENTER_SOMETHING_TO_CONTINUE = "Введите что нибудь для продолжения... ";

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
