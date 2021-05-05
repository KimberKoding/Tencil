package uk.co.tencil.Businesses;

public class Businesses extends BusinessesResponse {
    //Model Class
    private String business_id;
    private String business_name;
    private String cat_id;
    private String business_namesolo;
    private String bdesc;
    private String business_website;
    private String business_website_social;
    private String careers;
    private String business_img;
    private String contact;
    private String videos;
    private String news;


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

    public String getBusiness_website() {
        return business_website;
    }

    public void setBusiness_website(String business_website) {
        this.business_website = business_website;
    }

    public String getBusiness_website_social() {
        return business_website_social;
    }

    public void setBusiness_website_social(String business_website_social) {
        this.business_website_social = business_website_social;
    }

    public String getCareers() {
        return careers;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }

    public String getBusiness_img() {
        return business_img;
    }

    public void setBusiness_img(String business_img) {
        this.business_img = business_img;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
