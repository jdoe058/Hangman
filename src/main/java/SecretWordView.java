import java.util.ArrayList;
import java.util.List;

public class SecretWordView {
    final private SecretWord swc;
    final private MessageCenter mc;
    final private Game game;

    public SecretWordView(SecretWord swc, MessageCenter mc, Game game) {
        this.swc = swc;
        this.mc = mc;
        this.game = game;
    }

    public List<String> get() {
        List<String> list = new ArrayList<>();
        list.add(mc.get(MessagesRU.WORD) + swc.getMaskedWord(game.isOver(), "*", "_"));
        list.add(mc.get(MessagesRU.HITS) + " (%d) %s".formatted(
                swc.guessedLetters.size(), swc.guessedLetters));
        list.add(mc.get(MessagesRU.MISS) + " (%d) %s".formatted(
                swc.wrongLetters.size(), swc.wrongLetters));
        return list;
    }
}
