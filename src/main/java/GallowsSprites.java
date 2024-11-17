public enum GallowsSprites {

    BASE("+====+\t", "      \t"),
    PILLAR("|\t", " \t"),
    BEAM("  +--+", "      \t"),
    HEAD("  o  ", "     "),
    TORSO("|", " "),
    LEFT_HAND(" /", "  "),
    RIGHT_HAND("\\ ", "  "),
    LEFT_FOOT("/ ", "  "),
    RIGHT_FOOT("\\", " "),
    LEFT_SOLE("_", " "),
    RIGHT_SOLE("_", " ");

    final private String present;
    final private String empty;

    GallowsSprites(String present, String empty) {
        this.present = present;
        this.empty = empty;
    }

    private String getSprite(Field field) {
        return field.contains(this) ? present : empty;
    }

    static public String getFirstSprite(Field field) {
        return BEAM.getSprite(field);
    }

    static public String getTwoSprite(Field field) {
        return HEAD.getSprite(field) + PILLAR.getSprite(field);
    }

    static public String getThreeSprite(Field field) {
        return LEFT_HAND.getSprite(field) + TORSO.getSprite(field)
                + RIGHT_HAND.getSprite(field) + PILLAR.getSprite(field);
    }

    static public String getFourSprite(Field field) {
        return LEFT_SOLE.getSprite(field) + LEFT_FOOT.getSprite(field)
                + RIGHT_FOOT.getSprite(field) + RIGHT_SOLE.getSprite(field) + PILLAR.getSprite(field);
    }

    static public String getFiveSprite(Field field) {
        return BASE.getSprite(field);
    }
}
