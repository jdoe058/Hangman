public enum Level {
    HIGH(MessagesRU.LEVEL_HIGH, 0, 3, 2),
    MIDDLE(MessagesRU.LEVEL_MEDIUM, 1, 3, 0),
    EASY(MessagesRU.LEVEL_EASY, 2, 0, 0);

    final public MessagesRU title;
    final public int startOpenLetters;
    final public int startHangingsCount;
    final public int ignoreLastSprites;

    Level(MessagesRU title, int startOpenLetters, int startHangingsCount, int ignoreLastSprites) {
        this.title = title;
        this.startOpenLetters = startOpenLetters;
        this.startHangingsCount = startHangingsCount;
        this.ignoreLastSprites = ignoreLastSprites;
    }
}
