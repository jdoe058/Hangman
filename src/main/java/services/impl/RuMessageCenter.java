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

    public String titleMessage(int turn) {
        return "Игра Виселица, ход: %d".formatted(turn);
    }

    public String winMessage() {
        return "Вы победили!";
    }

    public String loseMessage() {
        return "Вы проиграли!";
    }
}

