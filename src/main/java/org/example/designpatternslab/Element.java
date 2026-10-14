package org.example.designpatternslab;

public abstract class Element {

    private Section parent;

    public Section getParent() {
        return parent;
    }

    public void setParent(Section parent) {
        this.parent = parent;
    }

    public abstract void render();

    public abstract void accept(Visitor visitor);

    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}