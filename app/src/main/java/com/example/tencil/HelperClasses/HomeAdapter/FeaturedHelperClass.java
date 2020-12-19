package com.example.tencil.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    int image;
    String title, description;

    //SETTER
    public FeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;

    }

    //GETTER
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
