package com.example.tencil.HelperClasses.HomeAdapter;

public class CategoriesHelperClass {
    int image;
    String title;

    //SETTER
    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    //GETTER
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

}

