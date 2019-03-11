package com.elpuig.pokemontgcapi.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elpuig.pokemontgcapi.R;
import com.elpuig.pokemontgcapi.ViewModel;
import com.elpuig.pokemontgcapi.model.Card;

import java.util.List;

public class Evo2Fragment extends Fragment {
    ViewModel viewModel;
    private Evo2ListAdapter evo2ListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_evo2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerevo2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        evo2ListAdapter = new Evo2ListAdapter();
        recyclerView.setAdapter(evo2ListAdapter);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getEvo2().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cards) {
                evo2ListAdapter.evo2List = cards;
                evo2ListAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

}
