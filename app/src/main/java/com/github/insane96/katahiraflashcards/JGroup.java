package com.github.insane96.katahiraflashcards;

import java.util.List;

public class JGroup {
    public String name;
    public List<JChar> charList;

    public JGroup(String name) {
        this.name = name;
    }

    public void addChar(JChar jChar) {
        this.charList.add(jChar);
    }
}
