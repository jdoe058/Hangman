import java.util.Optional;
import java.util.Scanner;

public class InputDialog {
    final private Scanner scanner;
    public String lastInput;

    public InputDialog(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<Character> getLetter() {
        String line = scanner.nextLine().trim().toUpperCase();
        lastInput = line;
        return line.matches("^[А-ЯЁ]$")
                ? Optional.of(line.charAt(0))
                : Optional.empty();
    }
}
