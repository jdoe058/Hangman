import controllers.GameController;
import models.*;
import services.impl.LetterValidatorFactory;
import services.impl.MessageCenterFactory;
import views.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Language language = Language.RU;

        Hangman hangman = new Hangman();

        GameController gameController = new GameController(
                hangman,
                new ConsoleView(hangman, "\t"),
                new ConsoleInputView(new Scanner(System.in)),
                MessageCenterFactory.get(language),
                LetterValidatorFactory.get(language),
                new SecretWord("тестирование", "_", "*"));

        gameController.run();

    }
}
