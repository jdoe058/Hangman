public enum Hangman {
    HEAD("  o  |", "     |"),
    TORSO("|", " "),
    LEFT_HAND(" /", "  "),
    RIGHT_HAND("\\ |", "  |"),
    LEFT_FOOT("/ ", "  "),
    RIGHT_FOOT("\\", " "),
    LEFT_SOLE("_", " "),
    RIGHT_SOLE("_|", " |");

    final public String present;
    final public String empty;

    Hangman(String present, String empty) {
        this.present = present;
        this.empty = empty;
    }

    private String getImage(Field field) {
        return field.contains(this) ? present : empty;
    }

    static public String getTopPart(Field field) {
        return HEAD.getImage(field);
    }

    static public String getMiddlePart(Field field) {
        return LEFT_HAND.getImage(field) + TORSO.getImage(field) + RIGHT_HAND.getImage(field);
    }

    static public String getBottomPart(Field field) {
        return LEFT_SOLE.getImage(field) + LEFT_FOOT.getImage(field)
                + RIGHT_FOOT.getImage(field) + RIGHT_SOLE.getImage(field);
    }
}
