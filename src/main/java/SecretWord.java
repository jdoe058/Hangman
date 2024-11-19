import java.util.*;

public class SecretWord {

    final public String word;
    final public Set<Character> guessedLetters = new HashSet<>();
    final public Set<Character> wrongLetters = new HashSet<>();

    public SecretWord(String word) {
        this.word = word.toUpperCase();
    }

    public String getMaskedWord(boolean isOver, String mask, String delimiter) {
        List<String> list = new ArrayList<>();
        for (char c : word.toCharArray()) {
            list.add(!isOver && !guessedLetters.contains(c) ? mask : String.valueOf(c));
        }
        return String.join(delimiter, list);
    }

    public boolean isSolved() {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(Character c) {
        if (word.contains(c.toString())) {
            guessedLetters.add(c);
            return true;
        } else {
            wrongLetters.add(c);
            return false;
        }
    }

    public void openRandomLetter() {
        Random random = new Random();
        guessedLetters.add(word.charAt(random.nextInt(word.length())));
    }
}
