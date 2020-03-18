package model;

import utils.StringUtils;

import java.util.*;

public class PlayerNames implements Iterable<String> {
    private static final String COMMA = ",";

    private final List<String> names;

    public PlayerNames(String input) {
        validate(input);
        names = Arrays.asList(StringUtils.trimString(input).split(COMMA));
    }

    private void validate(String input) {
        StringUtils.validateNull(input);
        validateSplit(input);
    }

    private void validateSplit(String input) {
        String[] names = input.split(COMMA);
        for (String name : names) {
            StringUtils.validateEmpty(name);
        }
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    @Override
    public Iterator<String> iterator() {
        return names.iterator();
    }
}
