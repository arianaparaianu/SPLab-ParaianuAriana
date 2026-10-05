package org.example.designpatternslab;

public class TableOfContents implements Element {

    @Override
    public void print() {
        System.out.println("Table of Contents");
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}