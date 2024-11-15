public class Render {
    final Field field;

    public Render(Field field) {
        this.field = field;
    }

    void render() {
        String[] strings = new String[5];
        strings[0] = "  +--+";
        strings[4] = "+====+";

        strings[1] = Hangman.getTopPart(field) + " Слово: ";
        strings[2] = Hangman.getMiddlePart(field) + " Ошибки (%d): ".formatted(field.mistakes.size()) + field.mistakes;
        strings[3] = Hangman.getBottomPart(field);
        System.out.println(String.join("\n", strings));
    }
}
