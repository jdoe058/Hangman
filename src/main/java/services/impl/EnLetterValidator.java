package services.impl;

public class EnLetterValidator {
    public static boolean isValid(String line) {
        return line.matches("^[A-Z]$");
    }
}
