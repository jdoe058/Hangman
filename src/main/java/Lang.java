import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    LANG_RU("^[А-ЯЁ]$", "words.txt",
            ResourceBundle.getBundle("messages", new Locale("ru", "RU"))),

    LANG_EN("^[A-Z]$", "words_en.txt",
            ResourceBundle.getBundle("messages", Locale.US));

    final public String regex;
    final public String fileName;
    final public ResourceBundle rb;

    Lang(String regex, String fileName, ResourceBundle rb) {
        this.regex = regex;
        this.fileName = fileName;
        this.rb = rb;
    }
}
