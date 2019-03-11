package com.elpuig.pokemontgcapi;

import com.elpuig.pokemontgcapi.model.CardList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonCardAPI {
    @GET("cards?subtype=Basic")
    Call<CardList> getBasicos();

    @GET("cards?subtype=Stage%201")
    Call<CardList> getEvo1();

    @GET("cards?subtype=Stage%202")
    Call<CardList> getEvo2();
}
