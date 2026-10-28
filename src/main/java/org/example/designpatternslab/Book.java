package org.example.designpatternslab;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Section {

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void render() {
        System.out.println("Book: " + getTitle());
        System.out.println();

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }

        System.out.println();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (int i = 0; ; i++) {
            try {
                get(i).accept(visitor);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }
}