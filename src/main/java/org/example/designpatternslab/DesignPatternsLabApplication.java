package org.example.designpatternslab;

public class DesignPatternsLabApplication {

    public static void main(String[] args) throws Exception {

        Book myBook = new Book("My Book");

        Section cap1 = new Section("Capitolul 1");
        Section cap2 = new Section("Capitolul 2");
        Section cap3 = new Section("Capitolul 3");

        cap1.add(new Paragraph("Paragraph 1"));
        cap2.add(new Paragraph("Paragraph 2"));
        cap3.add(new Paragraph("Paragraph 3"));

        myBook.addContent(cap1);
        myBook.addContent(cap2);
        myBook.addContent(cap3);

        GenerateToC generateToC = new GenerateToC();

        myBook.accept(generateToC);

        TableOfContents toc = generateToC.getToC();

        toc.render();
    }
}