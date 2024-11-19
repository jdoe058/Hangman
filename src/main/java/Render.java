import java.util.ArrayList;
import java.util.List;

public class Render {
    final private GallowsField gallowsField;
    final private SecretWordView swv;


    public Render(GallowsField gallowsField, SecretWordView swv) {
        this.gallowsField = gallowsField;
        this.swv = swv;
    }

    void render() {
        List<String> list = new ArrayList<>();
        List<String> blog = swv.get();

        int i = 0;
        for (var s : GallowsSprites.rowSprites) {
            var ss = s.getSprite(gallowsField);
            if (i < 3) {
                ss +=  blog.get(i++);
            }
            list.add(ss);
        }
        System.out.println(String.join("\n", list));
    }
}
