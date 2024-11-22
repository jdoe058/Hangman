package services.impl;

import services.LetterValidator;

public class RuLetterValidator implements LetterValidator {
    @Override
    public boolean isValid(String line) {
        return line.matches("^[А-ЯЁ]$");
    }
}
