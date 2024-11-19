import java.util.*;

public class Main {
    final private Scanner scanner = new Scanner(System.in);
    final private MessageCenter mc = new MessageCenter();
    final private Menu menu = new Menu(scanner, mc);
    final private Dictionary dictionary = new Dictionary();

    private Level level = Level.LEVEL_MEDIUM;
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
        return "%s, %s".formatted(mc.get(MessagesRU.GAME), mc.get(level.name()));
    }

    void back() {
    }

    void init() {

        dictionary.init();

        setLang(Lang.LANG_RU);

        Menu langMenu = new Menu(scanner, mc);
        langMenu.add(Lang.LANG_RU.name(), () -> setLang(Lang.LANG_RU));
        langMenu.add(Lang.LANG_EN.name(), () -> setLang(Lang.LANG_EN));
        langMenu.add(MessagesRU.MENU_BACK.name(), this::back);

        Menu levelMenu = new Menu(scanner, mc);
        levelMenu.add(Level.LEVEL_HIGH.name(), () -> setLevel(Level.LEVEL_HIGH));
        levelMenu.add(Level.LEVEL_MEDIUM.name(), () -> setLevel(Level.LEVEL_MEDIUM));
        levelMenu.add(Level.LEVEL_EASY.name(), () -> setLevel(Level.LEVEL_EASY));
        levelMenu.add(MessagesRU.MENU_BACK.name(), this::back);

        menu.add(MessagesRU.START.name(), () -> {
            scanner.nextLine();
            SecretWord secretWord = new SecretWord(dictionary.getRandomWord(lang));
            Game game = new Game(scanner, getTitle(), secretWord, mc, lang.regex);
            game.init(level.startOpenLetters);
            game.run();
        });

        menu.add(MessagesRU.MENU_LANGUAGE.name(), () -> {
            langMenu.setTitle(mc.get(MessagesRU.MENU_LANGUAGE));
            langMenu.show();
            langMenu.select();
        });

        menu.add(MessagesRU.MENU_LEVEL.name(), () -> {
            levelMenu.setTitle(mc.get(MessagesRU.MENU_LEVEL));
            levelMenu.show();
            levelMenu.select();
        });

        menu.add(MessagesRU.EXIT.name(), () -> isRunning = false);

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
