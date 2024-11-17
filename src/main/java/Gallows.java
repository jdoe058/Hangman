import java.util.*;

public class Gallows {
    final private Set<GallowsSprites> gallows = new HashSet<>();
    final private Queue<GallowsSprites> hangman = new ArrayDeque<>(List.of(GallowsSprites.values()));
    final private Set<Character> wrongLetters = new HashSet<>();

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

    public String getLetters() {
        return "(%d) %s".formatted(wrongLetters.size(), wrongLetters);
    }
}
