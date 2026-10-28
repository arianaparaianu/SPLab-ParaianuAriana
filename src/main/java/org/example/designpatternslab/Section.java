package org.example.designpatternslab;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends Element {

    private String title;

    @OneToMany(targetEntity = Element.class, cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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