import java.util.Scanner;

public class Main {
    final Scanner scanner = new Scanner(System.in);
    final MessageCenter mc = new MessageCenter();
    final Dictionary dictionary = new Dictionary();
    final Menu menu = new Menu(scanner, mc, "");

    private Level level = Level.MIDDLE;
    boolean isRunning;

    private void setLang(Lang lang) {
        mc.setLang(lang);
        menu.setTitle(getTitle());
    }

    private void setLevel(Level level) {
        this.level = level;
        menu.setTitle(getTitle());
    }

    private String getTitle() {
        return "%s, %s".formatted(mc.get(MessagesRU.GAME), mc.get(level.title));
    }

    void init() {

        setLang(Lang.RU);

        Menu langMenu = new Menu(scanner, mc, "");
        langMenu.add(MessagesRU.LANG_EN, () -> setLang(Lang.EN));
        langMenu.add(MessagesRU.LANG_RU, () -> setLang(Lang.RU));
        langMenu.add(MessagesRU.MENU_BACK, () -> {
        });

        Menu levelMenu = new Menu(scanner, mc, "");
        levelMenu.add(MessagesRU.LEVEL_HIGH, () -> setLevel(Level.HIGH));
        levelMenu.add(MessagesRU.LEVEL_MEDIUM, () -> setLevel(Level.MIDDLE));
        levelMenu.add(MessagesRU.LEVEL_EASY, () -> setLevel(Level.EASY));
        levelMenu.add(MessagesRU.MENU_BACK, () -> {
        });

        menu.add(MessagesRU.START, () -> {
            scanner.nextLine();
            SecretWord secretWord = new SecretWord(dictionary.getRandomWord());
            Game game = new Game(scanner, getTitle(), secretWord, mc);
            game.init(level.startOpenLetters, level.startHangingsCount, level.ignoreLastSprites);
            game.run();
        });

        menu.add(MessagesRU.MENU_LANGUAGE, () -> {
            langMenu.setTitle(mc.get(MessagesRU.MENU_LANGUAGE));
            langMenu.show();
            langMenu.select();
        });

        menu.add(MessagesRU.MENU_LEVEL, () -> {
            levelMenu.setTitle(mc.get(MessagesRU.MENU_LEVEL));
            levelMenu.show();
            levelMenu.select();
        });

        menu.add(MessagesRU.EXIT, () -> isRunning = false);

        isRunning = true;
    }

    void run() {
        while (isRunning) {
            menu.show();
            menu.select();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.run();
    }
}
