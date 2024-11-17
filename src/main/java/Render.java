import java.util.ArrayList;
import java.util.Queue;

public class Render {
    final Gallows gallows;

    public Render(Gallows gallows) {
        this.gallows = gallows;
    }

    void render(Queue<String> blog) {
        ArrayList<String> list = new ArrayList<>();
        for (var s : GallowsSprites.rowSprites) {
            list.add(s.getSprite(gallows) + blog.poll());
        }
        blog.clear();
        System.out.println(String.join("\n", list));
    }
}
