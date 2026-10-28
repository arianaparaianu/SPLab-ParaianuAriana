package org.example.designpatternslab;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TableOfContents extends Element {

    @ElementCollection
    private List<String> entries = new ArrayList<>();

    public TableOfContents() {
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return entries;
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