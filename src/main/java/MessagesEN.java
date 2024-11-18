public enum MessagesEN {
    LOSE("You lost!"),
    WIN("You win!"),
    HITS("Hits: "),
    INPUT("Input: "),
    WORD("Word: "),
    MISS("Miss: "),
    GAME("Game Gallows"),
    START("Start"),
    EXIT("Exit"),
    LEVEL_HIGH("High difficulty"),
    LEVEL_MEDIUM("Medium difficulty"),
    LEVEL_EASY("Easy difficulty"),
    LANG_RU("Russian/Русский"),
    LANG_EN("English/Английский"),
    NOT_IMPLEMENTED("Not implemented"),
    MENU_BACK("Back"),
    MENU_LEVEL("Level selection"),
    MENU_LANGUAGE("Language selection"),
    MENU_SELECT("Select menu item:"),
    MENU_FAIL("Invalid input!");

    final private String message;

    MessagesEN(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
