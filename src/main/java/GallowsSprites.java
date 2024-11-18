import java.util.ArrayList;
import java.util.List;

public enum GallowsSprites {
    BASE("+====+\t", "      \t"),
    PILLAR("|\t", " \t"),
    BEAM("  +--+\t", "      \t"),
    HEAD("  o  ", "     "),
    TORSO("|", " "),
    LEFT_HAND(" /", "  "),      // пустота над ступней
    RIGHT_HAND("\\ ", "  "),    // пустота над ступней
    LEFT_FOOT("/ ", "  "),      // пустота под торсом
    RIGHT_FOOT("\\", " "),
    LEFT_SOLE("_", " "),
    RIGHT_SOLE("_", " ");

    final private String present;
    final private String empty;

    GallowsSprites(String present, String empty) {
        this.present = present;
        this.empty = empty;
    }

    public interface Sprites {
        String getSprite(Gallows g);
    }

    public static final List<Sprites> rowSprites = new ArrayList<>(List.of(
            BEAM::getSprite,
            GallowsSprites::getRowWithHeadSprites,
            GallowsSprites::getRowWithHandAndTorsoSprites,
            GallowsSprites::getRowWithFootAndSoleSprites,
            BASE::getSprite
    ));

    static private String getRowWithHeadSprites(Gallows gallows) {
        return HEAD.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    static private String getRowWithHandAndTorsoSprites(Gallows gallows) {
        return LEFT_HAND.getSprite(gallows) + TORSO.getSprite(gallows)
                + RIGHT_HAND.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    static private String getRowWithFootAndSoleSprites(Gallows gallows) {
        return LEFT_SOLE.getSprite(gallows) + LEFT_FOOT.getSprite(gallows)
                + RIGHT_FOOT.getSprite(gallows) + RIGHT_SOLE.getSprite(gallows) + PILLAR.getSprite(gallows);
    }

    private String getSprite(Gallows gallows) {
        return gallows.contains(this) ? present : empty;
    }
}
