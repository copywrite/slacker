package com.copywrite.slacker.domain;

/**
 * Created by houmikado on 16/4/8.
 */
public enum Language {
    CHS("Chinese"),EN("English");
    private String name;

    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
