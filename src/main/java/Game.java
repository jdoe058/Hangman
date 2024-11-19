import java.util.*;

public class Game {
    final private HangmanField hangmanField = new HangmanField();
    final private SecretWord secretWord;
    final private SecretWordView SecretWordView;
    final private InputDialog dialog;
    final private String title;
    final private Lang lang;
    private boolean isOver = false;

    public Game(Scanner scanner, String title, SecretWord secretWord, Lang lang) {
        this.lang = lang;
        this.title = title;
        this.dialog = new InputDialog(scanner, lang.regex);
        this.secretWord = secretWord;
        this.SecretWordView = new SecretWordView(secretWord, lang);
    }

    public void init(int startOpenLetters) {
        while (startOpenLetters > 0) {
            startOpenLetters--;
            secretWord.openRandomLetter();
        }
    }

    public void run() {
        render();
        while (!isOver) {
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        if (!secretWord.check(x)) {
                            hangmanField.hanging();
                        }
                    }, hangmanField::hanging
            );
            render();
            check();
        }
        render();
    }

    private void render() {
        List<String> list = new ArrayList<>();
        List<String> hf = hangmanField.get();
        List<String> swv = SecretWordView.get(isOver);

        list.add(hf.get(0) + title);
        list.add(hf.get(1));
        list.add(hf.get(2) + swv.get(0));
        list.add(hf.get(3) + swv.get(1));
        list.add(hf.get(4) + swv.get(2));
        list.add(hf.get(5) + getFooterMessage());
        list.add("");

        System.out.println(String.join("\n", list));
    }

    private void check() {
        isOver = hangmanField.isHanged() || secretWord.isSolved();
    }

    private String getFooterMessage() {
        return isOver ?
                hangmanField.isHanged() ?
                        lang.rb.getString("LOSE") : lang.rb.getString("WIN")
                : lang.rb.getString("INPUT") + " " + dialog.getLastInput();
    }
}
