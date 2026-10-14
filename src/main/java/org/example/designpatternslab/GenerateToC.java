package org.example.designpatternslab;

public class GenerateToC implements Visitor {

    private TableOfContents tableOfContents = new TableOfContents();

    @Override
    public void visit(Book book) {
    }

    @Override
    public void visit(Section section) {
        tableOfContents.addEntry(section.getTitle());
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    @Override
    public void visit(ImageProxy imageProxy) {
    }

    @Override
    public void visit(Image image) {
    }

    @Override
    public void visit(Table table) {
    }

    public TableOfContents getToC() {
        return tableOfContents;
    }
}