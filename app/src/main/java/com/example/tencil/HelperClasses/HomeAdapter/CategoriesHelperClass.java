package com.example.tencil.HelperClasses.HomeAdapter;

public class CategoriesHelperClass {
    static int image;
    static String title;

    //SETTER
    public CategoriesHelperClass(int image, String title) {
        CategoriesHelperClass.image = image;
        CategoriesHelperClass.title = title;
    }

    //GETTER
    public static int getImage() {
        return image;
    }

    public static String getTitle() {
        return title;
    }


}

