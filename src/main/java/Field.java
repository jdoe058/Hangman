import java.util.*;

public class Field {
    final public Set<Hangman> gallows = new HashSet<>();
    Queue<Hangman> hangedMan = new ArrayDeque<>(List.of(Hangman.values()));
    Set<Character> wrongLetters = new HashSet<>();

    public boolean isHanged() {
        return hangedMan.isEmpty();
    }

    public void hang() {
        gallows.add(hangedMan.poll());
    }

    public void hang (char letter) {
        wrongLetters.add(letter);
        hang();
    }

    public boolean contains(Hangman hangman) {
        return gallows.contains(hangman);
    }
}
