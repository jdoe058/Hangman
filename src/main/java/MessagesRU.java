public enum MessagesRU {
    LOSE("Вы проиграли!"),
    WIN("Вы выиграли!"),
    HITS("Попадания: "),
    INPUT("Ввод: "),
    WORD("Слово: "),
    MISS("Промахи: ");

    final String message;

    MessagesRU(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
