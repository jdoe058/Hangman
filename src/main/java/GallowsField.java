import java.util.*;

public class GallowsField {
    final private Set<GallowsSprites> gallows = new HashSet<>();
    final private Deque<GallowsSprites> hangman = new ArrayDeque<>();

    public void init() {
        hangman.addAll(List.of(GallowsSprites.values()));
    }

    public void init(int startHangingsCount, int ignoreLastSprites) {
        init();

        for (int i = 0; i < startHangingsCount; i++) {
            nextStepHanging();
        }

        for (int i = 0; i < ignoreLastSprites; i++) {
            hangman.pollLast();
        }
    }

    public boolean isHanged() {
        return hangman.isEmpty();
    }

    public void nextStepHanging() {
        gallows.add(hangman.poll());
    }

    public boolean contains(GallowsSprites hangman) {
        return gallows.contains(hangman);
    }
}
