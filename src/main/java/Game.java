import java.util.Scanner;

public class Game {
    public static final String LOSE_MESSAGE = "Вы проиграли! ";
    public static final String WIN_MESSAGE = "Вы выиграли! ";
    final Field field = new Field();
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;

    public Game(Scanner scanner, SecretWord secretWord) {
        this.secretWord = secretWord;
        render = new Render(field, secretWord);
        dialog = new InputDialog(scanner, render);
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
                ? LOSE_MESSAGE + secretWord.getEndGameMessage()
                : WIN_MESSAGE + field.getEndGameMessage());
        render.render();
    }

    //TODO логика элементарная, не вижу смысла выносить в отдельный класс
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            Game game = new Game(scanner, new SecretWord(dictionary.getRandomWord()));
            game.run();
            System.out.println("Сыграть еще раз? Да/Yes");
            line = scanner.next();
        } while (line.equalsIgnoreCase("да") || line.equalsIgnoreCase("yes"));
    }
}

