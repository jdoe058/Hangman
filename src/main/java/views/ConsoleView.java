package views;

import models.Hangman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsoleView implements GroupView<String> {
    final private HangmanPictures hangmanPictures = new HangmanPictures();
    final private Hangman hangman;
    final private String delimiter;
    final private List<String> storage = new ArrayList<>();

    public ConsoleView(Hangman hangman, String delimiter) {
        this.hangman = hangman;
        this.delimiter = delimiter;
    }

    @Override
    public void add(String value) {
        storage.add(value);
    }

    @Override
    public void show() {
        Iterator<String> picture = hangmanPictures.get(hangman.getCurrentStageOfHanging()).iterator();
        Iterator<String> text = storage.iterator();

        System.out.println();
        while (picture.hasNext() && text.hasNext()) {
            System.out.println(picture.next() + delimiter + text.next());
        }

        while (picture.hasNext()) {
            System.out.println(picture.next());
        }

        storage.clear();
    }
}
