import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        MessageCenter mc = new MessageCenter();

        Menu menu = new Menu(
                scanner,
                "Стартовый экран:",
                "Выберите пункт меню:",
                "Неверный ввод!"
        );

        menu.add("Сыграть на тяжелой сложности", () -> {
            scanner.nextLine();
            SecretWord secretWord = new SecretWord(dictionary.getRandomWord());
            Game game = new Game(scanner, "\tИгра виселица", secretWord, mc);
            game.init(3, 2);
            game.run();
        });

        AtomicBoolean isRunning = new AtomicBoolean(true);
        menu.add("Выход", () -> isRunning.set(false));

        while (isRunning.get()) {
            menu.show();
            menu.select();
        }
    }
}
