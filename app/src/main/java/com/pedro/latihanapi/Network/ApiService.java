package com.pedro.latihanapi.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;


    public static Retrofit getUrl(){


       retrofit = new Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Retrofit getGlobal(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.kawalcorona.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


    public static Retrofit getNegara(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
