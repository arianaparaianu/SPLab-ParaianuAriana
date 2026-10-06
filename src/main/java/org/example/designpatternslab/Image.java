package org.example.designpatternslab;

public class Image extends Element {

    private String name;

    public Image(String name) {
        this.name = name;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + name);
    }
}