package uk.co.tencil.Businesses;

import androidx.annotation.NonNull;

public class Businesses extends BusinessesResponse {
    //Model Class
    private final String business_id;
    private final String business_name;
    private final String cat_id;
    private final String business_namesolo;
    private final String bdesc;
    private String business_website;
    private String business_website_social;
    private String careers;
    private String business_img;
    private String contact;
    private String videos;
    private String news;

    public Businesses(@NonNull String business_id,
                      @NonNull String business_name,
                      @NonNull String cat_id,
                      @NonNull String business_namesolo,
                      @NonNull String bdesc) {
        this.business_id = business_id;
        this.business_name = business_name;
        this.cat_id = cat_id;
        this.business_namesolo = business_namesolo;
        this.bdesc = bdesc;
    }


    @NonNull
    public String getBusiness_id() {
        return business_id;
    }

    @NonNull
    public String getBusiness_name() {
        return business_name;
    }

    @NonNull
    public String getCat_id() {
        return cat_id;
    }

    @NonNull
    public String getBusiness_namesolo() {
        return business_namesolo;
    }

    @NonNull
    public String getBdesc() {
        return bdesc;
    }

    @NonNull
    public String getBusiness_website() {
        return business_website;
    }

    public void setBusiness_website(@NonNull String business_website) {
        this.business_website = business_website;
    }

    @NonNull
    public String getBusiness_website_social() {
        return business_website_social;
    }

    public void setBusiness_website_social(@NonNull String business_website_social) {
        this.business_website_social = business_website_social;
    }

    @NonNull
    public String getCareers() {
        return careers;
    }

    public void setCareers(@NonNull String careers) {
        this.careers = careers;
    }

    @NonNull
    public String getBusiness_img() {
        return business_img;
    }

    public void setBusiness_img(@NonNull String business_img) {
        this.business_img = business_img;
    }

    @NonNull
    public String getContact() {
        return contact;
    }

    public void setContact(@NonNull String contact) {
        this.contact = contact;
    }

    @NonNull
    public String getVideos() {
        return videos;
    }

    public void setVideos(@NonNull String videos) {
        this.videos = videos;
    }

    @NonNull
    public String getNews() {
        return news;
    }

    public void setNews(@NonNull String news) {
        this.news = news;
    }


}
