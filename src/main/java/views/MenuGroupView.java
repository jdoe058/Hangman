package views;

public class MenuGroupView extends Menu {
    private final GroupView<String> groupView;
    private final InputView inputView;

    public MenuGroupView(Message title, Message selectMessage, Message failMessage,
                         GroupView<String> groupView, InputView inputView) {
        super(title, selectMessage, failMessage);
        this.groupView = groupView;
        this.inputView = inputView;
    }

    public void show() {
        groupView.add(title.message());
        for (Item item : items) {
            groupView.add("%d. %s".formatted(item.id, item.text.message()));
        }
        groupView.show();
    }

    public void select() {
//        Scanner scanner = new Scanner(System.in);

        while (true) {
//            System.out.println(selectMessage.message());
//            String key = scanner.next();
            String key = inputView.getInput(selectMessage.message());
            if (isInteger(key)) {
                int num = Integer.parseInt(key);
                if (num >= START_ID && num < id) {
                    Item item = items.get(num - START_ID);
                    item.action.execute();
                    break;
                }
            }
            //todo !
            System.out.println(failMessage.message());
        }
    }
}
