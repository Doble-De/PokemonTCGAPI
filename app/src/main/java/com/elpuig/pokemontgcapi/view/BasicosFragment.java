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

public class BasicosFragment extends Fragment {
    ViewModel viewModel;
    private BasicosListAdapter basicosListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basicos, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerbasicos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        basicosListAdapter = new BasicosListAdapter();
        recyclerView.setAdapter(basicosListAdapter);
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getBasicos().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cards) {
                basicosListAdapter.basicosList = cards;
                basicosListAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}
