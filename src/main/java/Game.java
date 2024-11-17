
import java.util.*;

public class Game {
    final Gallows gallows;
    final Render render;
    final InputDialog dialog;
    final SecretWord secretWord;
    final MessageCenter mc;
    final String title;

    public Game(Scanner scanner, String title, SecretWord secretWord, MessageCenter mc) {
        this.mc = mc;
        this.title = title;
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
            render.render(blog(secretWord.getMaskedWord(),
                    mc.get(MessagesRU.INPUT) + dialog.getLastInput()));
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            gallows.nextStepHanging(x);
                        }
                    }, gallows::nextStepHanging
            );
        }
        render.render(blog(secretWord.getWord(), mc.get(gallows.isHanged()
                ? MessagesRU.LOSE : MessagesRU.WIN)));
    }

    private Queue<String> blog(String word, String footer) {
        Queue<String> result = new ArrayDeque<>();
        result.add(title);
        result.add(mc.get(MessagesRU.WORD) + word);
        result.add(mc.get(MessagesRU.MISS) + gallows.getLetters());
        result.add(mc.get(MessagesRU.HITS) + secretWord.getLetters());
        result.add(footer);
        return result;
    }
}
