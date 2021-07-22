package uk.co.tencil.Businesses;

import androidx.annotation.Nullable;

import uk.co.tencil.Categories.Categories;

public class
JSONResponse {

    private Categories[] categories;

    public JSONResponse() {
    }

    @Nullable
    public Categories[] getCategories() {
        return categories;
    }


    public void setCategories(@Nullable Categories[] categories) {
        this.categories = categories;
    }
}
