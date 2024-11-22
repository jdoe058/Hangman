package services;

import models.Language;

public class Dictionary {
    public static String get(Language language) {
        return switch (language) {
            case RU -> "тестирование";
            case EN -> "testing";
        };
    }
}
