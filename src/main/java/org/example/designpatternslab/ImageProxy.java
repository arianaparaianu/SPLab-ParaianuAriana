package org.example.designpatternslab;

public class ImageProxy extends Element {

    private String imageName;
    private Image realImage;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(imageName);
        }
        return realImage;
    }

    @Override
    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}