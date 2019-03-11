package com.elpuig.pokemontgcapi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.elpuig.pokemontgcapi.model.Card;
import com.elpuig.pokemontgcapi.model.CardList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    PokemonCardAPI pokemonCardAPI;

    public Repository(){ pokemonCardAPI = CardapiModule.getApi();}

    public LiveData<List<Card>> getBasicos(){
        final MutableLiveData<List<Card>> basicos = new MutableLiveData<>();

        pokemonCardAPI.getBasicos().enqueue(new Callback<CardList>() {
            @Override
            public void onResponse(Call<CardList> call, Response<CardList> response) {
                basicos.setValue(response.body().cards);
            }

            @Override
            public void onFailure(Call<CardList> call, Throwable t) {

            }
        });
        return basicos;
    }

    public LiveData<List<Card>> getEvo1(){
        final MutableLiveData<List<Card>> evo1 = new MutableLiveData<>();

        pokemonCardAPI.getEvo1().enqueue(new Callback<CardList>() {
            @Override
            public void onResponse(Call<CardList> call, Response<CardList> response) {
                evo1.setValue(response.body().cards);
            }

            @Override
            public void onFailure(Call<CardList> call, Throwable t) {

            }
        });
        return evo1;
    }

    public LiveData<List<Card>> getEvo2(){
        final MutableLiveData<List<Card>> evo2 = new MutableLiveData<>();

        pokemonCardAPI.getEvo2().enqueue(new Callback<CardList>() {
            @Override
            public void onResponse(Call<CardList> call, Response<CardList> response) {
                evo2.setValue(response.body().cards);
            }

            @Override
            public void onFailure(Call<CardList> call, Throwable t) {

            }
        });
        return evo2;
    }
}
