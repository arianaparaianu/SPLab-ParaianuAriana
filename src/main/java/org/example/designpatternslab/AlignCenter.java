package org.example.designpatternslab;

public class AlignCenter implements AlignStrategy {

    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("Center aligned: " + paragraph.getText());
    }
}