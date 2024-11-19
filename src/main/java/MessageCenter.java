public class MessageCenter {
    private Lang lang;

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    // очень частые вызовы, хотел вообще одну букву оставить
    public String get(MessagesRU message) {
        return lang.get(message);
    }

    public String get(String name) {
        return lang.get(name);
    }
}
