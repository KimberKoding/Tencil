package com.example.tencil;

public class Businesses extends BusinessesResponse {
    //Model Class
    private String business_id;
    private String business_name;
    private String cat_id;
    private String business_namesolo;
    private String bdesc;
    private String website;
    private String social_media;
    private String business_img;

    public String getBusiness_id() {
        return business_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public String getCat_id() {
        return cat_id;
    }

    public String getBusiness_namesolo() {
        return business_namesolo;
    }

    public String getBdesc() {
        return bdesc;
    }

    public String getWebsite() {
        return website;
    }

    public String getSocial_media() {
        return social_media;
    }

    public String getBusiness_img() {
        return business_img;
    }

    public void setBusiness_img(String business_img) {
        this.business_img = business_img;
    }


}
