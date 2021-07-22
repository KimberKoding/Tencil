package uk.co.tencil.Businesses;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Businesses extends BusinessesResponse {
    //Model Class
    private final String business_name;
    private final String bdesc;
    private final String business_website;
    private final String business_website_social;
    private String careers;
    private final String business_img;
    private String contact;
    private final String videos;
    private String news;

    public Businesses(@Nullable String business_name,
                      @Nullable String bdesc,
                      @Nullable String business_website,
                      @Nullable String business_website_social,
                      @Nullable String business_img,
                      @Nullable String videos) {
        this.business_name = business_name;
        this.bdesc = bdesc;
        this.business_website = business_website;
        this.business_website_social = business_website_social;
        this.business_img = business_img;
        this.videos = videos;
    }

    @NonNull

    public String getBusiness_name() {
        assert business_name != null;
        return business_name;
    }

    @Nullable
    public String getBdesc() {
        return bdesc;
    }

    @Nullable
    public String getBusiness_website() {
        return business_website;
    }

    @Nullable
    public String getBusiness_website_social() {
        return business_website_social;
    }

    @Nullable
    public String getCareers() {
        return careers;
    }

    public void setCareers(@Nullable String careers) {
        this.careers = careers;
    }

    @Nullable
    public String getBusiness_img() {
        return business_img;
    }

    @Nullable
    public String getContact() {
        return contact;
    }

    public void setContact(@Nullable String contact) {
        this.contact = contact;
    }

    @Nullable
    public String getVideos() {
        return videos;
    }

    @Nullable
    public String getNews() {
        return news;
    }

    public void setNews(@Nullable String news) {
        this.news = news;
    }
}
