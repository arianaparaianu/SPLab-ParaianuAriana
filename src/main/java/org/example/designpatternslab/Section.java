package org.example.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {

    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void add(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException("Element already has a parent!");
        }

        elements.add(element);
        element.setParent(this);
    }

    @Override
    public void remove(Element element) {
        if (elements.remove(element)) {
            element.setParent(null);
        }
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    @Override
    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}