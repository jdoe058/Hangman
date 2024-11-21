package model;

public enum Level {
    LEVEL_HIGH(0),
    LEVEL_MEDIUM(1),
    LEVEL_EASY(2);

    final public int startOpenLetters;

    Level(int startOpenLetters) {
        this.startOpenLetters = startOpenLetters;
    }
}
