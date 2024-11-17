public enum MessagesEN {
    LOSE("You lost!"),
    WIN("You win!"),
    HITS("Hits: "),
    INPUT("Input: "),
    WORD("Word: "),
    MISS("Miss: ");

    final private String message;

    MessagesEN(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
