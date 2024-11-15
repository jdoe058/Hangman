import java.util.*;

public class Field {
    final public Set<Hangman> values = new HashSet<>();
    Queue<Hangman> queue = new ArrayDeque<>(List.of(Hangman.values()));
    Set<Character> mistakes = new HashSet<>();

    public boolean contains(Hangman hangman) {
        return values.contains(hangman);
    }
}
