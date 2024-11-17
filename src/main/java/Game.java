
import java.util.*;

public class Game {
    public static final String LOSE_MESSAGE = "Вы проиграли!";
    public static final String WIN_MESSAGE = "Вы выиграли!";
    public static final String GIVING = "Попадания: ";
    public static final String INPUT = "Ввод: ";
    public static final String WORD = "Слово: ";
    public static final String MISS = "Промахи: ";

    final Gallows gallows;
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;
    final String title = "\tИгра Виселица";

    public Game(Scanner scanner, SecretWord secretWord) {
        this.secretWord = secretWord;
        gallows = new Gallows();
        render = new Render(gallows);
        dialog = new InputDialog(scanner);
    }

    public void init() {
        gallows.init();
        secretWord.openRandomLetter();
    }

    public void init(int start, int last) {
        gallows.init(start, last);
    }

    public void run() {
        while (!gallows.isHanged() && !secretWord.isSolved()) {
            render.render(blog(secretWord.getMaskedWord(), INPUT + dialog.getLastInput()));
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            gallows.nextStepHanging(x);
                        }
                    }, gallows::nextStepHanging
            );
        }
        render.render(blog(secretWord.getWord(), gallows.isHanged() ? LOSE_MESSAGE : WIN_MESSAGE));
    }

    private Queue<String> blog(String word, String footer) {
        Queue<String> result = new ArrayDeque<>();
        result.add(title);
        result.add(WORD + word);
        result.add(MISS + gallows.getLetters());
        result.add(GIVING + secretWord.getLetters());
        result.add(footer);
        return result;
    }
}
