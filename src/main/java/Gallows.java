import java.util.*;

public class Gallows {
    final private Set<GallowsSprites> gallows = new HashSet<>();
    final private Deque<GallowsSprites> hangman = new ArrayDeque<>();
    final private Set<Character> wrongLetters = new HashSet<>();

    public void init() {
        hangman.addAll(List.of(GallowsSprites.values()));
    }

    //TODO по нормальному назвать параметры
    public void init(int start, int last) {
        init();

        for (int i = 0; i < start; i++) {
            nextStepHanging();
        }

        for (int i = 0; i < last; i++) {
            hangman.pollLast();
        }
    }

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
