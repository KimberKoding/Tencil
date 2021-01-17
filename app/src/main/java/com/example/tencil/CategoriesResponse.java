package com.example.tencil;

public class CategoriesResponse {
    private int cat_id;
    private String category;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoriesResponse{" +
                "cat_id=" + cat_id +
                ", category='" + category + '\'' +
                '}';
    }
}

