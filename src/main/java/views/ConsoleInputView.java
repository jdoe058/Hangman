package views;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    final private Scanner scanner;

    public ConsoleInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim().toUpperCase();
    }
}
