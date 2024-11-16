
public class Game {
    Field field = new Field();
    Render render = new Render(field);
    InputDialog dialog = new InputDialog(render);

    void run() {
        while (!field.isHanged()) {
            render.render();
            render.clearFooter();
            dialog.getLetter().ifPresentOrElse(
                    x -> {
                        field.hang(x);
                    }, () -> {
                        field.hang();
                    }
            );
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
