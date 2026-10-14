package org.example.designpatternslab;

public class Table extends Element {

    private String title;

    public Table(String title) {
        this.title = title;
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