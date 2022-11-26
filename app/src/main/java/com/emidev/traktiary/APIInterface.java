package com.emidev.traktiary;

import com.emidev.traktiary.model.Trending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIInterface {

    @Headers({"Content-Type: application/json",
            "trakt-api-version: 2",
            "trakt-api-key: 338de75a0ffb0ea460fdcbb8f82b0b41bbeb8bde098f1a664e7fcfac6c736c07"})
    @GET("shows/trending")
    Call<List<Trending>> getTrendingShows();
}
