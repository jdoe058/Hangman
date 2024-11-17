
import java.util.*;

public class Game {
    public static final String LOSE_MESSAGE = "Вы проиграли!";
    public static final String WIN_MESSAGE = "Вы выиграли!";
    public static final String GIVING = "Попадания: ";
    public static final String INPUT = "Ввод: ";
    public static final String WORD = "Слово: ";
    public static final String MISS = "Промахи: ";

    final Gallows gallows = new Gallows();
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;

    public Game(Scanner scanner, SecretWord secretWord) {
        this.secretWord = secretWord;
        render = new Render(gallows);
        dialog = new InputDialog(scanner);
    }

    void run() {
        Queue<String> blog = new ArrayDeque<>();
        while (!gallows.isHanged() && !secretWord.isSolved()) {
            blog.add(WORD + secretWord.getMaskedWord());
            blog.add(MISS + gallows.getLetters());
            blog.add(GIVING + secretWord.getLetters());
            blog.add(INPUT + dialog.getLastInput());
            render.render(blog);
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            gallows.nextStepHanging(x);
                        }
                    }, gallows::nextStepHanging
            );
        }
        blog.add(WORD + secretWord.getWord());
        blog.add(MISS + gallows.getLetters());
        blog.add(GIVING + secretWord.getLetters());
        blog.add(gallows.isHanged() ? LOSE_MESSAGE : WIN_MESSAGE);
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
