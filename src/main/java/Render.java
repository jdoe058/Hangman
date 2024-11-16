public class Render {
    final Field field;
    final SecretWord secretWord;
    private String footer = "";

    public Render(Field field, SecretWord secretWord) {
        this.field = field;
        this.secretWord = secretWord;
    }

    void clearFooter() {
        footer = "";
    }

    void setFooter(String s) {
        footer = s;
    }

    void render() {
        String[] strings = new String[5];
        strings[0] = "  +--+";
        strings[4] = "+====+";

        strings[1] = GallowsSprites.getTopPart(field)
                + "Слово: " + secretWord.getMaskedWord();
        strings[2] = GallowsSprites.getMiddlePart(field)
                + "Промахи (%d): %s".formatted(field.wrongLetters.size(), field.wrongLetters);
        strings[3] = GallowsSprites.getBottomPart(field) + footer;
        System.out.println(String.join("\n", strings));
    }
}
