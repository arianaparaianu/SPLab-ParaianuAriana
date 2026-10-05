package org.example.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {

    private List<Author> authors = new ArrayList<>();
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + getTitle());
        System.out.println();

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }

        System.out.println();

        for (Element element : content) {
            element.print();
        }
    }
}