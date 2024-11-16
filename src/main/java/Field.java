import java.util.*;

public class Field {
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

    //TODO разобраться с наименованием и вынести константу
    public String getTurnGameMessage() {
        return "Промахи (%d): %s".formatted(wrongLetters.size(), wrongLetters);
    }

    //TODO разобраться с наименованием и вынести константу
    public String getEndGameMessage() {
        return "Cовершено промахов %d".formatted(wrongLetters.size());
    }
}
