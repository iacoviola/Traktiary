
package com.emidev.traktiary.model.Trakt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Trending {

    @SerializedName("watchers")
    @Expose
    private Integer watchers;
    @SerializedName("show")
    @Expose
    private Show show;

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}
