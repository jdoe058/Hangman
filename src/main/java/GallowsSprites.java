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

    private String getSprite(Gallows gallows) {
        return gallows.contains(this) ? present : empty;
    }

    static public String getFirstSprite(Gallows gallows) {
        return BEAM.getSprite(gallows);
    }

    static public String getTwoSprite(Gallows gallows) {
        return HEAD.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    static public String getThreeSprite(Gallows gallows) {
        return LEFT_HAND.getSprite(gallows) + TORSO.getSprite(gallows)
                + RIGHT_HAND.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    static public String getFourSprite(Gallows gallows) {
        return LEFT_SOLE.getSprite(gallows) + LEFT_FOOT.getSprite(gallows)
                + RIGHT_FOOT.getSprite(gallows) + RIGHT_SOLE.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    static public String getFiveSprite(Gallows gallows) {
        return BASE.getSprite(gallows);
    }
}
