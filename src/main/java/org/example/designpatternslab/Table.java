package org.example.designpatternslab;

import jakarta.persistence.Entity;

@Entity
public class Table extends Element {

    private String title;

    public Table() {
    }

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void render() {
        System.out.println("Table: " + title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}