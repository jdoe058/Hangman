package views;

public class MenuGroupView extends Menu {
    private final GroupView<String> groupView;

    public MenuGroupView(Message title, Message selectMessage, Message failMessage,
                         GroupView<String> groupView) {
        super(title, selectMessage, failMessage);
        this.groupView = groupView;
    }

    public void show() {
//        final String border = "---";
        groupView.add(title.message());
//        System.out.println(border);
        for (Item item : items) {
            groupView.add("%d. %s".formatted(item.id, item.text.message()));
        }
        groupView.show();
//        System.out.println(border);
    }
}
