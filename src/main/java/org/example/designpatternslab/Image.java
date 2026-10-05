package org.example.designpatternslab;

public class Image implements Element {

    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + name);
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