package com.elpuig.pokemontgcapi;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.elpuig.pokemontgcapi.model.Card;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public LiveData<List<Card>> getBasicos(){ return repository.getBasicos();}
    public LiveData<List<Card>> getEvo1(){ return repository.getEvo1();}
    public LiveData<List<Card>> getEvo2(){ return repository.getEvo2();}
}
