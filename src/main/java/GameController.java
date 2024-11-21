import model.HangmanField;
import model.Lang;
import model.SecretWord;

public class GameController {
    final private Lang lang;
    final private HangmanField hangmanField;
    final private SecretWord secretWord;

    public GameController(Lang lang, HangmanField hangmanField, SecretWord secretWord) {
        this.lang = lang;
        this.hangmanField = hangmanField;
        this.secretWord = secretWord;
    }

    boolean process (String line) {
        if (!line.matches(lang.regex) || !secretWord.check(line.charAt(0))) {
            hangmanField.hanging();
        }
        return hangmanField.isHanged() || secretWord.isSolved();
    }
}
