
import java.util.*;

public class Game {
    final private GallowsField gallowsField;
    final private Render render;
    final private InputDialog dialog;
    final private SecretWord secretWord;
    final private MessageCenter mc;
    final private String title;
    private boolean isOver = false;

    final private SecretWordView swv;

    public Game(Scanner scanner, String title, SecretWord secretWord, MessageCenter mc, String regex) {
        this.mc = mc;
        this.title = title;
        this.secretWord = secretWord;
        gallowsField = new GallowsField();
        swv = new SecretWordView(secretWord, mc, this);
        render = new Render(gallowsField, swv);
        dialog = new InputDialog(scanner, regex);

    }

    public void init(int startOpenLetters, int startHangingsCount, int ignoreLastSprites) {
        gallowsField.init(startHangingsCount, ignoreLastSprites);
        while (startOpenLetters > 0) {
            startOpenLetters--;
            secretWord.openRandomLetter();
        }
    }

    public boolean isOver() {
        return isOver;
    }

    private void check() {
        isOver = gallowsField.isHanged() || secretWord.isSolved();
    }

    public void run() {
        while (!isOver) {
            check();
            render.render();
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            gallowsField.nextStepHanging();
                        }
                    }, gallowsField::nextStepHanging
            );
        }
    }
}
