package com.example.moviedbmyapp.api;

import com.example.moviedbmyapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") int pageIndex);

    @GET("genre/movie/list")
    Call<MovieResponse> getGenres(@Query("api_key") String apiKey);



}
