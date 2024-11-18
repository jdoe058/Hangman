import java.util.List;
import java.util.Random;

public enum Lang {
    RU(Dictionary.storage, "^[А-ЯЁ]$") {
        public String get(MessagesRU message) {
            return message.get();
        }
    },

    EN(Dictionary.storageEN, "^[A-Z]$") {
        public String get(MessagesRU message) {
            return MessagesEN.valueOf(
                    message.name())
                    .get();
        }
    };

    final private List<String> dictionary;
    final public String regex;

    Lang(List<String> dictionary, String regex) {
        this.dictionary = dictionary;
        this.regex = regex;
    }

    abstract public String get(MessagesRU message);
    static private final Random random = new Random();

    public String getRandomWord() {
        return dictionary.get(random.nextInt(dictionary.size()));
    }
}
