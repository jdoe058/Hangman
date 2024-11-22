 /**
 * https://t.me/zhukovsd_it_chat/53243/114908
 */
//Menu это View
package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final static int START_ID = 1;

    private final String title;
    private final String selectMessage;
    private final String failMessage;

    private int id = START_ID;
    private final List<Item> items = new ArrayList<>();

    public Menu(String title, String selectMessage, String failMessage) {
        this.title = title;
        this.selectMessage = selectMessage;
        this.failMessage = failMessage;
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
            System.out.printf("%d. %s \n", item.id, item.text);
        }
        System.out.println(border);
    }

    public void select() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(selectMessage);
            String key = scanner.next();
            if (isInteger(key)) {
                int num = Integer.parseInt(key);
                if (num >= START_ID && num < id) {
                    Item item = items.get(num - START_ID);
                    item.action.execute();
                    break;
                }
            }
            System.out.println(failMessage);
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
