public enum Lang {
    RU("^[А-ЯЁ]$", "words.txt") {
        public String get(MessagesRU message) {
            return message.get();
        }
    },

    EN("^[A-Z]$", "words_en.txt") {
        public String get(MessagesRU message) {
            return MessagesEN.valueOf(
                    message.name())
                    .get();
        }
    };

    final public String regex;
    final public String fileName;

    Lang(String regex, String fileName) {
        this.regex = regex;
        this.fileName = fileName;
    }

    abstract public String get(MessagesRU message);
}
