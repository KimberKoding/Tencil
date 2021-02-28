package com.example.tencil;

public class Businesses extends BusinessesResponse {
    //Model Class
    private String business_id;
    private String business_name;
    private String cat_id;
    private String business_namesolo;
    private String business_desc;
    private String website;
    private String social_media;
    private int business_img;

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

    public String getBusiness_desc() {
        return business_desc;
    }

    public String getWebsite() {
        return website;
    }

    public String getSocial_media() {
        return social_media;
    }

    public int getBusiness_img() {
        return business_img;
    }

    public void setBusiness_img(int business_img) {
        this.business_img = business_img;
    }


}
