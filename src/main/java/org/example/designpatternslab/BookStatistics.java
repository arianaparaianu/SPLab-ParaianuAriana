package org.example.designpatternslab;

public class BookStatistics implements Visitor {

    private int numberOfImages = 0;
    private int numberOfTables = 0;
    private int numberOfParagraphs = 0;

    @Override
    public void visit(Book book) {
    }

    @Override
    public void visit(Section section) {
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
        numberOfParagraphs++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        numberOfImages++;
    }

    @Override
    public void visit(Image image) {
        numberOfImages++;
    }

    @Override
    public void visit(Table table) {
        numberOfTables++;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages);
        System.out.println("*** Number of tables: " + numberOfTables);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs);
    }
}