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
    private TextView pokemonWeight;
    private TextView pokemonHeight;
    private TextView pokemonAbilities;

    private String number;
    private String weight;
    private String height;
    private String abilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);

        id = (TextView)findViewById(R.id.pokemonId);
        pokemonHeight = (TextView)findViewById(R.id.pokemonHeight);
        pokemonWeight = (TextView)findViewById(R.id.pokemonWeight);
        pokemonAbilities = (TextView)findViewById(R.id.pokemonAbilities);
        imageView = (ImageView)findViewById(R.id.pokemonImage);

        Intent intent = getIntent();
        number = intent.getStringExtra("Number");
        weight = intent.getStringExtra("Weight");
        height = intent.getStringExtra("Height");
        abilities = intent.getStringExtra("Abilities");

        id.setText("ID: " + number);
        pokemonWeight.setText("Weight: " + weight + " kg");
        pokemonHeight.setText("Height: " + height + " cm");
        pokemonAbilities.setText("Abilities : " + abilities);
        Glide.with(this).load("http://pokeapi.co/media/sprites/pokemon/" + number + ".png").into(imageView);
    }
}
