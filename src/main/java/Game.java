
import java.util.*;

public class Game {
    public static final String LOSE_MESSAGE = "Вы проиграли!";
    public static final String WIN_MESSAGE = "Вы выиграли!";
    final Field field = new Field();
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;

    public Game(Scanner scanner, SecretWord secretWord) {
        this.secretWord = secretWord;
        render = new Render(field);
        dialog = new InputDialog(scanner);
    }

    void run() {
        Queue<String> blog = new ArrayDeque<>();
        while (!field.isHanged() && !secretWord.isSolved()) {
            blog.add("Слово: " + secretWord.getMaskedWord());
            blog.add("Промахи: " + field.getLetters());
            blog.add("Попадания: " + secretWord.getLetters());
            blog.add("Ввод: " + dialog.lastInput);
            render.render(blog);
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            field.nextStepHanging(x);
                        }
                    }, field::nextStepHanging
            );
        }
        blog.add("Слово: " + secretWord.getWord());
        blog.add("Промахи: " + field.getLetters());
        blog.add("Попадания: " + secretWord.getLetters());
        blog.add(field.isHanged() ? LOSE_MESSAGE : WIN_MESSAGE);
        render.render(blog);
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
