import java.util.ArrayList;
import java.util.Queue;

public class Render {
    final Field field;

    public Render(Field field) {
        this.field = field;
    }

    void render(Queue<String> blog) {
        ArrayList<String> list = new ArrayList<>();
        list.add(GallowsSprites.getFirstSprite(field));
        list.add( GallowsSprites.getTwoSprite(field) + blog.poll());
        list.add(GallowsSprites.getThreeSprite(field) + blog.poll());
        list.add(GallowsSprites.getFourSprite(field) + blog.poll());
        list.add(GallowsSprites.getFiveSprite(field) + blog.poll());
        blog.clear();
        System.out.println(String.join("\n", list));
    }
}
