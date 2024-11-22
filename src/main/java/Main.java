import controllers.GameController;
import models.*;
import services.impl.LetterValidatorFactory;
import services.impl.MessageCenterFactory;
import views.*;

import java.util.*;

public class Main {
    Scanner scanner = new Scanner(System.in);

    void startGame() {
        Language language = Language.RU;
        Hangman hangman = new Hangman();
        GameController gameController = new GameController(
                hangman,
                new ConsoleView(hangman, "\t"),
                new ConsoleInputView(scanner),
                MessageCenterFactory.get(language),
                LetterValidatorFactory.get(language),
                new SecretWord("тестирование", "_", "*"));
        gameController.run();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
