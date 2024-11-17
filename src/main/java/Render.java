import java.util.ArrayList;
import java.util.Queue;

public class Render {
    final Gallows gallows;

    public Render(Gallows gallows) {
        this.gallows = gallows;
    }

    void render(Queue<String> blog) {
        ArrayList<String> list = new ArrayList<>();
        list.add(GallowsSprites.getFirstSprite(gallows));
        list.add( GallowsSprites.getTwoSprite(gallows) + blog.poll());
        list.add(GallowsSprites.getThreeSprite(gallows) + blog.poll());
        list.add(GallowsSprites.getFourSprite(gallows) + blog.poll());
        list.add(GallowsSprites.getFiveSprite(gallows) + blog.poll());
        blog.clear();
        System.out.println(String.join("\n", list));
    }
}
