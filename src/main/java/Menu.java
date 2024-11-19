/**
 * https://t.me/zhukovsd_it_chat/53243/114908
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final static int START_ID = 1;

    private final Scanner scanner;
    private final MessageCenter mc;

    private String title;
    private int id = START_ID;
    private final List<Item> items = new ArrayList<>();

    public Menu(Scanner scanner, MessageCenter mc) {
        this.scanner = scanner;
        this.mc = mc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void add(String text, Action action) {
        Item item = new Item(id++, text, action);
        items.add(item);
    }

    public void show() {
        final String border = "---";
        System.out.println(title);
        System.out.println(border);
        for (Item item : items) {
            System.out.printf("%d. %s \n", item.id, mc.get(item.text));
        }
        System.out.println(border);
    }

    public void select() {

        while (true) {
            System.out.println(mc.get(MessagesRU.MENU_SELECT));
            String key = scanner.next();
            if (isInteger(key)) {
                int num = Integer.parseInt(key);
                if (num >= START_ID && num < id) {
                    Item item = items.get(num - START_ID);
                    item.action.execute();
                    break;
                }
            }
            System.out.println(mc.get(MessagesRU.MENU_FAIL));
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public interface Action {
        void execute();
    }

    private static class Item {
        public final int id;
        public final String text;
        public final Action action;

        public Item(int id, String text, Action action) {
            this.id = id;
            this.text = text;
            this.action = action;
        }
    }
}
