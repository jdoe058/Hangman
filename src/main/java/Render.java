public class Render {
    final Field field;
    private String footer = "";

    public Render(Field field) {
        this.field = field;
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

        strings[1] = Hangman.getTopPart(field)
                + " Слово: ";
        strings[2] = Hangman.getMiddlePart(field)
                + " Неправильные буквы (%d): %s".formatted(field.wrongLetters.size(), field.wrongLetters);
        strings[3] = Hangman.getBottomPart(field) + footer;
        System.out.println(String.join("\n", strings));
    }
}
