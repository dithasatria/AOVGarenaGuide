package com.example.android.aovgarenaguide.rest;

import com.example.android.aovgarenaguide.model.select_hero.APIResponseSelectHero;
import com.example.android.aovgarenaguide.model.select_hero.detail_hero.APIResponseDetailHero;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DITHA on 16/09/2017.
 */

public interface APIService {

    @GET("Hero/selecthero.php")
    Call<APIResponseSelectHero> getHeroList();

    @GET("Hero/selectheroselection.php")
    Call<APIResponseSelectHero> getSelectionHeroList(
            @Query("role_hero") String role_hero
    );

    @GET("Hero/detailhero.php")
    Call<APIResponseDetailHero> getHeroDetail(
            @Query("id_hero") int id_hero
    );
}
