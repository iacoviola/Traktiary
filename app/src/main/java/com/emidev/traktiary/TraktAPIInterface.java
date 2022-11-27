package com.emidev.traktiary;

import com.emidev.traktiary.model.Trakt.Shows.Show;
import com.emidev.traktiary.model.Trakt.Trending.Trending;
import com.emidev.traktiary.model.Trakt.Watched.Watched;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TraktAPIInterface {

    @Headers({"Content-Type: application/json",
            "trakt-api-version: 2",
            "trakt-api-key: " + BuildConfig.TRAKT_API_KEY})
    @GET("shows/trending")
    Call<List<Trending>> getTrendingShows(@Query("page") Integer page);

    @Headers({"Content-Type: application/json",
            "trakt-api-version: 2",
            "trakt-api-key: " + BuildConfig.TRAKT_API_KEY})
    @GET("shows/popular")
    Call<List<Show>> getPopularShows(@Query("page") Integer page);

    @Headers({"Content-Type: application/json",
            "trakt-api-version: 2",
            "trakt-api-key: " + BuildConfig.TRAKT_API_KEY})
    @GET("shows/watched")
    Call<List<Watched>> getWatchedShows(@Query("page") Integer page);
}
