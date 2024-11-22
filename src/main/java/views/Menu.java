 /*
 * https://t.me/zhukovsd_it_chat/53243/114908
 */
//Menu это View
package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final static int START_ID = 1;

    protected final Message title;
    protected final Message selectMessage;
    protected final Message failMessage;

    protected int id = START_ID;
    protected final List<Item> items = new ArrayList<>();

    public Menu(Message title, Message selectMessage, Message failMessage) {
        this.title = title;
        this.selectMessage = selectMessage;
        this.failMessage = failMessage;
    }

    public void add(Message text, Action action) {
        Item item = new Item(id++, text, action);
        items.add(item);
    }

    public void show() {
        final String border = "---";
        System.out.println(title.message());
        System.out.println(border);
        for (Item item : items) {
            System.out.printf("%d. %s \n", item.id, item.text.message());
        }
        System.out.println(border);
    }

    public void select() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(selectMessage.message());
            String key = scanner.next();
            if (isInteger(key)) {
                int num = Integer.parseInt(key);
                if (num >= START_ID && num < id) {
                    Item item = items.get(num - START_ID);
                    item.action.execute();
                    break;
                }
            }
            System.out.println(failMessage.message());
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

    public interface Message {
        String message();
    }

    protected static class Item {
        public final int id;
        public final Message text;
        public final Action action;

        public Item(int id, Message text, Action action) {
            this.id = id;
            this.text = text;
            this.action = action;
        }
    }
}
