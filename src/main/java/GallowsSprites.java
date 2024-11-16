public enum GallowsSprites {
    HEAD("  o  |\t", "     |\t"),
    TORSO("|", " "),
    LEFT_HAND(" /", "  "),
    RIGHT_HAND("\\ |\t", "  |\t"),
    LEFT_FOOT("/ ", "  "),
    RIGHT_FOOT("\\", " "),
    LEFT_SOLE("_", " "),
    RIGHT_SOLE("_|\t", " |\t");

    final private String present;
    final private String empty;

    GallowsSprites(String present, String empty) {
        this.present = present;
        this.empty = empty;
    }

    private String getSprite(Field field) {
        return field.contains(this) ? present : empty;
    }

    static public String getTopPart(Field field) {
        return HEAD.getSprite(field);
    }

    static public String getMiddlePart(Field field) {
        return LEFT_HAND.getSprite(field) + TORSO.getSprite(field) + RIGHT_HAND.getSprite(field);
    }

    static public String getBottomPart(Field field) {
        return LEFT_SOLE.getSprite(field) + LEFT_FOOT.getSprite(field)
                + RIGHT_FOOT.getSprite(field) + RIGHT_SOLE.getSprite(field);
    }
}
