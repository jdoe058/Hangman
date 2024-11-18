public enum MessagesRU {
    LOSE("Вы проиграли!"),
    WIN("Вы выиграли!"),
    HITS("Попадания: "),
    INPUT("Ввод: "),
    WORD("Слово: "),
    MISS("Промахи: "),
    GAME("Игра Виселица"),
    START("Начать"),
    EXIT("Выход"),
    LEVEL_HIGH("Высокая сложность"),
    LEVEL_MEDIUM("Средняя сложность"),
    LEVEL_EASY("Низкая сложность"),
    LANG_RU("Russian/Русский"),
    LANG_EN("English/Английский"),
    NOT_IMPLEMENTED("Не реализовано"),
    MENU_BACK("Назад"),
    MENU_LEVEL("Выбор уровня"),
    MENU_LANGUAGE("Выбор языка"),
    MENU_SELECT("Выберите пункт меню:"),
    MENU_FAIL("Неверный ввод!");

    final String message;

    MessagesRU(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
