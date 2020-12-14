package com.example.tencil.User;

public class CategoriesHelperClass {

    int image;
    String title;

    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
