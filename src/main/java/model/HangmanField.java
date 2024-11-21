package model;

import java.util.*;

public class HangmanField {
    final private Map<Cell, Hangman> field = new HashMap<>();
    final private Deque<Hangman> hangmanParts = new ArrayDeque<>(List.of(Hangman.values()));

    public boolean isHanged() {
        return hangmanParts.isEmpty();
    }

    public void hanging() {
        Hangman part = hangmanParts.poll();
        assert part != null;
        field.put(part.cell, part);
    }

    //TODO to HangmanFieldConsolePrepare?
    // GallowsField decorate
    public List<String> get() {
        List<String> list = new ArrayList<>();
        list.add("   +---+\t");
        for (int i = 0; i < Hangman.HEIGHT; i++) {
            StringBuilder s = new StringBuilder(" ");
            for (int j = 1- Hangman.HALF_WIDTH; j < Hangman.HALF_WIDTH; j++) {
                Cell cell = new Cell(i, j);
                s.append(field.containsKey(cell) ? field.get(cell).sprite : Hangman.EMPTY);
            }
            list.add(s.append(" |\t").toString());
        }
        list.add("+======+\t");
        return list;
    }
}
