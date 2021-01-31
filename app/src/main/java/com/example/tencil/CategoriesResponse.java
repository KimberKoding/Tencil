package com.example.tencil;

import com.example.tencil.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse extends CategoriesHelperClass {
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("name")
    @Expose
    private String name;

    public CategoriesResponse(int image, String title) {
        super ( image, title );
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

