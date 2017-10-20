package com.example.android.aovgarenaguide.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DITHA on 16/09/2017.
 */

public class APIClient {
    private static final String BASE_URL = "http://igpdsd.pe.hu/AOVGuides/";
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitClient(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
