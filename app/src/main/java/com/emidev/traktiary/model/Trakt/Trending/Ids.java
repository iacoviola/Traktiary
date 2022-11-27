
package com.emidev.traktiary.model.Trakt.Trending;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Ids {

    @SerializedName("trakt")
    @Expose
    private Integer trakt;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("tvdb")
    @Expose
    private Integer tvdb;
    @SerializedName("imdb")
    @Expose
    private String imdb;
    @SerializedName("tmdb")
    @Expose
    private Integer tmdb;
    @SerializedName("tvrage")
    @Expose
    private Integer tvrage;

    public Integer getTrakt() {
        return trakt;
    }

    public void setTrakt(Integer trakt) {
        this.trakt = trakt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getTvdb() {
        return tvdb;
    }

    public void setTvdb(Integer tvdb) {
        this.tvdb = tvdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public Integer getTmdb() {
        return tmdb;
    }

    public void setTmdb(Integer tmdb) {
        this.tmdb = tmdb;
    }

    public Integer getTvrage() {
        return tvrage;
    }

    public void setTvrage(Integer tvrage) {
        this.tvrage = tvrage;
    }

}
