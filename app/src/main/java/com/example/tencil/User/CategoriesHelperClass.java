package com.example.tencil.User;

public class CategoriesHelperClass {

    static int image;
    static String title;

    public CategoriesHelperClass(int image, String title) {
        CategoriesHelperClass.image = image;
        CategoriesHelperClass.title = title;
    }

    public static String getTitle() {
        return title;
    }

    public static int getImage() {
        return image;
    }
}
