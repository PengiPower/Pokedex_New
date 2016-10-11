package com.example.pengi.pokedex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> pokemon;
    private Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
        pokemon = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Pokemon p = pokemon.get(position);
        holder.textView.setText(p.getName());

        Glide.with(context).load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png").into(holder.imageView);
        //WTF
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PokemonDetails.class);
                intent.putExtra("Number", p.getNumber());
                intent.putExtra("Weight", p.getWeight());
                intent.putExtra("Height", p.getHeight());
                intent.putExtra("Abilities", p.getAbilities());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public void addPokemonList(ArrayList<Pokemon> list) {
        pokemon.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.nameTextView);
        }

    }
}
