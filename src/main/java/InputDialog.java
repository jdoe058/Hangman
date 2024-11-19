import java.util.Optional;
import java.util.Scanner;

public class InputDialog {
    final private Scanner scanner;
    final private String regex;
    private String lastInput = "";

    public InputDialog(Scanner scanner, String regex) {
        this.scanner = scanner;
        this.regex = regex;
    }

    public String getLastInput() {
        return lastInput;
    }

    public Optional<Character> getLetter() {
        String line = scanner.nextLine().trim().toUpperCase();
        lastInput = line;
        return line.matches(regex)
                ? Optional.of(line.charAt(0))
                : Optional.empty();
    }
}
