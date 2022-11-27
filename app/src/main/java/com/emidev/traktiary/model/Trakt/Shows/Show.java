
package com.emidev.traktiary.model.Trakt.Shows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Show {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("ids")
    @Expose
    private Ids ids;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Ids getIds() {
        return ids;
    }

    public void setIds(Ids ids) {
        this.ids = ids;
    }

}
