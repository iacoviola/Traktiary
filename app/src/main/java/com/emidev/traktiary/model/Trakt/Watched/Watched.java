
package com.emidev.traktiary.model.Trakt.Watched;

import com.emidev.traktiary.model.Trakt.Shows.Show;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Watched {

    @SerializedName("watcher_count")
    @Expose
    private Integer watcher_count;
    @SerializedName("play_count")
    @Expose
    private Integer play_count;
    @SerializedName("collected_count")
    @Expose
    private Integer collected_count;
    @SerializedName("collector_count")
    @Expose
    private Integer collector_count;
    @SerializedName(value = "show", alternate = "movie")
    @Expose
    private Show show;

    public Integer getWatcher_count() {
        return watcher_count;
    }

    public void setWatcher_count(Integer watcher_count) {
        this.watcher_count = watcher_count;
    }

    public Integer getPlay_count() {
        return play_count;
    }

    public void setPlay_count(Integer play_count) {
        this.play_count = play_count;
    }

    public Integer getCollected_count() {
        return collected_count;
    }

    public void setCollected_count(Integer collected_count) {
        this.collected_count = collected_count;
    }

    public Integer getCollector_count() {
        return collector_count;
    }

    public void setCollector_count(Integer collector_count) {
        this.collector_count = collector_count;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
