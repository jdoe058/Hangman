package services.impl;

public class RuLetterValidator {
    public static boolean isValid(String line) {
        return line.matches("^[А-ЯЁ]$");
    }
}
