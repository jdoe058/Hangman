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

    public String getSprite(Cell cell) {
        return field.containsKey(cell) ? field.get(cell).sprite : Hangman.EMPTY;
    }
}
