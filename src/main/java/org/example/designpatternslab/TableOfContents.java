package org.example.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents extends Element {

    private List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        entries.add(entry);
    }

    @Override
    public void render() {
        System.out.println("Table of Contents");

        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}