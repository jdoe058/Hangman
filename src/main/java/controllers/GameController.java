package controllers;

import models.*;
import services.LetterValidator;
import services.MessageCenter;
import views.GroupView;
import views.InputView;

public class GameController {
    final private Hangman hangman;
    final private GroupView<String> view;
    final private MessageCenter mc;
    final private InputView inputView;
    final private LetterValidator letterValidator;
    final private SecretWord secretWord;

    final private LetterStorage hits = new LetterStorage(", ");
    final private LetterStorage miss = new LetterStorage(", ");

    private int turnCount = 0;
    private String footer = "";
    private String lastInput = "";
    private String secretWordMask;

    public GameController(
            Hangman hangman,
            GroupView<String> view,
            InputView inputView,
            MessageCenter mc,
            LetterValidator letterValidator,
            SecretWord secretWord) {
        this.hangman = hangman;
        this.view = view;
        this.mc = mc;
        this.inputView = inputView;
        this.letterValidator = letterValidator;
        this.secretWord = secretWord;
    }

    public void run() {
        while (!isGameOver()) {
            secretWordMask = mc.maskMessage(secretWord.getMask());
            show();
            turnCount++;
            String letter = inputView.getInput(mc.inputLetterMessage());
            lastInput = mc.userInputMessage(letter);

            if (!letterValidator.isValid(letter)) {
                hangman.increaseHangingStage();
                footer = mc.invalidInputMessage();
                continue;
            }

            if (!secretWord.isLetterInWord(letter)) {
                hangman.increaseHangingStage();
                footer = mc.letterWasAlreadyThereMessage(letter);
                if (!miss.contains(letter)) {
                    miss.add(letter);
                    footer = mc.letterNotWordMessage(letter);
                }
                continue;
            }

            if (hits.contains(letter)) {
                hangman.increaseHangingStage();
                footer = mc.letterWasAlreadyThereMessage(letter);
                continue;
            }

            footer = mc.letterInWordMessage(letter);
            secretWord.openLetterMask(letter);
            hits.add(letter);
        }
        secretWordMask = mc.maskMessage(secretWord.getSecret());
        footer += " -> " + gameOverMessage();
        show();
    }

    boolean isGameOver() {
        return !hangman.isAlive() || secretWord.isSolved();
    }

    private void show() {
        view.add(mc.titleMessage() + mc.turnMessage(turnCount));
        view.add(secretWordMask);
        view.add(mc.hitsMessage(hits));
        view.add(mc.missMessage(miss));
        view.add(lastInput);
        view.add(footer);
        view.show();
    }

    private String gameOverMessage() {
        return hangman.isAlive() ? mc.winMessage() : mc.loseMessage();
    }
}
