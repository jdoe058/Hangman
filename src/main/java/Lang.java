public enum Lang {
    LANG_RU("^[А-ЯЁ]$", "words.txt") {
        public String get(MessagesRU message) {
            return message.get();
        }
        public String get(String name) {
            return MessagesRU.valueOf(name).get();
        }
    },

    LANG_EN("^[A-Z]$", "words_en.txt") {
        public String get(MessagesRU message) {
            return MessagesEN.valueOf(
                    message.name()).get();
        }
        public String get(String name) {
            return MessagesEN.valueOf(name).get();
        }
    };

    final public String regex;
    final public String fileName;

    Lang(String regex, String fileName) {
        this.regex = regex;
        this.fileName = fileName;
    }

    abstract public String get(MessagesRU message);
    abstract public String get(String name);
}
