package services.impl;

import models.Language;
import services.LetterValidator;

public class LetterValidatorFactory {
    static public LetterValidator get(Language language) {
        return switch (language) {
            case RU -> RuLetterValidator::isValid;
            case EN -> EnLetterValidator::isValid;
        };
    }
}
