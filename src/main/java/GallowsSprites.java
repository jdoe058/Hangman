import java.util.ArrayList;
import java.util.List;

/**
 * Свернутая иерархия классов помещаемых на виселицу
 */
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
        String getSprite(GallowsField g);
    }

    public static final List<Sprites> rowSprites = new ArrayList<>(List.of(
            BEAM::getSprite,
            GallowsSprites::getRowWithHeadSprites,
            GallowsSprites::getRowWithHandAndTorsoSprites,
            GallowsSprites::getRowWithFootAndSoleSprites,
            BASE::getSprite
    ));

    static private String getRowWithHeadSprites(GallowsField gallowsField) {
        return HEAD.getSprite(gallowsField) + PILLAR.getSprite(gallowsField);
    }

    static private String getRowWithHandAndTorsoSprites(GallowsField gallowsField) {
        return LEFT_HAND.getSprite(gallowsField) + TORSO.getSprite(gallowsField)
                + RIGHT_HAND.getSprite(gallowsField) + PILLAR.getSprite(gallowsField);
    }

    static private String getRowWithFootAndSoleSprites(GallowsField gallowsField) {
        return LEFT_SOLE.getSprite(gallowsField) + LEFT_FOOT.getSprite(gallowsField)
                + RIGHT_FOOT.getSprite(gallowsField) + RIGHT_SOLE.getSprite(gallowsField) + PILLAR.getSprite(gallowsField);
    }

    private String getSprite(GallowsField gallowsField) {
        return gallowsField.contains(this) ? present : empty;
    }
}
