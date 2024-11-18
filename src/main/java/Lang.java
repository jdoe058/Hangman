public enum Lang {
    RU {
        public String get(MessagesRU message) {
            return message.get();
        }
    },
    EN {
        public String get(MessagesRU message) {
            return MessagesEN.valueOf(
                    message.name())
                    .get();
        }
    };
    abstract public String get(MessagesRU message);
}
