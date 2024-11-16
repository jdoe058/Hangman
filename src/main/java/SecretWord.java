import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SecretWord {
    private static final int MASK = '_';
    private static final CharSequence DELIMITER = " ";
    final private String word;
    final public Set<Integer> guessedLetters = new HashSet<>();

    public SecretWord(String word) {
        this.word = word.toUpperCase();
    }

    public String getMaskedWord() {
        return word.chars()
                .map(x -> guessedLetters.contains(x) ? x : MASK)
                .mapToObj(Character::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    public boolean check(Character c) {
        if (word.contains(c.toString())) {
            guessedLetters.add(Integer.valueOf(c));
            return true;
        }
        return false;
    }

    boolean isSolved() {
        return word.chars().allMatch(guessedLetters::contains);
    }

    //TODO разобраться с наименованием и вынести константу
    public String getEndGameMessage() {
        return "загадано слово %s, отгадано букв %d".formatted(word, guessedLetters.size());
    }
}
