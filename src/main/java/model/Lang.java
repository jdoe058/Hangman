package model;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    LANG_RU("^[А-ЯЁ]$", ResourceBundle.getBundle("messages", new Locale("ru", "RU"))),
    LANG_EN("^[A-Z]$", ResourceBundle.getBundle("messages", Locale.US));

    final public String regex;
    final public ResourceBundle rb;

    Lang(String regex, ResourceBundle rb) {
        this.regex = regex;
        this.rb = rb;
    }
}
