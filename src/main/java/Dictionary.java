import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Dictionary {
    final private Map<Lang, List<String>> storage = new HashMap<>();
    final private Random random = new Random();

    public String getRandomWord(Lang lang) {
        var list = storage.get(lang);
        return list.get(random.nextInt(list.size()));
    }

    public void init() {
        for (var lang : Lang.values()) {
            try {
                var path = Paths.get(Objects.requireNonNull(
                        Main.class.getClassLoader().getResource(lang.fileName)).toURI());
                var list = Files.lines(path, StandardCharsets.UTF_8).
                        flatMap(x -> Arrays.stream(x.split(" "))).toList();
                storage.put(lang, list);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
