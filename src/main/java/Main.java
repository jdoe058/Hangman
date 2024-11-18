import java.util.*;

public class Main {
    final private Scanner scanner = new Scanner(System.in);
    final private MessageCenter mc = new MessageCenter();
    final private Menu menu = new Menu(scanner, mc);
    final private Dictionary dictionary = new Dictionary();

    private Level level = Level.MIDDLE;
    private Lang lang;
    boolean isRunning;

    private void setLang(Lang lang) {
        this.lang = lang;
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

        dictionary.init();

        setLang(Lang.RU);

        Menu langMenu = new Menu(scanner, mc);
        langMenu.add(MessagesRU.LANG_EN, () -> setLang(Lang.EN));
        langMenu.add(MessagesRU.LANG_RU, () -> setLang(Lang.RU));
        langMenu.add(MessagesRU.MENU_BACK, () -> {
        });

        Menu levelMenu = new Menu(scanner, mc);
        levelMenu.add(MessagesRU.LEVEL_HIGH, () -> setLevel(Level.HIGH));
        levelMenu.add(MessagesRU.LEVEL_MEDIUM, () -> setLevel(Level.MIDDLE));
        levelMenu.add(MessagesRU.LEVEL_EASY, () -> setLevel(Level.EASY));
        levelMenu.add(MessagesRU.MENU_BACK, () -> {
        });

        menu.add(MessagesRU.START, () -> {
            scanner.nextLine();
            SecretWord secretWord = new SecretWord(dictionary.getRandomWord(lang));
            Game game = new Game(scanner, getTitle(), secretWord, mc, lang.regex);
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
