package models;

import java.util.ArrayList;
import java.util.List;

public class LetterStorage {
    final private String delimiter;
    final private List<String> storage = new ArrayList<>();

    public LetterStorage(String delimiter) {
        this.delimiter = delimiter;
    }

    public void add(String letter) {
        if (storage.contains(letter)) {
            throw new ArrayStoreException("LetterStorage: letter %s is already in storage".formatted(letter));
        } else {
            storage.add(letter);
        }
    }

    public boolean contains(String letter) {
        return storage.contains(letter);
    }

    public int size() {
        return storage.size();
    }

    @Override
    public String toString() {
        return String.join(delimiter, storage);
    }
}
