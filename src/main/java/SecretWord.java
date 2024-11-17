import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SecretWord {
    private static final int MASK = '_';
    private static final CharSequence DELIMITER = " ";
    final private String word;
    final private Set<Character> guessedLetters = new HashSet<>();

    public SecretWord(String word) {
        this.word = word.toUpperCase();
    }

    public String getLetters() {
        return "(%d) %s".formatted(guessedLetters.size(),guessedLetters);
    }

    public String getMaskedWord() {
        return word.chars()
                .map(x -> guessedLetters.contains((char)x) ? x : MASK)
                .mapToObj(Character::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    public String getWord() {
        return word.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    public boolean check(Character c) {
        if (word.contains(c.toString())) {
            guessedLetters.add(c);
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        return word.chars().allMatch(x -> guessedLetters.contains((char)x));
    }
}
