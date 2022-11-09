package com.example.aplicationfinal.network;

import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.example.aplicationfinal.MainActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    public static Retrofit getClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
