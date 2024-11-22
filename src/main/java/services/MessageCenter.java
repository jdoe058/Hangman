package services;

import models.LetterStorage;

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

    String titleMessage(int turn);
    String winMessage();
    String loseMessage();
}
