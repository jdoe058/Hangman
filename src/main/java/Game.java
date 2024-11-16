
public class Game {
    final Field field = new Field();
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;

    public Game(SecretWord secretWord) {
        this.secretWord = secretWord;
        render = new Render(field, secretWord);
        dialog = new InputDialog(render);
    }

    void run() {
        while (!field.isHanged() && !secretWord.isSolved()) {
            render.render();
            render.clearFooter();
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            field.nextStepHanging(x);
                        }
                    }, field::nextStepHanging
            );
        }
        render.setFooter(field.isHanged()
                ? "Вы проиграли, загадано слово %s, отгадано букв %d".formatted(secretWord.word, secretWord.guessedLetters.size())
                : "Вы выиграли, совершено промахов %d".formatted(field.wrongLetters.size()));
        render.render();
    }

    public static void main(String[] args) {
        Game game = new Game(new SecretWord("работа"));
        game.run();
    }
}
