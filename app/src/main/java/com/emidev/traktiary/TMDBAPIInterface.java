package com.emidev.traktiary;

import com.emidev.traktiary.model.TMDB.TMDBShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TMDBAPIInterface {

    @Headers({"Content-Type: application/json"})
    @GET("tv/{id}?api_key=" + BuildConfig.TMDB_API_KEY)
    Call<TMDBShow> getTMDBShow(@Path("id") int id);

    @Headers({"Content-Type: application/json"})
    @GET("movie/{id}?api_key=" + BuildConfig.TMDB_API_KEY)
    Call<TMDBShow> getTMDBMovie(@Path("id") int id);
}
