package com.elpuig.pokemontgcapi.view;

import android.arch.lifecycle.Observer;
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

public class Evo1Fragment extends Fragment {

    ViewModel viewModel;
    private Evo1ListAdapter evo1ListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evo1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerevo1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        evo1ListAdapter = new Evo1ListAdapter();
        recyclerView.setAdapter(evo1ListAdapter);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getEvo1().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cards) {
                evo1ListAdapter.evo1List = cards;
                evo1ListAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}
