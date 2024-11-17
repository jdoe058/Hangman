public class MessageCenter {
    private Lang lang = Lang.EN;

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public String get(MessagesRU message) {
        return lang.get(message);
    }
}
