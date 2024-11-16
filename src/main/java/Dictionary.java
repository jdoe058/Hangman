import java.util.List;
import java.util.Random;

public class Dictionary {
    final private List<String> storage = List.of("работа", "проверка", "ошибка", "результат",
            "тестирование", "собака", "кошка", "дружок", "пирожок", "снежок");
    final private Random random = new Random();

    public String getRandomWord() {
        return storage.get(random.nextInt(storage.size()));
    }
}
