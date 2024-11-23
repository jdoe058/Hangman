package models;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Dictionary {
    INSTANCE;

    private final Map<Resource, List<String>> storage = new HashMap<>();

    private record Resource(Theme theme, Language language) {
        public String path() {
            return "/%s_%s.txt".formatted(theme.name(), language.name());
        }
    }

    public List<String> get(Theme theme, Language language) throws DictionaryNotFountException {
        Resource resource = new Resource(theme, language);
        if (storage.containsKey(resource)) {
            return storage.get(resource);
        }

        List<String> list = loadResource(resource);
        storage.put(resource, list);
        return list;
    }

    private List<String> loadResource(Resource resource) throws DictionaryNotFountException {
        List<String> list = new ArrayList<>();
        try (InputStream is = Dictionary.class.getResourceAsStream(resource.path())) {
            if (is == null) {
                throw new DictionaryNotFountException("");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                list.addAll(List.of(line.split(" ")));
            }
        } catch (IOException e) {
            throw new DictionaryNotFountException(e.getMessage());
        }
        return list;
    }
}
