package com.emidev.traktiary;

import com.emidev.traktiary.model.Trending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIInterface {

    @Headers({"Content-Type: application/json",
            "trakt-api-version: 2",
            "trakt-api-key: NOPE"})
    @GET("shows/trending")
    Call<List<Trending>> getTrendingShows();
}
