package com.elpuig.pokemontgcapi.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elpuig.pokemontgcapi.GlideApp;
import com.elpuig.pokemontgcapi.R;
import com.elpuig.pokemontgcapi.model.Card;

import java.util.ArrayList;
import java.util.List;

public class BasicosListAdapter extends RecyclerView.Adapter<BasicosListAdapter.CardListViewHolder> {
    public List<Card> basicosList = new ArrayList<>();

    @NonNull
    @Override
    public CardListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListViewHolder holder, int position){
        Card card = basicosList.get(position);

        holder.name.setText(card.name);
        holder.id.setText(card.id);
        GlideApp.with(holder.itemView.getContext()).load(card.imageUrlHiRes).into(holder.imagen);
    }

    @Override
    public int getItemCount(){return basicosList.size();}

    class CardListViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView id;
        ImageView imagen;
        public CardListViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            imagen = itemView.findViewById(R.id.image);
        }
    }
}
