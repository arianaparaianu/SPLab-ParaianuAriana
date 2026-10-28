package org.example.designpatternslab;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends Element {

    private String imageName;

    @Transient
    private Image realImage;

    public ImageProxy() {
    }

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
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