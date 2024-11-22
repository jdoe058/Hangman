package services;

import models.Language;
import models.LetterStorage;
import models.Level;
import models.Theme;

public interface MessageCenter {
    String maskMessage(String word);

    String hitsMessage(LetterStorage letters);

    String missMessage(LetterStorage letters);

    String inputLetterMessage();

    String invalidInputMessage();

    String userInputMessage(String string);

    String letterInWordMessage(String string);

    String letterNotWordMessage(String string);

    String letterWasAlreadyThereMessage(String string);

    String titleMessage();

    String turnMessage(int turn);

    String winMessage();

    String loseMessage();

    String menuFailMessage();

    String menuSelectMessage();

    String menuExitMessage();

    String menuStartMessage();

    String menuLevelMessage();

    String menuLanguageMessage();

    String menuThemeMessage();

    String enumValueMessage(Language language);

    String enumValueMessage(Level level);

    String enumValueMessage(Theme theme);

    String enterSomethingToContinue();
}
