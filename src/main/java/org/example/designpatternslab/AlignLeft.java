package org.example.designpatternslab;

public class AlignLeft implements AlignStrategy {

    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("Left aligned: " + paragraph.getText());
    }
}