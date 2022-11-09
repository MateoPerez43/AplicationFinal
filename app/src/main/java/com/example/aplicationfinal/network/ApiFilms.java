package com.example.aplicationfinal.network;

import com.example.aplicationfinal.model.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiFilms {
    @GET("films")
    Call<List<Films>> getFilms();

}
