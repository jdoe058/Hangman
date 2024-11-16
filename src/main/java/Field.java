import java.util.*;

public class Field {
    final public Set<GallowsSprites> gallows = new HashSet<>();
    Queue<GallowsSprites> hangman = new ArrayDeque<>(List.of(GallowsSprites.values()));
    final public Set<Character> wrongLetters = new HashSet<>();

    public boolean isHanged() {
        return hangman.isEmpty();
    }

    public void nextStepHanging() {
        gallows.add(hangman.poll());
    }

    public void nextStepHanging(char letter) {
        wrongLetters.add(letter);
        nextStepHanging();
    }

    public boolean contains(GallowsSprites hangman) {
        return gallows.contains(hangman);
    }
}
