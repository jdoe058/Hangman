import java.util.ArrayList;
import java.util.List;

public class SecretWordView {
    final private SecretWord swc;
    final private MessageCenter mc;

    public SecretWordView(SecretWord swc, MessageCenter mc) {
        this.swc = swc;
        this.mc = mc;
    }

    public List<String> get(boolean isGameOver) {
        List<String> list = new ArrayList<>();
        list.add(mc.get(MessagesRU.WORD) + swc.getMaskedWord(isGameOver, "*", "_"));
        list.add(mc.get(MessagesRU.HITS) + " (%d) %s".formatted(
                swc.guessedLetters.size(), swc.guessedLetters));
        list.add(mc.get(MessagesRU.MISS) + " (%d) %s".formatted(
                swc.wrongLetters.size(), swc.wrongLetters));
        return list;
    }
}
