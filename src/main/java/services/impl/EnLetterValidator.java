package services.impl;

import services.LetterValidator;

public class EnLetterValidator implements LetterValidator {
    @Override
    public boolean isValid(String line) {
        return line.matches("^[A-Z]$");
    }
}
