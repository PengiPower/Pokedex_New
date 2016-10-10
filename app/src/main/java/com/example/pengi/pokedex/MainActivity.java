package com.example.pengi.pokedex;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private int offset;
    private boolean isEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (isEnd) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, "onScrollListener");
                            isEnd = false;
                            offset += 20;
                            getData(offset);
                        }
                    }
                }
            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        isEnd = true;
        offset = 0;
        getData(offset);
    }

    private void getData(int offset) {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokedex> pokedex = service.getPokemon(20, offset);

        pokedex.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                isEnd = true;
                if (response.isSuccessful()) {

                    Pokedex pokemonRespuesta = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonRespuesta.getResults();

                    pokemonAdapter.addPokemonList(pokemonList);

                } else {
                    Log.e(TAG, "onResponse");
                }
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                isEnd = true;
                Log.e(TAG, "onFailure");
            }
        });
    }
}
