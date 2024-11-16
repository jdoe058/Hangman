import java.util.Optional;
import java.util.Scanner;

public class InputDialog {
    final private Scanner scanner = new Scanner(System.in);
    final private Render render;

    public InputDialog(Render render) {
        this.render = render;
    }

    public Optional<Character> getLetter() {
        String line = scanner.nextLine().trim().toUpperCase();
        render.setFooter(" Ввод: " + line);
        return line.matches("^[А-ЯЁ]$")
                ? Optional.of(line.charAt(0))
                : Optional.empty();
    }
}
