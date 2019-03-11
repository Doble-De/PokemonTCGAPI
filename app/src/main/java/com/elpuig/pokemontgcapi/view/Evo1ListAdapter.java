package com.elpuig.pokemontgcapi.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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

public class Evo1ListAdapter extends RecyclerView.Adapter<Evo1ListAdapter.CardViewHolder> {
    public List<Card> evo1List = new ArrayList<>();

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position){
        Card card = evo1List.get(position);

        holder.name.setText(card.name);
        holder.id.setText(card.id);
        GlideApp.with(holder.itemView.getContext()).load(card.imageUrlHiRes).into(holder.image);
    }

    @Override
    public int getItemCount(){return evo1List.size();}

    class CardViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView id;
        ImageView image;
        public CardViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            image = itemView.findViewById(R.id.image);
        }

    }

}

