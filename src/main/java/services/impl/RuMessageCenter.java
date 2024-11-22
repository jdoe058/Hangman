package services.impl;

import models.LetterStorage;
import services.MessageCenter;

public class RuMessageCenter implements MessageCenter {
    private final static String MASK = "Слово: %s";
    private final static String HITS = "Отгадано (%d): %s";
    private final static String MISS = "Ошибки (%d): %s";
    private static final String INPUT_LETTER = "Введите букву: ";
    public static final String INVALID_INPUT = "Ошибка ввода!";

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
        return "Ввод: %s".formatted(string);
    }

    @Override
    public String letterInWordMessage(String string) {
        return "Буква '%s' есть в слове".formatted(string);
    }

    @Override
    public String letterNotWordMessage(String string) {
        return "Буквы '%s' нет в слове".formatted(string);
    }

    @Override
    public String letterWasAlreadyThereMessage(String string) {
        return "Буква '%s' уже была".formatted(string);
    }

    @Override
    public String titleMessage() {
        return "\tИгра Виселица";
    }

    @Override
    public String turnMessage(int turn) {
        return "ход: %d".formatted(turn);
    }

    @Override
    public String winMessage() {
        return "Вы победили!";
    }

    @Override
    public String loseMessage() {
        return "Вы проиграли!";
    }

    @Override
    public String menuSelectMessage() {
        return "Выберете пункт меню:";
    }

    @Override
    public String menuFailMessage() {
        return "Неверный ввод!";
    }

    @Override
    public String menuExitMessage() {
        return "Выход";
    }

    @Override
    public String menuStartMessage() {
        return "Начать";
    }
}


