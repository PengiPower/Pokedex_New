package com.example.pengi.pokedex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PokemonDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView id;
    private TextView pokemonName;

    private String name;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);

        pokemonName = (TextView)findViewById(R.id.pokemonName);
        id = (TextView)findViewById(R.id.pokemonId);
        imageView = (ImageView)findViewById(R.id.pokemonImage);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        number = intent.getIntExtra("Number", 1);
        pokemonName.setText("Name: " + name);
        id.setText("ID: " + number);
        Glide.with(this).load("http://pokeapi.co/media/sprites/pokemon/" + number + ".png").into(imageView);
    }
}
