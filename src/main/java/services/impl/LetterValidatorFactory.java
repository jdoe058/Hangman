package services.impl;

import models.Language;
import services.LetterValidator;

public class LetterValidatorFactory {
    static public LetterValidator get(Language language) {
        return switch (language) {
            case RU -> new RuLetterValidator();
            case EN -> new EnLetterValidator();
        };
    }
}
